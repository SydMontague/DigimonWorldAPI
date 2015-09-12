package de.phoenixstaffel.dmw;

import java.util.ArrayList;
import java.util.List;

import com.sun.jna.Memory;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import com.sun.jna.ptr.IntByReference;

import de.phoenixstaffel.dmw.core.StringPointer;
import de.phoenixstaffel.dmw.core.StructureElement;
import de.phoenixstaffel.dmw.jna.Kernel32;
import de.phoenixstaffel.dmw.jna.User32;

/*
 * TODO ePSXe version detection and automatic adaption of the addresses
 * TODO detect the startup of ePSXe
 * TODO support for OS X and Linux
 * TODO update to allow the use of in-memory pointer, either by own functions or by automatic detection
 */
public class MemoryAccess {
    private static int BYTE_SIZE = 1;
    private static int SHORT_SIZE = 2;
    private static int INT_SIZE = 4;
    private static int LONG_SIZE = 8;
    
    private static int PROCESS_VM_READ = 0x0010;
    private static int PROCESS_VM_WRITE = 0x0020;
    private static int PROCESS_VM_OPERATION = 0x0008;
    
    private static long BASE_ADDRESS = 0xA579A0;
    
    private Kernel32 kernel = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class);
    private User32 user = (User32) Native.loadLibrary("user32", User32.class);
    
    private int pid;
    private HANDLE process;
    
    public MemoryAccess() {
        IntByReference value = new IntByReference(0);
        user.GetWindowThreadProcessId(user.FindWindowA(null, "ePSXe - Enhanced PSX emulator"), value);
        pid = value.getValue();
        
        process = kernel.OpenProcess(PROCESS_VM_READ | PROCESS_VM_WRITE | PROCESS_VM_OPERATION, false, pid);
    }
    
    public long convertGameAddress(int address) {
        long localAddress = address & 0x00FFFFFF;
        return localAddress + BASE_ADDRESS;
    }
    
    public byte readByte(long address) {
        Memory memory = new Memory(BYTE_SIZE);
        kernel.ReadProcessMemory(process, new Pointer(address), memory, BYTE_SIZE, null);
        
        return memory.getByte(0);
    }
    
    public short readShort(long address) {
        Memory memory = new Memory(SHORT_SIZE);
        kernel.ReadProcessMemory(process, new Pointer(address), memory, SHORT_SIZE, null);
        
        return memory.getShort(0);
    }
    
    public int readInteger(long address) {
        Memory memory = new Memory(INT_SIZE);
        kernel.ReadProcessMemory(process, new Pointer(address), memory, INT_SIZE, null);
        
        return memory.getInt(0);
    }
    
    public long readLong(long address) {
        Memory memory = new Memory(LONG_SIZE);
        kernel.ReadProcessMemory(process, new Pointer(address), memory, LONG_SIZE, null);
        
        return memory.getLong(0);
    }
    
    public String readString(long address, int lenght) {
        Memory memory = new Memory(lenght);
        kernel.ReadProcessMemory(process, new Pointer(address), memory, lenght, null);
        
        return memory.getString(0);
    }
    
    public List<String> readStringArray(long address, int lenght) {
        Memory memory = new Memory(lenght);
        kernel.ReadProcessMemory(process, new Pointer(address), memory, lenght, null);
        
        List<String> strings = new ArrayList<>();
        
        StringBuilder str = new StringBuilder();
        
        for (byte b : memory.getByteArray(0, lenght)) {
            if (b == 0) {
                if (str.length() != 0)
                    strings.add(str.toString());
                
                str = new StringBuilder();
                continue;
            }
            
            str.append((char) b);
        }
        
        return strings;
    }
    
    public void writeByte(long address, byte value) {
        Memory memory = new Memory(BYTE_SIZE);
        memory.setByte(0, value);
        kernel.WriteProcessMemory(process, new Pointer(address), memory, BYTE_SIZE, null);
    }
    
    public void writeShort(long address, short value) {
        Memory memory = new Memory(SHORT_SIZE);
        memory.setShort(0, value);
        kernel.WriteProcessMemory(process, new Pointer(address), memory, SHORT_SIZE, null);
    }
    
    public void writeInteger(long address, int value) {
        Memory memory = new Memory(INT_SIZE);
        memory.setInt(0, value);
        kernel.WriteProcessMemory(process, new Pointer(address), memory, INT_SIZE, null);
    }
    
    public void writeLong(long address, long value) {
        Memory memory = new Memory(LONG_SIZE);
        memory.setLong(0, value);
        kernel.WriteProcessMemory(process, new Pointer(address), memory, LONG_SIZE, null);
    }
    
    public void writeString(long address, String string) {
        Memory memory = new Memory(string.length());
        memory.setString(0, string);
        kernel.WriteProcessMemory(process, new Pointer(address), memory, string.length(), null);
    }
    
    public Object read(long address, StructureElement element) {
        Memory memory = new Memory(element.getSize());
        kernel.ReadProcessMemory(process, new Pointer(address), memory, element.getSize(), null);
        
        switch (element.getElementType()) {
            case BYTE:
                return memory.getByte(0);
            case SHORT:
                return memory.getShort(0);
            case INT:
                return memory.getInt(0);
            case LONG:
                return memory.getLong(0);
            case STRING:
                return memory.getString(0);
            case STRING_POINTER:
                return new StringPointer(memory.getInt(0), readString(convertGameAddress(memory.getInt(0)), 100));
            case BYTE_ARRAY:
                return memory.getByteArray(0, element.getSize());
            case UNDEFINED:
                return memory;
        }
        
        return null;
    }
    
    public void write(long address, StructureElement element, Object value) {
        Memory memory = new Memory(element.getSize());
        
        switch (element.getElementType()) {
            case BYTE:
                memory.setByte(0, (byte) value);
                break;
            case SHORT:
                memory.setShort(0, (short) value);
                break;
            case INT:
                memory.setInt(0, (int) value);
                break;
            case LONG:
                memory.setLong(0, (long) value);
                break;
            case STRING:
                memory.setString(0, (String) value);
                break;
            case STRING_POINTER:
                if (value instanceof Integer)
                    memory.setInt(0, (int) ((int) value - BASE_ADDRESS) | 0x80000000);
                else
                    memory.setInt(0, (int) ((((StringPointer) value).getPointer() - BASE_ADDRESS) | 0x80000000));
                break;
            case BYTE_ARRAY:
                byte[] array = (byte[]) value;
                for (int i = 0; i < array.length; i++)
                    memory.setByte(i, array[i]);
                break;
            case UNDEFINED:
                memory = (Memory) value;
                break;
        }
        
        kernel.WriteProcessMemory(process, new Pointer(address), memory, element.getSize(), null);
    }
}
