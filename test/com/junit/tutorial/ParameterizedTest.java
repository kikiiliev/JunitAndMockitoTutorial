package com.junit.tutorial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedTest {

    private final int expected;
    private final int inputA;
    private final int inputB;
    private final String operation;

    private static Calculator calc = new CalculatorImpl();

    @Parameterized.Parameters
    public static List<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"sum", 1, 2, 3},
                {"sum", 1, -2, -1},
                {"subtract", 2, 2, 0},
                {"multiply", 0, 2, 0},
                {"divide", 1, 2, 0},
                {"mod", 1, 2, 1},
        });
    }

    public ParameterizedTest(String operation, int a, int b, int expected) {
        this.inputA = a;
        this.inputB = b;
        this.expected = expected;
        this.operation = operation;
    }

    @Test
    public void test() {
        int result = calc.operation(this.operation, this.inputA, this.inputB);
        assertEquals(this.operation + ": result does not match the expected one!", this.expected, result);

    }
}
