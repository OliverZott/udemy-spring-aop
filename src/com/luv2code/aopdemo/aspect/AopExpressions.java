package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

	// Pointcut Declaration for usage in various Aspects

	// Package name + class + method-wildcard ( 0 or more parameters)
	@Pointcut("execution(* com.luv2code.aopdemo.dao.MembershipDAO.*(..))")
	public void forMembershipDao() {
	}

	@Pointcut("execution(boolean com.luv2code.aopdemo.dao.MembershipDAO.*(..))")
	public void noBoolean() {
	}

	@Pointcut("forMembershipDao() && !noBoolean()")
	public void forMembershipDaoNoBoolean() {
	}

	@Pointcut("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	public void beforeAddAccountAdvice() {
	}

	@Pointcut("execution(* com.luv2code.aopdemo.dao.AccountDAO.find*(..))")
	public void afterFindAccountsAdvice() {
	}

	@Pointcut("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterErrorFindAccountAdvice() {
	}

}
