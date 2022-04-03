package com.company.Question1;
import com.company.ds.QueueImpl;
import com.company.ds.StackImpl;

import java.util.Scanner;

public class Impl {
    public static void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the total no of floors in the building");
        int noOfFloors = scanner.nextInt();
        int maxFlorSizeLeft = noOfFloors;
        QueueImpl queue = new QueueImpl(2 * noOfFloors);
        StackImpl<Integer> stack = new StackImpl<Integer>(noOfFloors);
        for (int i = 0; i < noOfFloors; i++) {
            queue.enqueue(-1);
            System.out.println("enter the floor size given on day : " + (i + 1) );
            int floorSize = scanner.nextInt();
            StackImpl<Integer> tempStack = new StackImpl<Integer>(noOfFloors);
            while (!stack.isEmpty() && floorSize < stack.peek()) {
                tempStack.push(stack.pop());
            }
            stack.push(floorSize);
            while (!tempStack.isEmpty()) {
                stack.push(tempStack.pop());
            }
            if (stack.peek() >= maxFlorSizeLeft) {
                while (!stack.isEmpty() && stack.peek() >= maxFlorSizeLeft) {
                    int el = stack.pop();
                    queue.enqueue(el);
                    maxFlorSizeLeft = el - 1;
                }
            }
        }
        System.out.println(queue.toString());
        int day = 1;
        while (!queue.isEmpty()) {
            if (queue.peek() == -1) {
                queue.dequeue();
                System.out.println("\nDay: " + day);
                day++;
            } else {
                System.out.print(queue.dequeue() +" ");
            }
        }
    }
}
