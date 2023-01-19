package com.pojo;

public class Account {

	private int accountno;
	private String acctype;
	private double balance;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public String getAcctype() {
		return acctype;
	}
	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Account(int accountno, String acctype, double balance, String password) {
		super();
		this.accountno = accountno;
		this.acctype = acctype;
		this.balance = balance;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Account [accountno=" + accountno + ", acctype=" + acctype + ", balance=" + balance + ", password="
				+ password + "]";
	}
	




}
