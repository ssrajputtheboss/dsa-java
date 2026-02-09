package main.datastructures.core;

public interface IteratorOperation<T> extends Iterable<T>{
    public void operate(T x);
}
