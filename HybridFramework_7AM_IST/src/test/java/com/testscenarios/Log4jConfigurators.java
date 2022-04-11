package com.testscenarios;



import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;




public class Log4jConfigurators {

   static Logger logger = Logger.getLogger(Log4jConfigurators.class);
   
	public static void main(String[] args) {
		
		BasicConfigurator.configure();
		logger.info("This is a info");
		logger.warn("This is a warning");
		logger.error("This is a error");
		logger.fatal("This is a fatal");
		
		
		PropertyConfigurator.configure("log4j.properties");
		logger.info("This is a info");
		logger.warn("This is a warning");
		logger.error("This is a error");
		logger.fatal("This is a fatal");
		
	    DOMConfigurator.configure("log4j.xml");
		logger.info("This is a info");
		logger.warn("This is a warning");
		logger.error("This is a error");
		logger.fatal("This is a fatal");
    }

}
