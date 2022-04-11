package com.testscenarios;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
 
public class Log4j {
  static final Logger logger = LogManager.getLogger(Log4j.class.getName());
@SuppressWarnings("deprecation")
public static Boolean main(String[] args) {
	 logger.entry();
	    logger.error("Did it again!");
	    return logger.exit(false);
	  }
}
	