package com.zettamine.reports;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ReportGenerator {
	private static final Logger LOGGER = Logger.getLogger(ReportGenerator.class);
	
	public static void main(String[] args) {
		generateReport();
	}

	private static void generateReport() {
//		BasicConfigurator.configure();
//		LOGGER.setLevel(Level.ALL);
//		LOGGER.setLevel(Level.DEBUG);
//		LOGGER.setLevel(Level.INFO);
//		LOGGER.setLevel(Level.WARN);
		PropertyConfigurator.configure("src/main/resources/log4j.properties");
		LOGGER.debug("DEBUG Message");
		LOGGER.info("INFO Message");
//		try {
//			Thread.currentThread().sleep(2000);
//		}catch(Exception e) {}
		LOGGER.warn("WARN Message");
		LOGGER.error("ERROR Message");
		LOGGER.fatal("FATAL Message");
		LOGGER.trace("TRACE Message");
	}
	
}
