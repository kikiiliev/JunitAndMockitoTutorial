package com.junit.tutorial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GreetingImplTest {

	private Greeting greeting;
	@Before
	public void setup() {
		System.out.println("Setup");
		greeting = new GreetingImpl();
	}

	@Test
	public void greetShouldReturnAValidOutput() {
		System.out.println("greetShouldReturnAValidOutput");
		String result = greeting.greet("Junit");

		assertNotNull(result);
		assertEquals("Hello Junit", result);
	}

//	@Test(expected = IllegalArgumentException.class)
//	public void greetShouldThrowAnException_For_NameIsNull() {
//		Greeting greeting = new GreetingImpl();
//		greeting.greet(null);
//	}
//
//	@Test(expected = IllegalArgumentException.class)
//	public void greetShouldThrowAnException_For_NameIsBlank() {
//		Greeting greeting = new GreetingImpl();
//		greeting.greet("");
//	}

	@Test(expected = ArithmeticException.class)
	public void testDivisionWithException() {
		System.out.println("testDivisionWithException");
		int i = 1 / 0;
	}
	
	@After
	public void cleanUp() {
		System.out.println("cleanUp");
	}
}
