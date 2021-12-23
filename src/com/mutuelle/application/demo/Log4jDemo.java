package com.mutuelle.application.demo;

import org.apache.log4j.Logger;


public class Log4jDemo {
	
	static  final Logger log = Logger.getLogger(Log4jDemo.class.getName());
  
	public static void main(String[] args) {
		log.info("errrr");
	}
}
