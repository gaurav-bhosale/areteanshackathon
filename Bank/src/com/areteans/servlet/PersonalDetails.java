package com.areteans.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.areteans.pojo.PersonalDetailsPojo;

@WebServlet("/PersonalDetails")
public class PersonalDetails extends HttpServlet{

	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pStmt;

	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_Db","root", "root");
			
			pStmt = con.prepareStatement("insert into personaldetails (fName, mName, lName, motherName, bDate, gender, maritalStatus) values (?,?,?,?,?,?,?)");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String fName = req.getParameter("fName");
		String mName = req.getParameter("mName");
		String lName = req.getParameter("lName");
		String motherName = req.getParameter("motherName");
		String bDate = req.getParameter("bDate");
		String gender = req.getParameter("gender");
		String maritalStatus = req.getParameter("maritalStatus");
		
		session.setAttribute("fName", fName);
		session.setAttribute("DOB", bDate);
		 
		try {
			
			pStmt.setString(1, fName);
			pStmt.setString(2, mName);
			pStmt.setString(3, lName);
			pStmt.setString(4, motherName);
			pStmt.setString(5, bDate);
			pStmt.setString(6, gender);
			pStmt.setString(7, maritalStatus);
			int rows1 = pStmt.executeUpdate();
			if(rows1 >= 1) {
				System.out.println("personalDetails added sucessfully");
				resp.sendRedirect("contactDetails.jsp");
			}
			else {
				System.out.println("Failed to add personalDetails");
				resp.sendRedirect("personalDetails.jsp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
