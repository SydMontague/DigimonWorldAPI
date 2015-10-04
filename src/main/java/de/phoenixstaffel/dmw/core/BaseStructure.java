package de.phoenixstaffel.dmw.core;

import java.util.ArrayList;
import java.util.List;

import de.phoenixstaffel.dmw.DigimonWorldAPI;

public abstract class BaseStructure implements Structure {
    private final DigimonWorldAPI main;
    private final de.phoenixstaffel.dmw.MemoryAccess memory;
    private final int id;
    private final long baseAddress;
    private final List<StructureElement> elements = new ArrayList<>();
    
    public BaseStructure(DigimonWorldAPI main, long baseAddress, int id) {
        this.baseAddress = baseAddress;
        this.id = id;
        this.main = main;
        memory = main != null ? main.getMemoryAccess() : null;
    }
    
    public DigimonWorldAPI getMain() {
        return main;
    }
    
    public long getBaseAddress() {
        return baseAddress + id * getStructureSize();
    }
    
    protected void addStructureElement(StructureElement element) {
        elements.add(element);
    }
    
    protected StructureElement getStructureElementByName(String name) {
        for (StructureElement element : elements)
            if (element.getName().equals(name))
                return element;
        
        return null;
    }
    
    public int getStructureSize() {
        int size = 0;
        for (StructureElement e : elements)
            size += e.getSize();
        
        return size;
    }
    
    protected Object readStructure(String name) {
        return readStructure(getStructureElementByName(name));
    }
    
    protected Object readStructure(int index) {
        return readStructure(elements.get(index));
    }
    
    private Object readStructure(StructureElement element) {
        if (element == null)
            return null;
        
        int offset = 0;
        
        for (int i = 0; i < elements.size(); i++) {
            StructureElement localElement = elements.get(i);
            if (localElement == element)
                break;
            
            offset += localElement.getSize();
        }
        
        return memory.read(getBaseAddress() + offset, element);
    }
    
    protected void writeStructure(String name, Object value) {
        writeStructure(getStructureElementByName(name), value);
    }
    
    protected void writeStructure(int index, Object value) {
        writeStructure(elements.get(index), value);
    }
    
    private void writeStructure(StructureElement element, Object value) {
        if (element == null)
            return;
        
        int offset = 0;
        for (int i = 0; i < elements.size(); i++) {
            StructureElement localElement = elements.get(i);
            if (localElement == element)
                break;
            
            offset += localElement.getSize();
        }
        
        memory.write(getBaseAddress() + offset, element, value);
    }
    
    /**
     * Method used to generate setters and getters for this class.
     * It's a simplistic approach that doesn't take into account any special classes or enums and therefore needs some adaption for actual use.
     * 
     * @return the code as a String with line breaks and spaces and all.
     */
    public String generateGetterAndSetter() {
        StringBuilder str = new StringBuilder();
        
        for (StructureElement element : elements) {
            str.append("    public " + element.getElementType().getJavaTypeName() + " get" + element.getName() + "() {\n");
            str.append("        return (" + element.getElementType().getJavaTypeName() + ") readStructure(\"" + element.getName() + "\");\n");
            str.append("    }\n");
            str.append("    \n");
            
            str.append("    public void set" + element.getName() + "(" + element.getElementType().getJavaTypeName() + " value) {\n");
            str.append("        writeStructure(\"" + element.getName() + "\", value);\n");
            str.append("    }\n");
            str.append("    \n");
        }
        
        return str.toString();
    }
}
