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
        int rowNextSpace = 1;

        for (int i = 1; i <= rowInput; i++) {
            int columnNextSpace = 1;
            for (int j = 1; j <= columnInput; j++) {
                if (i % rowNextSpace == 0 || j % columnNextSpace == 0) {
                    System.out.print("*");
                    columnNextSpace += emptySpace + 1;
                }
                System.out.print("\t");
            }

            if (i % rowNextSpace == 0) {
                rowNextSpace += emptySpace + 1;
            }
            System.out.println();
        }
    }
}
