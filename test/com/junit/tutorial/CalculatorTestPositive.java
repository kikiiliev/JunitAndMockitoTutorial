package com.junit.tutorial;

import com.junit.tutorial.categories.Negative;
import com.junit.tutorial.categories.Positive;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;

public class CalculatorTestPositive {

    private Calculator calc;
    int result;

    @Before
    public void setup() {
        calc = new CalculatorImpl();
    }

    @Rule
    public Timeout timeout = new Timeout(50);

    @Rule
    public ExpectedException thrownException = ExpectedException.none();

    @Test
    @Category(Positive.class)
    public void sum_correctValues_valid() {
        for(int i  = 0; i < 1000_000_000; i++) {
            result = calc.sum(1, 2);

        }
        assertEquals("the sum should be equal to 3!", 3, result);
        assertThat("the sum should be equal to 3!", result, is(3));
        assertThat("the sum should be equal to 3!", result,
                allOf(is(3), instanceOf(Integer.class)));
    }

    @Test
    @Category(Positive.class)
    public void subtract_correctValues_valid() {
        result = calc.subtract(1, 2);
        assertEquals("the difference should be equal to -1!", -1, result);
    }

    @Test
    @Category(Positive.class)
    public void multiply_correctValues_valid() {
        result = calc.multiply(1, 2);
        assertEquals("the product should be equal to 2!", 2, result);
    }

    @Test
    @Category(Positive.class)
    public void divide_correctValues_valid() {
        result = calc.divide(5, 2);
        assertEquals("the result should be equal to 2!", 2, result);
    }

    @Test
    @Category(Positive.class)
    public void mod_correctValues_valid() {
        result = calc.mod(3, 2);
        assertEquals("the modulo should be equal to 1!", 1, result);
    }

    @Test(expected = ArithmeticException.class)
    @Category(Negative.class)
    public void divide_correctValues_wrongResult() {
        result = calc.divide(5, 0);
    }

    /**
     * Expecting an exception via Rule and checking exception message.
     */
    @Test
    @Category(Negative.class)
    public void divide_correctValues_exceptionthrown() {
        thrownException.expect(ArithmeticException.class);
//        thrownException.expectMessage("cannot divide by zero!");
        thrownException.expectMessage(containsString("cannot divide by zero!"));
        result = calc.divide(5, 0);
    }

    @Test(expected = ArithmeticException.class)
    @Category(Negative.class)
    public void mod_correctValues_wrongResult() {
        result = calc.mod(3, 0);
    }
}
