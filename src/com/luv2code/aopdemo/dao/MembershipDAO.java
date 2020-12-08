package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addAccount() {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(this.getClass() + " - " + name);
	}
	
	public boolean addAccountBoolean() {
		String name = new Object(){}.getClass().getEnclosingMethod().getName();
		System.out.println(getClass() + " - " + name);
		return true;
	}

}
