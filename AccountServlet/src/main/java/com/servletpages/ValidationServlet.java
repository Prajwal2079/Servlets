package com.servletpages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dal.AccountDALImp;
import com.pojo.Account;
import com.util.ConnectionToDatabase;

@WebServlet(value="/loginpage")
public class ValidationServlet extends HttpServlet {
	
	private AccountDALImp accImpl;
	@Override
	public void init() throws ServletException {
		try {
			ConnectionToDatabase.openConnection();
			accImpl = new AccountDALImp();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	@Override
	public void destroy() {
		
		try {
			ConnectionToDatabase.closeConnection();
			accImpl.cleanUp();
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		try(PrintWriter pw = resp.getWriter()) {
//			pw.write("<h1>Welcome To Login Page</h1>");
			int accountno = Integer.parseInt(req.getParameter("username"));
			String password = req.getParameter("password");
			Account acc = accImpl.validateAccount(accountno, password);
			if(acc!=null) {
			pw.write("<h1>Welcome To Login Page</h1>");
			pw.write("<p>Account No"+acc.getAccountno()+"</p>");
			pw.write("<p>Balance"+acc.getBalance()+"</p>");
			pw.write("<p>Account Type"+acc.getAcctype()+"</p>");
			
			}
			else {
				pw.write("<p>Invalid Username"+accountno+"</p>");
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}

}
