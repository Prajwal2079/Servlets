package com.dal;

import java.sql.SQLException;
import java.util.List;

import com.pojo.Account;

public interface AccountDAL {
	
	Account validateAccount(int accno,String password) throws SQLException;
	
	int registerNewAccount(String actype, double balance, String password) throws SQLException;
	

}
