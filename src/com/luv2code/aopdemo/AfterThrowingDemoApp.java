package com.luv2code.aopdemo;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
		// ApplicationContext is the spring container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get bean from sprig container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method with try-catch block
		List<Account> accounts = null;
		try {
			accounts = theAccountDAO.findAccounts(true);
		} catch (Exception e) {
			System.out.println("Main programm, caught exception: " + e);
		}

		System.out.println(accounts);
		// close the context
		context.close();

	}

}
