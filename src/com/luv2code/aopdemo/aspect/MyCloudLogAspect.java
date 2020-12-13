package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {

	@Before("com.luv2code.aopdemo.aspect.AopExpressions.forMembershipDao()")
	public void beforeAddMembershipAccount() {
		System.out.println("\n=======>>>> 1. - execution(* com.luv2code.aopdemo.dao.MembershipDAO.*(..))");
	}

}