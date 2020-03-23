package com.cleancoders.stack;

public class Stack<T> {
    private final int capacity;
    private T[] elements;
    private int size = 0;

    @SuppressWarnings("unchecked")
    private Stack(int capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public static <T> Stack<T> make(int capacity) {
        if (capacity < 0) throw new IllegalCapacityException();
        return new Stack<>(capacity);
    }

    public void push(T element) {
        if (size == capacity) throw new OverflowException();
        elements[size++] = element;
    }

    public T pop() {
        if (size == 0) throw new UnderflowException();
        return elements[--size];
    }

    public static class OverflowException extends RuntimeException {
    }

    public static class UnderflowException extends RuntimeException {
    }

    public static class IllegalCapacityException extends RuntimeException {
    }
}
