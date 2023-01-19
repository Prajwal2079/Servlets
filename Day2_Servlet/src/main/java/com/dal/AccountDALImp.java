package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.Account;
import com.util.ConnectionToDatabase;

public class AccountDALImp implements AccountDAL{
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet result;
	
	public AccountDALImp() throws SQLException {
		con = ConnectionToDatabase.getConnection();
		pstmt = con.prepareStatement("Select * from account where accno = ? and password = ?");
	}

	@Override
	public Account validateAccount(int accno,String password) throws SQLException {
		Account account = null;
		pstmt.setInt(1,accno);
		pstmt.setString(2, password);
		result = pstmt.executeQuery();
		while(result.next()) {
			account = new Account(result.getInt("accno"),result.getString("acctype"),result.getDouble("balance"),result.getString("password"));
		}
		return account;
	}

	@Override
	public void registerNewAccount() {
		
		
	}
	
	public void cleanUp() {
		try {
			pstmt.close();
			result.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
