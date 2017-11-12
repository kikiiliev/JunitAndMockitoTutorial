package com.junit.tutorial.theories;

import com.junit.tutorial.Calculator;
import com.junit.tutorial.CalculatorImpl;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertTrue;

@RunWith(Theories.class)
public class CalculatorTheories {

    private static int MODULO_BASE = 2;

    /**
     * Data for theory. (Method name doesn't have to be `data`).
     *
     * @return the data values for the theory
     */
    @DataPoints
    public static int[] data56() {
        return new int[]{
                1, 3, -3, 5, 10
        };
    }

    @Theory
    public void positiveResidiumWhenModuloIsPositiveNumber(int value) {
        Calculator calc = new CalculatorImpl();
        System.out.println("value: " + value);
        int residium = calc.mod(value, MODULO_BASE);
        System.out.println("residium: " + residium);

        Assume.assumeTrue(value > 0);
        assertTrue("The residium must not be negative!", residium >= 0);
    }

}
