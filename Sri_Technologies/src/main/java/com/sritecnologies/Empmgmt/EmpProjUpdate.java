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
 * Servlet implementation class EmpProjUpdate
 */
@WebServlet("/EmpProjUpdate")
public class EmpProjUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String projid = request.getParameter("projid");
        String taskdone = request.getParameter("taskdone");
        String comments = request.getParameter("comments");
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = null;
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sri_technologies", "root", "root");
            
            // Update query
            PreparedStatement pst = con.prepareStatement("UPDATE PROJECTS SET TASKDONE = ?, COMMENTS = ? WHERE PROJID = ?");
            
            pst.setString(1, taskdone);
            pst.setString(2, comments);
            pst.setString(3, projid);
            
            int rowcount = pst.executeUpdate();
            dispatcher = request.getRequestDispatcher("empHome.jsp");
            if(rowcount > 0) {
                request.setAttribute("Status", "Success");
                session.setAttribute("message", "Project Updated successfully!");
	            session.setAttribute("messageType", "success");
                System.out.println("Project update successful");
            } else {
                request.setAttribute("Status", "Failed");
                session.setAttribute("message", "Failed to Update project!");
                session.setAttribute("messageType", "danger");
                System.out.println("Project update failed");
            }
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
