package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Question no: (from [1, 2])");
        int qno = sc.nextInt();
        switch (qno) {
            case 1:
                com.company.Question1.Impl.run();
                break;
            case 2:
                com.company.Question2.Impl.run();
                break;
            default:
                System.out.println("Please enter valid question no");
        }
    }
}
