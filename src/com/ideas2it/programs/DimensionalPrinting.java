package com.ideas2it.programs;

import java.util.Scanner;

public class DimensionalPrinting {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the row size");
        final int rowInput = scanner.nextInt();
        System.out.println("Enter the column size");
        final int columnInput = scanner.nextInt();
        System.out.println("Enter the empty space size");
        int emptySpace = scanner.nextInt();
        int N = emptySpace + 1;

        for (int i = 0; i <= rowInput; i++) {
            for (int j = 0; j <= columnInput; j++) {
                if (i % N == 0 || j % N == 0) {
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
