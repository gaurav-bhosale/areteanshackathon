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

import com.areteans.pojo.ContactDetailsPojo;

@WebServlet("/ContactDetails")
public class ContactDetails extends HttpServlet{

	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pStmt;
	
	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_Db","root", "root");
			
			pStmt = con.prepareStatement("insert into contactdetails (email, mobile, altMobile, addLine1, addLine2, city, state, pincode) values (?,?,?,?,?,?,?,?)");
			
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
		String mobile = req.getParameter("mobile");
		String altMobile = req.getParameter("altMobile");
		String addLine1 = req.getParameter("addLine1");
		String addLine2 = req.getParameter("addLine2");
		String city = req.getParameter("city");
		String state = req.getParameter("state");
		String pincode = req.getParameter("pincode");
		
		session.setAttribute("email", email);
		
		try {
			
			pStmt.setString(1, email);
			pStmt.setString(2, mobile);
			pStmt.setString(3, altMobile);
			pStmt.setString(4, addLine1);
			pStmt.setString(5, addLine2);
			pStmt.setString(6, city);
			pStmt.setString(7, state);
			pStmt.setString(8, pincode);
			int rows1 = pStmt.executeUpdate();
			if(rows1 >= 1) {
				System.out.println("contactDetails added sucessfully");
				resp.sendRedirect("kycDetails.jsp");
			}
			else {
				System.out.println("Failed to add contactDetails");
				resp.sendRedirect("contactDetails.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
