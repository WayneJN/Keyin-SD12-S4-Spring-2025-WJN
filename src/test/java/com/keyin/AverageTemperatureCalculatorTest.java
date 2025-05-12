package com.keyin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AverageTemperatureCalculatorTest {

    @Test
    public void testAverageCalculation() {
        double[] temperatures = {10.0, 20.0, 30.0};
        double expectedAverage = 20.0;

        double computedAverage = AverageTemperatureCalculator.calculateAverage(temperatures);

        assertEquals(expectedAverage, computedAverage, 0.001);
    }

    @Test
    public void testAboveAverageCount() {
        double[] temperatures = {10.0, 20.0, 30.0};
        double average = 20.0;

        int countAboveAverage = AverageTemperatureCalculator.countAboveAverage(temperatures, average);

        assertEquals(1, countAboveAverage);
    }
}
