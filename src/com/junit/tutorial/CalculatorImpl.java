package com.junit.tutorial;

public class CalculatorImpl implements Calculator {

    /**
     * Sums two integers.
     * @param a
     * @param b
     * @return the sum of the arguments
     */
    @Override
    public int sum(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts two integers.
     * @param a
     * @param b
     * @return the first argument subtracted with the second
     */
    @Override
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two integers.
     * @param a
     * @param b
     * @return the product of the arguments
     */
    @Override
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides two integers
     * @param a
     * @param b
     * @return first argument divided by the second.
     */
    @Override
    public int divide (int a, int b) {
        if(b == 0) {
            throw new ArithmeticException("cannot divide by zero!");
        }
        return a / b;
    }

    /**
     * Modulo operation.
     * @param a
     * @param b
     * @return first argument modulo second argument
     */
    @Override
    public int mod(int a, int b) {
        if(b == 0) {
            throw new ArithmeticException("cannot perform modulo by zero!");
        }
        return a % b;
    }
}
