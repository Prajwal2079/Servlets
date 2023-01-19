package com.servletpages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dal.AccountDALImp;
import com.util.ConnectionToDatabase;

@WebServlet(value="/register",loadOnStartup = 1)
public class RegistrationServlet extends HttpServlet{
	
	private AccountDALImp accImpl;
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
			double balance = Double.parseDouble(req.getParameter("balance"));
			String acctype = req.getParameter("acctype");
			String pass = req.getParameter("password");
			
			int res =accImpl.registerNewAccount(acctype,balance,pass);
			
			if(res>0) {
				pw.append("<h3>Account Added Successfully</h3>");	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {
		try {
			ConnectionToDatabase.openConnection();
			accImpl = new AccountDALImp();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	

}
