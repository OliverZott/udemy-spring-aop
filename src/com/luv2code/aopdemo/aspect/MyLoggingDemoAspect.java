package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	private Logger myLogger = Logger.getLogger(MyLoggingDemoAspect.class.getName());

	@Before("com.luv2code.aopdemo.aspect.AopExpressions.beforeAddAccountAdvice()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {

		// display method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		myLogger.info("Advice @Before: '" + methodSignature + "'.");

		// display method arguments
		Object[] args = joinPoint.getArgs();
		for (Object argument : args) {
			myLogger.info(argument.toString());

			// downcast general object to account
			if (argument instanceof Account) {

				Account account = (Account) argument;
				myLogger.info("    Name: " + account.getName());
				myLogger.info("    Level: " + account.getLevel());
				myLogger.info("    ClassName: " + account.getClass());
			}
		}
	}

	@AfterReturning(pointcut = "com.luv2code.aopdemo.aspect.AopExpressions.afterFindAccountsAdvice()", returning = "returnFindAccounts")
	public void afterReturnFindAccountsAdvice(JoinPoint joinPoint, List<Account> returnFindAccounts) {

		// print which method we are advising on
		String methodName = joinPoint.getSignature().toShortString();
		myLogger.info("Advice @AfterReturning: " + methodName);
		myLogger.info("Advice @AfterReturning-Result: " + returnFindAccounts);

		// print out the result of the method call with call-back (Modify-Result)
		convertAccountNamesToUpperCase(returnFindAccounts);

		myLogger.info("Advice @AfterReturning-Result: " + returnFindAccounts);
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
		myLogger.info("=======> Executing @AfterThrowing on: " + methodName);
		myLogger.info("=======> The Exception is: " + exc);
	}

	@After("com.luv2code.aopdemo.aspect.AopExpressions.afterFinallyFindAccount()")
	public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		myLogger.info("=======> Executing @After (finally) on: " + methodName);
	}

	@Around("com.luv2code.aopdemo.aspect.AopExpressions.aroundGetFortuneAdvice()")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		// print out method we are advising on
		String methodName = proceedingJoinPoint.getSignature().toShortString();
		myLogger.info("=======> Executing @Around on: " + methodName);

		// get begin time-stamp
		long begin = System.currentTimeMillis();

		Object result = null;

		/**
		 * Execute method and handle exception Exception handling inside this advice !!!
		 */
		try {
			result = proceedingJoinPoint.proceed();
		} catch (Throwable e) {

			// Best practice: LOG exception
			myLogger.warning(e.getMessage());

			// Re-Throw exception
			throw e;
		}

		// get end time-stamp
		long end = System.currentTimeMillis();

		// compute + display duration
		myLogger.info("Method execution took " + (end - begin) + " ms");

		return result;
	}

}
