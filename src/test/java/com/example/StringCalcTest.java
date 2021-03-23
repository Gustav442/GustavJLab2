package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalcTest {


    StringCalc stringCalc = new StringCalc();

    @Test
    @DisplayName("Testar tom string.")
    void addTest() {


        String numbers = "";

        int actual = 0;

        int expected = 0;

        actual = stringCalc.add(numbers);

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Test string with one number")
    void addTestTwo() {


        String numbers = "1";

        int actual = 0;

        int expected = 1;

        actual = stringCalc.add(numbers);

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Test string with two numbers")
    void testAddTwoNumbers() {


        String numbers = "1,2";

        int actual = 0;

        int expected = 3;

        actual = stringCalc.add(numbers);

        assertEquals(expected, actual);


    }

}