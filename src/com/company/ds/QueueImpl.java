package com.company.ds;
import java.util.Arrays;

public class QueueImpl{
    private int[] arr;
    private int front;
    private int capacity;
    private int rear;
    private int count;

    public QueueImpl(int size) {
        arr = new int[size];
        this.capacity = size;
        this.front = 0;
        this.count = 0;
        this.rear = -1;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean isFull() {
        return this.size() == capacity;
    }

    public int peek() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(-1);
        }
        return arr[front];
    }

    public void enqueue(int item) {
        if (this.isFull()) {
            System.out.println("Queue overflow");
            System.exit(-1);
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }

    public int dequeue() {
        if (this.isEmpty()) {
            System.out.println("Queue is empty");
            System.exit(-1);
        }
        int el = arr[front];
        front = (front + 1) % capacity;
        count--;
        return el;
    }

    @Override
    public String toString() {
        return "QueueImpl{" +
                "arr=" + Arrays.toString(arr) +
                ", front=" + front +
                ", capacity=" + capacity +
                ", rear=" + rear +
                ", count=" + count +
                '}';
    }
}
