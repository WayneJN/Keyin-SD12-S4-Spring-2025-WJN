package com.keyin;

import java.util.Scanner;

public class AverageTemperatureCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of temperatures: ");
        int numTemperatures = scanner.nextInt();

        double[] temperatures = new double[numTemperatures];
        for (int i = 0; i < numTemperatures; i++) {
            System.out.print("Enter temperature " + (i + 1) + ": ");
            temperatures[i] = scanner.nextDouble();
        }

        double average = calculateAverage(temperatures);
        int aboveAverageCount = countAboveAverage(temperatures, average);

        System.out.printf("\nThe average temperature is: %.2f\n", average);
        System.out.println("Number of days above average temperature: " + aboveAverageCount);

        scanner.close();
    }

    // Calculate the average temperature
    public static double calculateAverage(double[] temperatures) {
        double sum = 0;
        for (double temp : temperatures) {
            sum += temp;
        }
        return sum / temperatures.length;
    }

    // How many days are above the average
    public static int countAboveAverage(double[] temperatures, double average) {
        int count = 0;
        for (double temp : temperatures) {
            if (temp > average) {
                count++;
            }
        }
        return count;
    }
}
