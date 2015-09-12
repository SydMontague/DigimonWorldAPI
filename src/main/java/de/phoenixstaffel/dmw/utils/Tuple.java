package de.phoenixstaffel.dmw.utils;

public class Tuple<T, K> {
    private T value1;
    private K value2;
    
    public Tuple(T value1, K value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
    
    public T getFirstValue() {
        return value1;
    }
    
    public K getSecondValue() {
        return value2;
    }
}
