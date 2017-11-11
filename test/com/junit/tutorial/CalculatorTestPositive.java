package com.junit.tutorial;

import com.junit.tutorial.categories.Negative;
import com.junit.tutorial.categories.Positive;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;

import static org.junit.Assert.*;
@Categories.ExcludeCategory(Negative.class)
public class CalculatorTestPositive {

    private Calculator calc;
    int result;

    @Before
    public void setup() {
        calc = new CalculatorImpl();
    }

    @Test
    @Category(Positive.class)
    public void sum_correctValues_valid() {
        result = calc.sum(1, 2);
        assertEquals("the sum should be equal to 3!",3, result);
    }

    @Test
    @Category(Positive.class)
    public void subtract_correctValues_valid() {
        result = calc.subtract(1, 2);
        assertEquals("the difference should be equal to -1!",-1, result);
    }

    @Test
    @Category(Positive.class)
    public void multiply_correctValues_valid() {
        result = calc.multiply(1, 2);
        assertEquals("the product should be equal to 2!",2, result);
    }

    @Test
    @Category(Positive.class)
    public void divide_correctValues_valid() {
        result = calc.divide(5, 2);
        assertEquals("the result should be equal to 2!",2, result);
    }

    @Test
    @Category(Positive.class)
    public void mod_correctValues_valid() {
        result = calc.mod(3, 2);
        assertEquals("the modulo should be equal to 1!",1, result);
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
