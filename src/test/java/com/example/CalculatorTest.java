package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}