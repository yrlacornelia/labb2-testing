package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    @DisplayName("Given two numbers separated by a comma, when adding them, then the sum is correct")
    void givenTwoNumbersSeparatedByACommaWhenAddingThemThenTheSumIsCorrect() {
        Calculator calculator = new Calculator( "3,5");
        int sum = calculator.addNumbers();
        assertEquals(8, sum );
    }

    @Test
    @DisplayName("Given no numbers, when adding, then return 0")
    void givenNoNumbersWhenAddingThenReturn0() {
        Calculator calculator = new Calculator( "");
        int sum = calculator.addNumbers();
        assertEquals(0, sum );
    }
    @Test
    @DisplayName("Given an unknown amount of numbers, when adding, return the correct sum")
    void givenAnUnknownAmountOfNumbersWhenAddingReturnTheCorrectSum() {
        Calculator calculator = new Calculator( "3,10,5,2,6");
        int sum = calculator.addNumbers();
        assertEquals(26, sum );
    }

    @Test
    @DisplayName("Given different delimiter, when adding, then return correct sum")
    void givenDifferentDelimiterWhenAddingThenReturnCorrectSum() {
        Calculator calculator = new Calculator( "//;\n1;2");
        int sum = calculator.addNumbers();
        assertEquals(3, sum);
    }
    @Test
    public void testAddNumbersWithNegativeNumber() {
        Calculator calculator = new Calculator("-5,2,3");
        try {
            int result = calculator.addNumbers();
            fail("Expected IllegalArgumentException but got result: " + result);
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed: -5", e.getMessage());
        }
    }
    @Test
    @DisplayName("Given negative number, when passed, then throw exception")
    void givenNegativeNumberWhenPassedThenThrowException() {
        Calculator calculator = new Calculator( "2, -8");
        try {
            calculator.addNumbers();
            fail("Expected exception not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Negatives not allowed:  -8", e.getMessage());
        }
    }
    @Test
    void givenPositiveNumbersWhenPassedThenNoException() {
        Calculator calculator = new Calculator("0,8");
        try {
            int result = calculator.addNumbers();
            assertEquals(8, result, "Sum of positive numbers should be 10");
        } catch (IllegalArgumentException e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test
    @DisplayName("GivenLargeNumberWhenAddedThenDontReturn")
    void givenLargeNumberWhenAddedThenDontReturn() {
        Calculator calculator = new Calculator( "1003,5");
        int sum = calculator.addNumbers();
        assertEquals(5, sum);
    }
    @Test
    @DisplayName("When Given delimiters of any length, When add, Then return correct sum ")
    void whenGivenMultipleDelimitersThen() {
        Calculator calculator = new Calculator( "//[***]\n1***2***3");
        int sum = calculator.addNumbers();
        assertEquals(6, sum);
    }

}