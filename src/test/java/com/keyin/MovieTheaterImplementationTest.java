package com.keyin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MovieTheaterImplementationTest {
    private MovieTheaterImplementation theater;

    @BeforeEach
    void setUp() {
        theater = new MovieTheaterImplementation(5, 5);
    }

    @Test
    void testReserveSeat() {
        theater.reserveSeat(1, 1, "Wayne");

        assertEquals("Wayne", theater.getSeat(1, 1), "Seat should be reserved for Wayne");
    }

    @Test
    void testCancelSeat() {
        theater.reserveSeat(1, 1, "Wayne");
        theater.cancelSeat(1, 1);

        assertEquals("Available", theater.getSeat(1, 1), "Seat should be available after cancellation");
    }

    @Test
    void testInvalidSeatSelection() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> theater.reserveSeat(6, 6, "John"));
    }
}
