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
import javax.servlet.http.HttpSession;

import com.areteans.pojo.ContactDetailsPojo;
import com.areteans.pojo.KycDetailsPojo;
import com.areteans.pojo.PersonalDetailsPojo;

@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	Connection con;
	PreparedStatement pStmt1;
	PreparedStatement pStmt2;
	PreparedStatement pStmt3;
	PreparedStatement pStmt4;
	
	@Override
	public void init() throws ServletException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank_Db","root", "root");
			
			pStmt1 = con.prepareStatement("select id from Personaldetails where fName = ? and bDate = ?");
			pStmt2 = con.prepareStatement("select id from contactdetails where email = ? ");
			pStmt3 = con.prepareStatement("select id from kycdetails where aadhar = ?");
			pStmt4 = con.prepareStatement("insert into customer (email, password, accType, accCategory, personalDetailsId, contactDetailsId, kycDetailsId) values (?,?,?,?,?,?,?)");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		PrintWriter out = resp.getWriter();
		
		String pass1 = req.getParameter("password1");
		String pass2 = req.getParameter("password2");
		
		String accType = (String) session.getAttribute("accType");
		String accCategory = (String) session.getAttribute("accCategory");
		String fName = (String) session.getAttribute("fName");
		String dob = (String) session.getAttribute("DOB");
		String email = (String) session.getAttribute("email");
		String aadhar = (String) session.getAttribute("aadhar");
		
		if(pass1.contentEquals(pass2)) {
			
			try {
				System.out.println("pdid");
				int personalDetailsId = 0;
				pStmt1.setString(1, fName);
				pStmt1.setString(2, dob);
				ResultSet rs1 = pStmt1.executeQuery();
				while(rs1.next()) {
					System.out.println("PDid : " + rs1.getInt(1));
					personalDetailsId = rs1.getInt(1);
				}
				
				///////////////////////////////////////
				
				int contactDetailsId = 0;
				pStmt2.setString(1, email);
				ResultSet rs2 = pStmt2.executeQuery();
				while(rs2.next()) {
					System.out.println("CDid : "+rs2.getInt(1));
					contactDetailsId = rs2.getInt(1);
				}
				
				////////////////////////////////////////
				
				int kycDetailsId = 0;
				pStmt3.setString(1, aadhar);
				ResultSet rs3 = pStmt3.executeQuery();
				while(rs3.next()) {
					System.out.println("KDid :  "+rs3.getInt(1));
					kycDetailsId = rs3.getInt(1);
				}
				
				////////////////////////////////////////////
				
				
			  pStmt4.setString(1, email);
			  pStmt4.setString(2, pass2);
			  pStmt4.setString(3,accType);
			  pStmt4.setString(4, accCategory);
			  pStmt4.setInt(5,personalDetailsId);
			  pStmt4.setInt(6, contactDetailsId);
			  pStmt4.setInt(7,kycDetailsId);
			  
			  int rows = pStmt4.executeUpdate(); 
			  if(rows >= 1) {
				  System.out.println("account created sucessfully");
				  session.invalidate();
				  out.println("<html><body>"+
				  "<h2>Congratulations your account created sucessfully..</h2><br>"+
				  "<a href='home.jsp'>Home</a>"+ "</body></html>");
			  } 
			  else {
				  System.out.println("Failed to create account");
				  resp.sendRedirect("kycDetails.jsp"); 
			  }
			 
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
