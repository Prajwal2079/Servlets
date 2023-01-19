package com.dal;

import java.sql.SQLException;
import java.util.List;

import com.pojo.Account;

public interface AccountDAL {
	
	Account validateAccount(int accno,String password) throws SQLException;
	
	void registerNewAccount();
	

}
