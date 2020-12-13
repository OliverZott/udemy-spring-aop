package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	public List<Account> findAccounts() {
		List<Account> accounts = new ArrayList<>();

		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println("EXECUTED: " + this.getClass() + " - " + name);

		// create sample accounts and add to list
		Account account1 = new Account("Silver", "John");
		Account account2 = new Account("Gold", "Anne");
		Account account3 = new Account("Deluxe", "Max");

		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);

		return accounts;
	}

	public void addAccount(Account account, boolean vipFlag) {
		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();
		System.out.println(getClass() + " - " + name);
	}

}
