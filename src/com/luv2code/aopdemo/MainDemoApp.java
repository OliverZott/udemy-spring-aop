package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
		// ApplicationContext is the spring container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from sprig container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call the business method
		Account testAccount = new Account("Noob", "Olli");
		theAccountDAO.addAccount(testAccount, true);
		theMembershipDAO.addAccount();
		theMembershipDAO.addAccountBoolean();

		// close the context
		context.close();

	}

}
