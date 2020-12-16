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

import com.areteans.pojo.KycDetailsPojo;

@WebServlet("/KycDetails")
public class KycDetails extends HttpServlet{

	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pStmt;
	
	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_Db","root", "root");
			
			pStmt = con.prepareStatement("insert into kycdetails (aadhar, pan) values (?,?)");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		String aadhar = req.getParameter("aadhar");
		String reAadhar = req.getParameter("reAadhar");
		String pancard = req.getParameter("pancard");
		
		if(aadhar.equals(reAadhar)) {
			
			session.setAttribute("aadhar", aadhar);
			try {
				pStmt.setString(1, aadhar);
				if(pancard == null) {
					pStmt.setString(2, "Not Available");
				}
				else {
					pStmt.setString(2, pancard);
				}
				int rows1 = pStmt.executeUpdate();
				if(rows1 >= 1) {
					System.out.println("kycDetails added sucessfully");
					resp.sendRedirect("terms.jsp");
				}
				else {
					System.out.println("Failed to add kycDetails");
					resp.sendRedirect("kycDetails.jsp");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
