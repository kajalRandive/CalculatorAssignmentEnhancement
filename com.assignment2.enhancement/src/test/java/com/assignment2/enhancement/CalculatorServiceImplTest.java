package com.assignment2.enhancement;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.mockito.InjectMocks;

import com.assignment2.enhancement.service.CalculatorServiceImpl;
import com.bnt.dto.MinMaxResponse;

public class CalculatorServiceImplTest {

	@InjectMocks
	private CalculatorServiceImpl calculatorService;

	@Test
	public void additionTest() {
		try {
			Integer answer = 30;
			assertEquals(answer, calculatorService.addition(10, 20));
		} catch (NullPointerException e) {
			assertNull(e.getMessage());
		}
	}

	@Test
	public void subtractionTest() {
		try {
			Integer answer = -10;
			assertEquals(answer, calculatorService.substraction(10, 20));
		} catch (NullPointerException e) {
			assertNull(e.getMessage());
		}
	}

	@Test
	public void multiplicationTest() throws Exception {
		try {
			Integer answer = 200;
			assertEquals(answer, calculatorService.multiplication(10, 20));
		} catch (NullPointerException e) {
			assertNull(e.getMessage());
		}

	}

	@Test
	public void divisionTest() throws Exception {
		try {

			calculatorService.division(10, 20);

		} catch (NullPointerException e) {
			assertNull(e.getMessage());
		}
	}

	@Test
	public void squareTest() {
		try {

			double answer = 25;
			assertEquals(answer, calculatorService.getSquare(5.00));
		} catch (NullPointerException e) {
			assertNull(e.getMessage());
		}
	}

	

	@Test
	public void factorialTest() {
		try {
			double answer = 120.00;
			assertEquals(answer, calculatorService.getFactorial(5.00));
		} catch (NullPointerException e) {
			assertNull(e.getMessage());
		}

	}

	@Test
	public void minMaxTest() {
		try {
			Integer min = 10;
			Integer max = 9;
			MinMaxResponse map = calculatorService.getMinMax(new int[] { 5, 9, 8, 1, 3, 9 });
		} catch (NullPointerException e) {
			assertNull(e.getMessage());
		}
	}

}