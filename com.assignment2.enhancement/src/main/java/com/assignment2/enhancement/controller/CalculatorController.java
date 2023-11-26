package com.assignment2.enhancement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment2.enhancement.entity.RequestResponseEntity;
import com.assignment2.enhancement.requestresponse.CalResponse;
import com.assignment2.enhancement.requestresponse.MinMaxRequest;
import com.assignment2.enhancement.requestresponse.MinMaxResponse;
import com.assignment2.enhancement.service.CalculatorServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/calculatorapi/v1")
@Slf4j
public class CalculatorController {
	
	@Autowired
	@Qualifier("calculatorService")
	CalculatorServiceImpl calculatorService;
	
	/** The Constant LOG. */
	private static final Logger LOG = LoggerFactory.getLogger(CalculatorController.class);

	
	@GetMapping(path = "/addition")
	
	public CalResponse addition(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		
		//Double add = calculatorService.addition(num1, num2);
		Double add=calculatorService.addition(num1, num2);
		String request=(num1.toString()) + " , " + (num2.toString());
		String message=(num1.toString()) + " + " + (num2.toString()) + " = " + (add.toString());
		RequestResponseEntity requestResponseEntity=calculatorService.saveData(request, message);
		LOG.error("Request and Response "+requestResponseEntity.toString());
		CalResponse response = setResponse(add, message);
		
		return response;
	}

	@GetMapping(path = "/subtraction")
	public CalResponse subtraction(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		Double subtract = calculatorService.substraction(num1,num2);
		String request=(num1.toString()) + " , " + (num2.toString());
		String message=(num1.toString()) + " - " + (num2.toString()) + " = " + (subtract.toString());
		RequestResponseEntity requestResponseEntity=calculatorService.saveData(request, message);
		LOG.error("Request and Response "+requestResponseEntity.toString());
		CalResponse response = setResponse(subtract, message);
		return response;
	}
	
	@GetMapping(path = "/multiplication")
	public CalResponse multiplication(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		Double multiplication =calculatorService.multiplication(num1, num2);
		String request=(num1.toString()) + " , " + (num2.toString());
        String message=(num1.toString()) + " * " + (num2.toString()) + " = " + (multiplication.toString());
        RequestResponseEntity requestResponseEntity=calculatorService.saveData(request, message);
		LOG.error("Request and Response "+requestResponseEntity.toString());
		CalResponse response = setResponse(multiplication, message);
		return response;
	}

	@GetMapping(path = "/division")
	public CalResponse division(@RequestParam(name = "number1") Double num1,
			@RequestParam(name = "number2") Double num2) {
		
			Double division =calculatorService.division(num1, num2);
			String request=(num1.toString()) + " , " + (num2.toString());
			String message=(num1.toString()) + " / " + (num2.toString()) + " = " + (division.toString());
			 RequestResponseEntity requestResponseEntity=calculatorService.saveData(request, message);
			LOG.error("Request and Response "+requestResponseEntity.toString());
			CalResponse response = setResponse(division, message);
			return response;
	}
	
	@GetMapping(path = "/square/{number}")
	public CalResponse getSquare(@PathVariable Double number) {
		Double square = calculatorService.getSquare(number);
		String request=(number.toString());
        String message=("square of " + number + " = " + (square.toString()));
		 RequestResponseEntity requestResponseEntity=calculatorService.saveData(request, message);
         CalResponse response = setResponse(square, message);
		LOG.error("Request and Response "+requestResponseEntity.toString());
		return response;
		
	}
	
	@GetMapping(path = "/factorial/{num}")
	public CalResponse getFactorial(@PathVariable Double num) {
		Double result = calculatorService.getFactorial(num);
		String request=(num.toString());
		String message=(num.toString()) + "!" + " = " + (result.toString());
		CalResponse response = setResponse(result, message);
		 RequestResponseEntity requestResponseEntity=calculatorService.saveData(request, message);
		LOG.error("Request and Response "+requestResponseEntity.toString());
		return response;
		}

	
	
	@PostMapping("/min-max")
	public MinMaxResponse getMinMax(@RequestBody MinMaxRequest minMaxRequest) {
		
		MinMaxResponse minMaxResponse=calculatorService.getMinMax(minMaxRequest);
		String request=(minMaxRequest.toString());
		String message=((minMaxResponse.toString()));
		 RequestResponseEntity requestResponseEntity=calculatorService.saveData(request, message);
			LOG.error("Request and Response "+requestResponseEntity.toString());
		return minMaxResponse;
	}
	
	private CalResponse setResponse(Double add, String message) {
		CalResponse response=new CalResponse();
		response.setAnswer(add);
		response.setDetail(message);
		return response;
	}

	
}
