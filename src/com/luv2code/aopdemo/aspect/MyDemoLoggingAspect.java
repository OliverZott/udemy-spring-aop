package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// "execution" is a point-cut!
	@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======>>>> Executon @Before advice on add*(), ONLY on correct PARAMETER + wildcard");
	}

	//
	@Before("execution(boolean add*())")
	public void beforeAddAccountAdviceBoolean() {
		System.out.println("\n=======>>>> Executon @Before advice on add*(), ONLY on return BOOLEAN");
	}

	// Package name + class + method-wildcard ( 0 or more parmeters)
	@Before("execution(* com.luv2code.aopdemo.dao.MembershipDAO.*(..))")
	public void beforeAddMembershipAccount() {
		System.out.println("\n=======>>>> Executon @Before advice on addAccount(), ONLY in MembershipDAO!");
	}

}