package com.junit.tutorial;

import com.junit.tutorial.categories.Negative;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.assertEquals;

public class CalculatorTestNegative {

    private Calculator calc;
    int result;

    @Before
    public void setup() {
        System.out.println("Setup...");
        calc = new CalculatorImpl();
    }

    @Test(expected = ArithmeticException.class)
    @Category(Negative.class)
    public void divide_correctValues_wrongResult() {
        result = calc.divide(5, 0);
        assertEquals("the result should be equal to 2!",0, result);
    }

    @Test(expected = ArithmeticException.class)
    @Category(Negative.class)
    public void mod_correctValues_wrongResult() {
        result = calc.mod(3, 0);
        assertEquals("the modulo should be equal to 1!",0, result);
    }
}
