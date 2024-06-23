package com.sritecnologies.Empmgmt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Empregn
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid=request.getParameter("empid");
		String empname=request.getParameter("empname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String mobile=request.getParameter("mobile");
		String empdept=request.getParameter("empdept");
		RequestDispatcher dispatcher = null;
		Connection con=null;
		HttpSession session = request.getSession();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sri_technologies","root","root");
			PreparedStatement pst=con.prepareStatement("INSERT INTO EMPDETAILS(EMPID,EMPNAME,EMAIL,PASSWORD,MOBILE,EMPDEPT) VALUES(?,?,?,?,?,?)");
			pst.setString(1, empid);
			pst.setString(2, empname);
			pst.setString(3, email);
			pst.setString(4, password);
			pst.setString(5, mobile);
			pst.setString(6, empdept);
			int rowcount=pst.executeUpdate();
			dispatcher=request.getRequestDispatcher("empregn.jsp");
			if(rowcount > 0) {
				request.setAttribute("Status", "Success");
				session.setAttribute("message", "Employee registered successfully!");
	            session.setAttribute("messageType", "success");
				dispatcher = request.getRequestDispatcher("empregn.jsp");
			}else {
				request.setAttribute("Status", "Failed");
				 session.setAttribute("message", "Failed to Update Employee!");
	             session.setAttribute("messageType", "danger");
	                
			}
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null){
				con.close();
			} }catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}

}
