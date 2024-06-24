package com.zettamine.ums.services;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class CalculatorTest {
	private Integer input1;
	private Integer input2;
	private Integer expectedValue;
	
	public CalculatorTest(Integer input1, Integer input2, Integer expectedValue) {
		System.out.println("insiide constructor");
		this.input1 = input1;
		this.input2 = input2;
		this.expectedValue = expectedValue;
	}
	
	//@Parameters
	@Parameters(name = "{index}]: testAdd({0} + {1} = {2})")
	public static Collection<Integer[]> intializeData(){
		System.out.println("inside initializeData() method");
		List<Integer[]> elements = Arrays.asList(new Integer[][]{
									{10,10,20},  
									{20,-20,0}, 
									{-10,20,10}, 
									{-10,-20,-30}	
								});
		/*
		for(Integer[] ele : elements) {
			System.out.println(Arrays.toString(ele));
		}
		*/
		return elements;

	}
	@Test
	public void testAdd() {
		System.out.println("inside testcase..");
		Calculator calcObj = new Calculator();
		Integer actualValue = calcObj.add(input1, input2);
		assertEquals(expectedValue, actualValue);
	}

}
