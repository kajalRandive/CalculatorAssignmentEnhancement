package com.assignment2.enhancement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.assignment2.enhancement.dao.CalculatorDao;
import com.assignment2.enhancement.entity.RequestResponseEntity;
import com.assignment2.enhancement.requestresponse.MinMaxRequest;
import com.assignment2.enhancement.requestresponse.MinMaxResponse;

@Service("calculatorService")
public class CalculatorServiceImpl {

	@Autowired
	@Qualifier("calDao")
	CalculatorDao calDao;
	
	@Cacheable(value = "calculatorCache", key = "'addition:' + #number1 + ':' + #number2", unless = "#result == null")
	public double addition(double number1,double number2) {
		double sum;
		return sum=number1+number2;
		
	}
	
	@Cacheable(value = "calculatorCache", key = "'substraction:' + #number1 + ':' + #number2", unless = "#result == null")
    public double substraction (double number1, double number2) {
		double substraction;
		return substraction=number1-number2;
		
	}
	
	@Cacheable(value = "calculatorCache", key = "'multiplication:' + #number1 + ':' + #number2", unless = "#result == null")
    public double multiplication(double number1,double number2) {
		double mul;
		return mul=number1*number2;
	}
	
	@Cacheable(value = "calculatorCache", key = "'division:' + #number1 + ':' + #number2", unless = "#result == null")
	public double division(double number1,double number2) {
		double mul;
		return mul=number1/number2;
	}
	
	@Cacheable(value = "calculatorCache", key = "'getSquare:' + #number", unless = "#result == null")

	public double getSquare(double number) {
		double num;
		return num=number*number;
		
	
	}
	@Cacheable(value = "calculatorCache", key = "'getFactorial:' + #num", unless = "#result == null")

	public double getFactorial(double num) {
		
		Double result = getFac(num);
		return result;
		
	}
	private Double getFac(Double num) {
		if (num == 1 || num == 0)
			return (double) 1;
		else
			return (num * getFac(num - 1));
	}
	
	@Cacheable(value = "CalculatorCache", key = "'maxMin:'+ #numbers", unless = "#result == null")
	public MinMaxResponse getMinMax(MinMaxRequest minMaxRequest) {
		
		int max = minMaxRequest.getNumbers().stream().max(Integer::compare).get();
		int min = minMaxRequest.getNumbers().stream().min(Integer::compare).get();
		MinMaxResponse minMaxResponse=new MinMaxResponse();
		minMaxResponse.setMax(max);
		minMaxResponse.setMin(min);
		return minMaxResponse;
		
		
	}
	
	public RequestResponseEntity saveData(String request,String message) {
		
		RequestResponseEntity requestResponseEntity=new RequestResponseEntity();
		requestResponseEntity.setRequest(request);
		requestResponseEntity.setResponse(message);
		requestResponseEntity.setTime(new java.util.Date());
		calDao.save(requestResponseEntity);
		return requestResponseEntity;
		
		
		
	}
}
