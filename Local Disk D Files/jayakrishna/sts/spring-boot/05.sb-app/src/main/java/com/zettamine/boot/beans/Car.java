package com.zettamine.boot.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
//	@Autowired
//	@Qualifier
	private Engine engine;
	private static final Logger LOG = LoggerFactory.getLogger(Car.class);
	
	public Car() {
		LOG.info("Car Constructor");
	}
	
	@Autowired
	public Car(@Qualifier Engine engine) {
		LOG.info("Car :: One-param Constructor");
		this.engine = engine;
		
	}

//	@Autowired
//	public void setEngine(@Qualifier Engine engine) {
//		this.engine = engine;
//	}
	
	public void startJourney() {
		boolean startEngine = engine.startEngine();
		if(engine instanceof PetrolEngine) LOG.info("Petrol Engine instance being used");
		else LOG.info("Diesel Engine instance being used");
		if(startEngine) {
			LOG.info("@@@---Engine is started---@@@");
			LOG.info("###Happy Journey###");
		}
		else {
			LOG.warn("@@@---Engine is not started,So Journey Not Possible---@@@");
		}
	}
	
}
