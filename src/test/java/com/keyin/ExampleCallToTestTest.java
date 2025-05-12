package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleCallToTestTest {
    @Test
    public void testContainsString() {
        ExampleClassToTest exampleClassToTestUnderTest = new ExampleClassToTest();

        Assertions.assertTrue(exampleClassToTestUnderTest.containsString("Unit Testing", "Testing"));
        Assertions.assertTrue(exampleClassToTestUnderTest.containsString("Unit Testing", "Testing"));
    }
}