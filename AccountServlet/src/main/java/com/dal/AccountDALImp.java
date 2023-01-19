package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.Account;
import com.util.ConnectionToDatabase;

public class AccountDALImp implements AccountDAL{
	
	private Connection con;
	private PreparedStatement pstmt,pstmt1;
	private ResultSet result;
	
	public AccountDALImp() throws SQLException {
		con = ConnectionToDatabase.getConnection();
		pstmt = con.prepareStatement("Select * from account where accno = ? and password = ?");
		pstmt1 = con.prepareStatement("insert into account values(default,?,?,?)");
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
	public int registerNewAccount(String acctype,double balance,String password) throws SQLException {
		pstmt1.setString(1,acctype);
		pstmt1.setDouble(2,balance);
		pstmt1.setString(3, password);
		
		int res = pstmt1.executeUpdate();
		
		return res;
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
