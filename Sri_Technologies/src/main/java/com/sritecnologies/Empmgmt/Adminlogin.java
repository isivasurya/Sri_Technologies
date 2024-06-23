package com.sritecnologies.Empmgmt;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Adminlogin
 */
@WebServlet("/Adminlogin")
public class Adminlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String aemail = request.getParameter("aemail");
	        String apwd = request.getParameter("apwd");
	        HttpSession session = request.getSession();
	        Connection con = null;
	        RequestDispatcher dispatcher = null;

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sri_technologies", "root", "root");
	            PreparedStatement pst = con.prepareStatement("SELECT * FROM ADMINDETAILS WHERE AEMAIL = ? AND APWD = ?");
	            pst.setString(1, aemail);
	            pst.setString(2, apwd);
	            ResultSet rs = pst.executeQuery();

	            if (rs.next()) {
	                session.setAttribute("aemail", rs.getString("aemail"));
	                session.setAttribute("aname", rs.getString("aname"));
	                System.out.println("logged in");
	                dispatcher = request.getRequestDispatcher("adminhome.jsp");
	                dispatcher.forward(request, response);
	            } else {
	                request.setAttribute("Status", "Failed");
	                dispatcher = request.getRequestDispatcher("admin.jsp");
	                dispatcher.forward(request, response);
	                System.out.println("login failed");
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("errorMessage", e.getMessage());
	            dispatcher = request.getRequestDispatcher("error.jsp");
	            dispatcher.forward(request, response);
	        } finally {
	            try {
	                if (con != null) {
	                    con.close();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }

}
