package de.phoenixstaffel.dmw.utils;

import java.nio.ByteBuffer;

import com.sun.jna.Memory;

public class Utils {
        
    public static String parseGameString(Memory memory, boolean ignoreAscii) {
        ByteBuffer buffer = memory.getByteBuffer(0, memory.size());
        StringBuilder builder = new StringBuilder();
        
        while (buffer.hasRemaining()) {
            byte value = buffer.get();
            
            if (value == -127 || value == -126 && buffer.hasRemaining())
                builder.append(getGameCharacter(value, buffer.get()));
            else if(value >= 0x20 && value <= 0x7F && !ignoreAscii)
                builder.append((char) value);
            else if (value == 0x0D)
                builder.append((char) value);
        }
        
        return builder.toString();
    }
    
    /**
     * A quite dirty conversion method...
     * 
     * 130 79 - 130 88 -> 0 - 9
     * 130 96 - 130 121 -> A - Z
     * 130 129 - 130 154 -> a - z
     * 129 64 -> ' '
     * 129 66 -> .
     * 129 67 -> ,
     * 129 70 -> :
     * 129 71 -> ;
     * 129 72 -> ?
     * 129 73 -> !
     * 
     * @param value the first byte of the character
     * @param character the second (payload) byte of the character
     * @return The representing character as a String
     */
    public static String getGameCharacter(byte value, byte character) {
        switch (value) {
            case -126:
                switch (character) {
                    case 79:
                        return "0";
                    case 80:
                        return "1";
                    case 81:
                        return "2";
                    case 82:
                        return "3";
                    case 83:
                        return "4";
                    case 84:
                        return "5";
                    case 85:
                        return "6";
                    case 86:
                        return "7";
                    case 87:
                        return "8";
                    case 88:
                        return "9";

                    case 95: //TODO seems like a bug for me?
                        return "\\";
                    case 96:
                        return "A";
                    case 97:
                        return "B";
                    case 98:
                        return "C";
                    case 99:
                        return "D";
                    case 100:
                        return "E";
                    case 101:
                        return "F";
                    case 102:
                        return "G";
                    case 103:
                        return "H";
                    case 104:
                        return "I";
                    case 105:
                        return "J";
                    case 106:
                        return "K";
                    case 107:
                        return "L";
                    case 108:
                        return "M";
                    case 109:
                        return "N";
                    case 110:
                        return "O";
                    case 111:
                        return "P";
                    case 112:
                        return "Q";
                    case 113:
                        return "R";
                    case 114:
                        return "S";
                    case 115:
                        return "T";
                    case 116:
                        return "U";
                    case 117:
                        return "V";
                    case 118:
                        return "W";
                    case 119:
                        return "X";
                    case 120:
                        return "Y";
                    case 121:
                        return "Z";
                        
                    case -127:
                        return "a";
                    case -126:
                        return "b";
                    case -125:
                        return "c";
                    case -124:
                        return "d";
                    case -123:
                        return "e";
                    case -122:
                        return "f";
                    case -121:
                        return "g";
                    case -120:
                        return "h";
                    case -119:
                        return "i";
                    case -118:
                        return "j";
                    case -117:
                        return "k";
                    case -116:
                        return "l";
                    case -115:
                        return "m";
                    case -114:
                        return "n";
                    case -113:
                        return "o";
                    case -112:
                        return "p";
                    case -111:
                        return "q";
                    case -110:
                        return "r";
                    case -109:
                        return "s";
                    case -108:
                        return "t";
                    case -107:
                        return "u";
                    case -106:
                        return "v";
                    case -105:
                        return "w";
                    case -104:
                        return "x";
                    case -103:
                        return "y";
                    case -102:
                        return "z";
                }
                break;
            case -127:
                switch (character) {
                    case 64:
                        return " ";
                    case 66:
                        return ".";
                    case 67:
                        return ",";
                    case 70:
                        return ":";
                    case 71:
                        return ";";
                    case 72:
                        return "?";
                    case 73:
                        return "!";
                    case 95:
                        return "\\";
                    case 117:
                        return "'";
                    case 123:
                        return "+";
                    case 124:
                        return "-";
                }
                break;
        }
        
        return "Ä";
    }
}
