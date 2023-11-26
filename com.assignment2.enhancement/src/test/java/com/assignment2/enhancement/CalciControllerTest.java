package com.assignment2.enhancement;

import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.assignment2.enhancement.controller.CalculatorController;
import com.assignment2.enhancement.dao.CalculatorDao;
import com.assignment2.enhancement.requestresponse.CalResponse;
import com.assignment2.enhancement.requestresponse.MinMaxRequest;
import com.assignment2.enhancement.requestresponse.MinMaxResponse;
import com.assignment2.enhancement.service.CalculatorServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class CalciControllerTest {
	@Mock
	private CalculatorServiceImpl calculatorService;

	@Mock
	private CalculatorDao calculatorDao;

	@InjectMocks
	private CalculatorController calculatorController;

	@Test
	public void testGetAddition() {
		Mockito.when(calculatorService.addition(2.00, 3.00)).thenReturn(5.00);
		CalResponse response = calculatorController.addition(2.00, 3.00);
		assertEquals(5.00, response.getAnswer());
	}

	@Test
	public void testGetSubstraction() {
		Mockito.when(calculatorService.substraction(3.00, 5.00)).thenReturn(2.00);
		CalResponse response = calculatorController.subtraction(3.00, 5.00);
		assertEquals(2.00, response.getAnswer());
	}

	@Test
	public void testGetMultiplication() {
		Mockito.when(calculatorService.multiplication(3.00, 5.00)).thenReturn(15.00);
		CalResponse response = calculatorController.multiplication(3.00, 5.00);
		assertEquals(15.00, response.getAnswer());
	}

	@Test
	public void testGetSquare() {
		Mockito.when(calculatorService.getSquare(4.00)).thenReturn(16.00);
		CalResponse response = calculatorController.getSquare(4.00);
		assertEquals(16.00, response.getAnswer());
	}

	

	@Test
	public void testGetFactorial() {
		Mockito.when(calculatorService.getFactorial(4.00)).thenReturn(24.00);
		CalResponse response = calculatorController.getFactorial(4.00);
		assertEquals(24, response.getAnswer());
		assertEquals("4=24", response.getDetail());
	}

	@Test
	public void testMinMax() {
		MinMaxRequest request = new MinMaxRequest();
		Mockito.when(calculatorService.minMax(request.getNumbers())).thenReturn(new MinMaxResponse(1, 9));
		MinMaxResponse response = calculatorController.minMax(request);
		assertEquals(1, response.getMin());
		assertEquals(9, response.getMax());
	}


}
