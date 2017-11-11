package com.junit.tutorial.suites;

import com.junit.tutorial.CalculatorTestNegative;
import com.junit.tutorial.CalculatorTestPositive;
import com.junit.tutorial.categories.Negative;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//@RunWith(Suite.class)
@RunWith(Categories.class)
@ExcludeCategory(Negative.class)
@Suite.SuiteClasses({
        CalculatorTestPositive.class,
        CalculatorTestNegative.class
})
public class CalculatorSuite {

}

