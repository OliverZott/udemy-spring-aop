package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyLoggingDemoAspect {

	@Before("com.luv2code.aopdemo.aspect.AopExpressions.beforeAddAccountAdvice()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {

		// display method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		System.out.println("Aspect Method: '" + methodSignature + "'.");

		// display method arguments
		Object[] args = joinPoint.getArgs();
		for (Object argument : args) {
			System.out.println(argument);

			// downcast general object to account
			if (argument instanceof Account) {

				Account account = (Account) argument;
				System.out.println("    Name: " + account.getName());
				System.out.println("    Level: " + account.getLevel());
				System.out.println("    ClassName: " + account.getClass());
			}
		}
	}

}
