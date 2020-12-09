package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean vipFlag) {
		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(getClass() + " - " + name);
	}

}
