package com.ideas2it.programs;

import java.util.Scanner;

public class MatrixSquare {

    public static void main(String[] args) {
        int matrixSize = getMatrixSize();
        int[][] square = new int[matrixSize][matrixSize];
        fillMatrix(square);
        printMatrix(square);
    }

    private static int getMatrixSize() {
        System.out.println("Enter the odd the number");
        Scanner scanner = new Scanner(System.in);
        int matrixSize = scanner.nextInt();
        if (matrixSize % 2 == 0 || matrixSize < 0) {
            System.out.println("You have entered wrong number. Kindly enter odd number");
            return getMatrixSize();
        }
        return matrixSize;
    }


    private static void fillMatrix(int[][] squareMatrix) {
        final int size = squareMatrix.length;

        int row = 0;
        int column = size / 2;
        int sequenceNo = 1;
        int tempRow;
        int tempColumn;

        squareMatrix[row][column] = sequenceNo;

        int fillFlag = size * size;
        while (--fillFlag > 0) {
            tempColumn = column;
            tempRow = row;
            row = getNextRowIndex(row, size);
            column = getNextColumnIndex(column, size);
            if (squareMatrix[row][column] != 0) {
                row = tempRow + 1;
                column = tempColumn;
            }
            squareMatrix[row][column] = ++sequenceNo;
        }
    }

    private static int getNextRowIndex(int currentRow, int matrixSize) {
        int position = currentRow - 1;
        if (position < 0) {
            position = matrixSize - 1;
        }
        return position;
    }

    private static int getNextColumnIndex(int currentColumn, int matrixSize) {
        int position = currentColumn + 1;
        if (position == matrixSize) {
            position = 0;
        }
        return position;
    }

    private static void printMatrix(int[][] results) {
        int[] rowSum = new int[results.length];
        for (int i = 0; i < results.length; i++) {
            int columnSum = 0;
            for (int j = 0; j < results.length; j++) {
                columnSum += results[i][j];
                rowSum[i] += results[i][j];
                System.out.print(results[i][j]);
                System.out.print("\t");
            }
            System.out.println(" | " + columnSum);
        }
        for (int row : rowSum) {
            System.out.print("--\t");
        }
        System.out.println();
        for (int row : rowSum) {
            System.out.printf(row + "\t");
        }
    }
}
