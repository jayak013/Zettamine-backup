package com.zettamine.data;

import java.util.Arrays;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.zettamine.data.services.DataServices;
@ComponentScan
public class Main {

	public static void main(String[] args) {
		try(ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Main.class)){
				
			DataServices ds = context.getBean(DataServices.class);
			int max = ds.findMax();
			System.out.println("max value = " + max);
		}

	}

}
