package com.keyin;

public class TwoDimensionalArray {
    private final int[][] arr;  // Removed 'null' initialization & fixed declaration

    // Constructor
    public TwoDimensionalArray(int numberOfRows, int numberOfColumns) {
        this.arr = new int[numberOfRows][numberOfColumns];
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                arr[row][col] = Integer.MIN_VALUE;
            }
        }
    }

    // Insert value in the Array
    public void insertValueInTheArray(int row, int col, int value) {
        try {
            if (arr[row][col] == Integer.MIN_VALUE) {
                arr[row][col] = value;
                System.out.println("The value is successfully inserted");
            } else {
                System.out.println("This cell is already occupied");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index for 2D array");
        }
    }

    // Access cell value
    public void accessCell(int row, int col) {
        System.out.println("\nAccessing Row#" + row + ", Col#" + col);
        try {
            System.out.println("Cell value is: " + arr[row][col]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index for 2D array");
        }
    }

    // Traverse 2D array using enhanced for loop
    public void traverse2DArray() {
        for (int[] row : arr) {
            for (int col : row) {
                System.out.print(col + "  ");
            }
            System.out.println();
        }
    }

    // **Main method to test class**
    public static void main(String[] args) {
        TwoDimensionalArray array = new TwoDimensionalArray(3, 3);
        array.insertValueInTheArray(1, 1, 5);
        array.accessCell(1, 1);
        array.traverse2DArray();
    }
}
