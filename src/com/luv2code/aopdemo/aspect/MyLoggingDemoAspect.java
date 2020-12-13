package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyLoggingDemoAspect {

	@Before("com.luv2code.aopdemo.aspect.AopExpressions.beforeAddAccountAdvice()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======>>>> 2. - execution(* add*(com.luv2code.aopdemo.Account, ..))");
	}

}
