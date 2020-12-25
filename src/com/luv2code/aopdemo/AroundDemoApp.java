package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {

		final Logger myLogger = Logger.getLogger(AroundDemoApp.class.getName());

		// read spring configuration java class
		// ApplicationContext is the spring container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from sprig container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);

		myLogger.info("Calling 'getFortuneTraffic' service method.");
		String data = trafficFortuneService.getFortune();
		myLogger.info("Fortune message: " + data);
		myLogger.info("Finished!");

		// close the context
		context.close();

	}

}
