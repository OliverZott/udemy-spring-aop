package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
		System.out.println("Advice @Before: '" + methodSignature + "'.");

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

	@AfterReturning(pointcut = "com.luv2code.aopdemo.aspect.AopExpressions.afterFindAccountsAdvice()", returning = "returnFindAccounts")
	public void afterReturnFindAccountsAdvice(JoinPoint joinPoint, List<Account> returnFindAccounts) {

		// print which method we are advising on
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("Advice @AfterReturning: " + methodName);
		System.out.println("Advice @AfterReturning-Result: " + returnFindAccounts);

		// print out the result of the method call with call-back (Modify-Result)
		convertAccountNamesToUpperCase(returnFindAccounts);

		System.out.println("Advice @AfterReturning-Result: " + returnFindAccounts);
	}

	private void convertAccountNamesToUpperCase(List<Account> returnFindAccounts) {

		for (Account tempAccount : returnFindAccounts) {
			String upperCaseAccountName = tempAccount.getName().toUpperCase();
			tempAccount.setName(upperCaseAccountName);
		}
	}

	@AfterThrowing(pointcut = "com.luv2code.aopdemo.aspect.AopExpressions.afterErrorFindAccountAdvice()", throwing = "exc")
	public void afterThrowingFindAccoundAdvice(JoinPoint joinPoint, Throwable exc) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("=======> Executing @AfterThrowing on: " + methodName);
		System.out.println("=======> The Exception is: " + exc);
	}

	@After("com.luv2code.aopdemo.aspect.AopExpressions.afterFinallyFindAccount()")
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("=======> Executing @After (finally) on: " + methodName);

	}
}
