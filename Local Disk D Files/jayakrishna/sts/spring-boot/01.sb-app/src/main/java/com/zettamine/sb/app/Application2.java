package com.zettamine.sb.app;

import java.util.logging.Logger;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import ch.qos.logback.classic.BasicConfigurator;
import ch.qos.logback.classic.spi.Configurator;


@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan
public class Application2 {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application2.class, args);
		
		
		
		int beanCount = context.getBeanDefinitionCount();
		System.out.println("Number of beans created : "+beanCount);
		
		
		String[] beanNames = context.getBeanDefinitionNames();
		System.out.println("Name of the beans created : ");
		Stream.of(beanNames).forEach(System.out::println);
	}

}
