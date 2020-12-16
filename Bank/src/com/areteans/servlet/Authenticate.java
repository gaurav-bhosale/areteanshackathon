package com.areteans.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Authenticate")
public class Authenticate extends HttpServlet{

	private static final long serialVersionUID = 1L;

	Connection con;
	PreparedStatement pStmt;
	
	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_Db","root", "root");
			
			pStmt = con.prepareStatement("SELECT * FROM customer WHERE email = ? and password = ?");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		HttpSession session = req.getSession();
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		try {
			pStmt.setString(1, email);
			pStmt.setString(2, password);
			
			ResultSet rs = pStmt.executeQuery();
			if(rs.next()) {
				
					if(email.equals(rs.getString(2)) && password.equals(rs.getString(3))){
						System.out.println("Customer Logged In");
						session.setAttribute("custId", rs.getInt(1));
						resp.sendRedirect("customerHome.jsp");
					}
				}
			else {
				if(email.equals("admin") && password.equals("admin")) {
					System.out.println("Bank admin Logged In");
					resp.sendRedirect("adminHome.jsp");
				}
				else {
					System.out.println("Invalid username or password try again ");
					resp.sendRedirect("login.jsp");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
