package com.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

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

    @Test
    @DisplayName("Test string with unknown amount of numbers")
    void testAddUnknownAmountOfNumbers() {


        String numbers = "1,2,3,4,5,6,7,8";

        int actual = 0;

        int expected = 36;

        actual = stringCalc.add(numbers);

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("test new lines between numbers ")
    void testAddMoreLinesBetweenNumbers() {


        String numbers = "1\n2,3";

        int actual = 0;

        int expected = 6;

        actual = stringCalc.add(numbers);

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("test for more delimiters ")
    void testAddMoreDelimiters() {


        String numbers = "//;\n1,2";

        int actual = 0;

        int expected = 3;

        actual = stringCalc.add(numbers);

        assertEquals(expected, actual);

    }
    @Test
    @DisplayName("Test with negative number")
    void testNegativeNumber() {


        String numbers = "-1,-12,12";



        String expected = "negative numbers NOT ALLOWED!![-1, -12]";



        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> stringCalc.add(numbers)).withMessage("negative numbers NOT ALLOWED!![-1, -12]");
    }




}