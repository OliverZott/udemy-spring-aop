package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {

		// simulate delay
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// return fortune
		return "Expect heavy traffic!";

	}

	public String getFortune(boolean tripWire) {

		if (tripWire) {
			throw new RuntimeException("Exception here!");
		}

		return getFortune();
	}

}
