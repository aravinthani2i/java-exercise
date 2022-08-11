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

        int rowFlag = 0;

        boolean isEntireRowPrint = true;

        for (int i = 0; i < rowInput; i++) {

            int columnFlag = 0;
            rowFlag++;

            for (int j = 0; j < columnInput; j++) {
                if (isEntireRowPrint) {
                    System.out.print("*\t");
                } else {
                    if (j == 0) {
                        System.out.print("*\t");
                    } else {
                        columnFlag++;
                        if (columnFlag <= emptySpace) {
                            System.out.print("\t");
                        } else {
                            System.out.print("*\t");
                            columnFlag = 0;
                        }
                    }
                }
            }

            if (rowFlag <= emptySpace) {
                isEntireRowPrint = false;
            } else {
                isEntireRowPrint = true;
                rowFlag = 0;
            }
            System.out.println();
        }
    }
}
