package com.keyin;

public class MovieTheaterImplementation {
    private final String[][] seats;

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
                System.out.println("Seat reserved successfully!");
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

    // Print the seating chart
    public void printSeatingChart() {
        System.out.println("\nCurrent Seating Chart:");
        for (String[] row : seats) {
            for (String seat : row) {
                System.out.print(seat + " | ");
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        MovieTheaterImplementation theater = new MovieTheaterImplementation(5, 5);

        theater.printSeatingChart();
        theater.reserveSeat(2, 2, "Wayne");
        theater.printSeatingChart();
        theater.cancelSeat(2, 2);
        theater.printSeatingChart();
    }
}
