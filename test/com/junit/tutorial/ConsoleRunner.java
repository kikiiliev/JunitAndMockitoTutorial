package com.junit.tutorial;

import com.junit.tutorial.suites.CalculatorSuite;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class ConsoleRunner {

    public static void main(String args[]) {

        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        junit.run(CalculatorSuite.class);
    }
}
