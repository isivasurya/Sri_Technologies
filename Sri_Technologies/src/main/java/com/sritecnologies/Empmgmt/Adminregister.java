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
 * Servlet implementation class Adminregister
 */
@WebServlet("/Adminregister")
public class Adminregister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminid=request.getParameter("adminid");
		String aname=request.getParameter("aname");
		String aemail=request.getParameter("aemail");
		String apwd=request.getParameter("apwd");
		String amobile=request.getParameter("amobile");
		RequestDispatcher dispatcher = null;
		Connection con=null;
		HttpSession session = request.getSession();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sri_technologies","root","root");
			PreparedStatement pst=con.prepareStatement("INSERT INTO ADMINDETAILS(ADMINID,ANAME,AEMAIL,APWD,AMOBILE) VALUES(?,?,?,?,?)");
			pst.setString(1, adminid);
			pst.setString(2, aname);
			pst.setString(3, aemail);
			pst.setString(4, apwd);
			pst.setString(5, amobile);
			int rowcount=pst.executeUpdate();
			dispatcher=request.getRequestDispatcher("empregn.jsp");
			if(rowcount > 0) {
				request.setAttribute("Status", "Success");
				session.setAttribute("message", "Admin registered successfully!");
	            session.setAttribute("messageType", "success");
				dispatcher = request.getRequestDispatcher("adminregn.jsp");
				
			}else {
				request.setAttribute("Status", "Failed");
				 session.setAttribute("message", "Failed to Update Admin!");
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
