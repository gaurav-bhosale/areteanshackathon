package com.areteans.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet("/ListAllCustomers")
public class ListAllCustomers extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	Connection con;
	PreparedStatement pStmt;
	
	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_Db","root", "root");
			
			pStmt = con.prepareStatement("SELECT * FROM customer");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		try {
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
