package com.cleancoders.stack;

public interface Stack<T> {
    boolean isEmpty();

    int getSize();

    void push(T element);

    T pop();

    class OverflowException extends RuntimeException {
    }

    class UnderflowException extends RuntimeException {
    }

    class IllegalCapacityException extends RuntimeException {
    }
}
