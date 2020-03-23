package com.cleancoders.stack;

public class Stack<T> {
    private final int capacity;
    private int size = 0;

    private Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public static <T> Stack<T> make(int capacity) {
        return new Stack<>(capacity);
    }

    public void pop() {
        if (size == 0) throw new UnderflowException();
        size--;
    }

    public void push(T element) {
        if (size == capacity) throw new OverflowException();
        size++;
    }

    public static class OverflowException extends RuntimeException {
    }

    public static class UnderflowException extends RuntimeException {
    }
}
