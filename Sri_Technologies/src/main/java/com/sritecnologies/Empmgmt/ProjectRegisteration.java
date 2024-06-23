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
 * Servlet implementation class ProjectRegisteration
 */
@WebServlet("/ProjectRegisteration")
public class ProjectRegisteration extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String projid=request.getParameter("projid");
		String projname=request.getParameter("projname");
		String taskdone=request.getParameter("taskdone");
		String comments=request.getParameter("comments");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/sri_technologies","root","root");
			PreparedStatement pst=con.prepareStatement("INSERT INTO PROJECTS(PROJID,PROJNAME,TASKDONE,COMMENTS) VALUES(?,?,?,?)");
			pst.setString(1, projid);
			pst.setString(2, projname);
			pst.setString(3, taskdone);
			pst.setString(4, comments);
			
			int rowcount=pst.executeUpdate();
			dispatcher=request.getRequestDispatcher("adminhome.jsp");
			if(rowcount > 0) {
				request.setAttribute("Status", "Success");
				dispatcher = request.getRequestDispatcher("adminhome.jsp");
				 session.setAttribute("message", "Project added successfully!");
	             session.setAttribute("messageType", "success");
				System.out.println("proj regn sucess");
			}else {
				request.setAttribute("Status", "Failed");
				session.setAttribute("message", "Failed to add project!");
                session.setAttribute("messageType", "danger");
				System.out.println("proj regn failed");
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
