package com.cleancoders.stack;

public class BoundedStack<T> implements Stack<T> {
    private final int capacity;
    private T[] elements;
    private int size = 0;

    @SuppressWarnings("unchecked")
    private BoundedStack(int capacity) {
        this.capacity = capacity;
        elements = (T[]) new Object[capacity];
    }

    static <T> Stack<T> make(int capacity) {
        if (capacity < 0) throw new IllegalCapacityException();
        return (capacity == 0) ? new ZeroCapacityStack<>() : new BoundedStack<>(capacity);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void push(T element) {
        if (size == capacity) throw new OverflowException();
        elements[size++] = element;
    }

    @Override
    public T pop() {
        if (size == 0) throw new UnderflowException();
        return elements[--size];
    }

    private static class ZeroCapacityStack<T> implements Stack<T> {

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public int getSize() {
            return 0;
        }

        @Override
        public void push(T element) {
            throw new Stack.OverflowException();
        }

        @Override
        public T pop() {
            throw new Stack.UnderflowException();
        }
    }
}
