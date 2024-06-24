package com.zettamine.boot.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Car.class);
	
	@Autowired
	private Engine engine;
	
	public Car() {
		LOGGER.info("Car :: Constructor");
	}
	
//	@Autowired
//	public Car(Engine engine) {
//		LOGGER.info("Car :: one-parameter Constructor");
//		this.engine = engine;
//	}

//	@Autowired
//	public void setEngine(Engine engine) {
//		this.engine = engine;
//	}
	
	public void startJourney() {
		boolean startEngine = engine.startEngine();
		if(startEngine) {
			LOGGER.info("@@@---Engine is started---@@@");
			LOGGER.info("###Happy Journey###");
		}
		else {
			LOGGER.error("@@@---Engine is not started,So Journey Not Possible---@@@");
		}
	}
	
}
