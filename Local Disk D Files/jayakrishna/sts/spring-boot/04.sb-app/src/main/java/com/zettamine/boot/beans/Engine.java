package com.zettamine.boot.beans;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Engine {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Engine.class);
	
	public Engine() {
		LOGGER.info("Engine :: Constructor");
	}
	
	public boolean startEngine() {
		return new Random().nextBoolean();
	}
}
