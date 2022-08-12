package com.ideas2it.programs;

public class DimensionalPrintingRow {

    public static void main(String[] args) {
        printNumbers();
    }

    private static void printNumbers() {
        int emptySpace = 1;
        int nextSpace = 1;
        for (int i = 1; i <= 10; i++) {
            if (i % nextSpace == 0) {
                System.out.println("* * * ");
                nextSpace += emptySpace + 1;
            } else {
                System.out.println("\t");
            }
        }
    }


}
