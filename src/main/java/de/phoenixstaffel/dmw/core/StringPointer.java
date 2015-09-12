package de.phoenixstaffel.dmw.core;

public class StringPointer {
    
    private final long pointer;
    private final String content;
    
    public StringPointer(long pointer, String content) {
        this.pointer = pointer;
        this.content = content;
    }

    public long getPointer() {
        return pointer;
    }

    public String getContent() {
        return content;
    }
}
