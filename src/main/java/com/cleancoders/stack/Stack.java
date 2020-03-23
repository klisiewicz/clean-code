package com.cleancoders.stack;

public class Stack<T> {
    private int size = 0;

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void push(T element) {
        size++;
    }

    public void pop() {
        size--;
    }
}
