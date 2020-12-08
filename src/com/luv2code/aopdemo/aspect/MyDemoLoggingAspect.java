package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// here we add all our related advices for logging

	// lets start with an @Before advice
	// "execution" is a point-cut!
	@Before("execution(boolean add*())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n=======>>>> Executon @Before advice on add*(), ONLY on return BOOLEAN");
	}

	@Before("execution(* com.luv2code.aopdemo.dao.MembershipDAO.addAccount())")
	public void beforeAddMembershipAccount() {
		System.out.println("\n=======>>>> Executon @Before advice on addAccount(), ONLY in MembershipDAO!");
	}
}
