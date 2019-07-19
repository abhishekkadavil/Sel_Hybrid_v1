package com.seleniumHybrid.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	
	public static Logger logger;
	// Initialize Log4j logs
	public static void InitLog() 
	{
		logger=Logger.getLogger("Sel_Hybrid_v1");
		PropertyConfigurator.configure("Log4J.properties");
	}
	
	// This is to print log for the beginning of the test case, as we usually run so
	// many test cases as a test suite
	public static void startTestCase(String sTestCaseName) 
	{
		logger.info("****************************************************************************************");
		logger.info("****************************************************************************************");
		logger.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		logger.info("****************************************************************************************");
		logger.info("****************************************************************************************");
	}

	// This is to print log for the ending of the test case
	public static void endTestCase(String sTestCaseName) {
		logger.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");
		logger.info("X");
		logger.info("X");
		logger.info("X");
		logger.info("X");
	}

	// Need to create these methods, so that they can be called
	public static void info(String message) {
		logger.info(message);
	}

	public static void warn(String message) {
		logger.warn(message);
	}

	public static void error(String message) {
		logger.error(message);
	}

	public static void fatal(String message) {
		logger.fatal(message);
	}

	public static void debug(String message) {
		logger.debug(message);
	}
}