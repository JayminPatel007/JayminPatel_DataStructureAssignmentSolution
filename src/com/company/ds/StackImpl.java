package com.company.ds;
import java.util.Arrays;

public class StackImpl<T>{
    private T[] arr;
    private int top;
    private int capacity;

    public StackImpl(int capacity) {
        this.arr = (T[]) new Object[capacity];
        this.capacity = capacity;
        top = -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean isFull() {
        return this.size() == this.capacity;
    }

    public void push(T item) {
        if (this.isFull()) {
            System.out.println("Stack is full");
            System.exit(-1);
        }
        top = top + 1;
        arr[top] = item;
    }

    public T pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(-1);
        }
        T el = arr[top];
        top  = top - 1;
        return el;
    }

    public T peek() {
        if (this.isEmpty()) {
            System.out.println("Stack is empty");
            System.exit(-1);
        }
        return arr[top];
    }

    @Override
    public String toString() {
        return "StackImpl{" +
                "arr=" + Arrays.toString(arr) +
                ", top=" + top +
                ", capacity=" + capacity +
                '}';
    }
}
