package com.keyin;

import java.util.Scanner; // Import Scanner for user input

public class MovieTheaterImplementation {
    final String[][] seats;

    public String getSeat(int row, int col) {
        return seats[row][col];
    }

    // Constructor
    public MovieTheaterImplementation(int rows, int cols) {
        seats = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                seats[i][j] = "Available"; // Initialize all seats as available
            }
        }
    }

    // Reserve a seat
    public void reserveSeat(int row, int col, String name) {
        try {
            if ("Available".equals(seats[row][col])) {
                seats[row][col] = name;
                System.out.println("Seat reserved successfully for " + name + "!");
            } else {
                System.out.println("Seat taken! Suggesting an available seat...");
                suggestSeat();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat selection.");
        }
    }

    // Suggest an available seat
    private void suggestSeat() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                if ("Available".equals(seats[i][j])) {
                    System.out.println("Try seat at Row: " + i + ", Col: " + j);
                    return;
                }
            }
        }
        System.out.println("Sorry, no available seats.");
    }

    // Cancel a reservation
    public void cancelSeat(int row, int col) {
        try {
            if (!"Available".equals(seats[row][col])) {
                System.out.println("Reservation canceled for: " + seats[row][col]);
                seats[row][col] = "Available";
            } else {
                System.out.println("Seat is already available.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid seat selection.");
        }
    }

    public void printSeatingChart() {
        System.out.println("\nCurrent Seating Chart:");

        System.out.print("   ");
        for (int col = 1; col <= seats[0].length; col++) {
            System.out.printf("%-10d", col);
        }
        System.out.println();

        // Print rows with labels
        for (int i = 0; i < seats.length; i++) {
            System.out.printf("%-3d", (i + 1));
            for (String seat : seats[i]) {
                System.out.printf("%-10s", seat);
            }
            System.out.println();
        }
    }

    // Main method with User Input
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieTheaterImplementation theater = new MovieTheaterImplementation(5, 5);

        while (true) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. View Seating Chart");
            System.out.println("2. Reserve a Seat");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Thank you for using the Movie Theater system!");
                break;
            }

            switch (choice) {
                case 1:
                    theater.printSeatingChart();
                    break;
                case 2:
                    System.out.print("Enter row number: ");
                    int row = scanner.nextInt() - 1;
                    System.out.print("Enter column number: ");
                    int col = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    theater.reserveSeat(row, col, name);
                    break;
                case 3:
                    System.out.print("Enter row number to cancel: ");
                    int cancelRow = scanner.nextInt() - 1;
                    System.out.print("Enter column number to cancel: ");
                    int cancelCol = scanner.nextInt() - 1;
                    theater.cancelSeat(cancelRow, cancelCol);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
