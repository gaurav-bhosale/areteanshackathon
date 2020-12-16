package com.areteans.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SetAccountType")
public class SetAccountType extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public SetAccountType() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		
		String accType = req.getParameter("accountType");
		String accCategory = req.getParameter("accountCat");
		
		if(accCategory.equals("joint")) {
			out.println("<!DOCTYPE html>\r\n" + 
					"<html>"+
					"<script>\r\n" + 
					"		function goBack() {\r\n" + 
					"		  window.history.back();\r\n" + 
					"		}\r\n" + 
					"	</script>"+
					"<body>"+
					"<h3> We are sorry to inform you that, Joint Account Facility is not Available Online. Please visit out nearest Branch to open a join Account</h3>\r\n" + 
					"			<h3>Thank you !</h3>\r\n" + 
					"			<button onclick=\"goBack()\">Go Back</button>"+
					"</body></html>");
		}
		else {
			session.setAttribute("accType", accType);
			session.setAttribute("accCategory", accCategory);
			resp.sendRedirect("personalDetails.jsp");
		}
	}
}
