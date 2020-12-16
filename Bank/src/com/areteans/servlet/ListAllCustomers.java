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
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		try {
			ResultSet rs = pStmt.executeQuery();
			out.println("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"ISO-8859-1\">\r\n" + 
					"<title>Insert title here</title>\r\n" + 
					"</head>\r\n" + 
					"	<body>\r\n" + 
					"		<table>\r\n" + 
					"			<tr>\r\n" + 
					"				<th> Account Number </th>\r\n" + 
					"				<th> Account Type </th>\r\n" + 
					"				<th> Balance </th>\r\n" + 
					"			</tr>\r\n" + 
					"			<tr>");
			while(rs.next()) {
				out.println("<td>"+rs.getInt(1)+"</td>"+
						"<td>"+rs.getInt(4)+"</td>"+
						"<td>"+rs.getInt(9)+"</td>"+
						"<td><a href=\"Credit?id=1\">Credit</a></td>\r\n" + 
						"<td><a href=\"Debit?id=1\">Debit</a></td>\r\n" + 
						"<td><a href=\"GetDetails?id=1\">Details</a></td>");
			}
			out.println("</tr>\r\n" + 
					"		</table>\r\n" + 
					"	</body>\r\n" + 
					"</html>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
