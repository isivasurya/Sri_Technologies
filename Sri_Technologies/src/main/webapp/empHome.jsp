<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% 
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Home</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
 <style>
 	 .navbar-custom {
            background-color: black;
        }
 	.nav-link {
            color: white;
            font-size: 1.25rem; 
            margin-right: 20px; 
        }
 .footer {
    position: fixed;
    left: 0;
    bottom: 0;
    width: 100%;
    background-color: #343a40;
    color: #ffffff;
    text-align: center;
    padding: 10px 0;
  }
 </style>
</head>
<body>
    <%
        HttpSession sessionCheck = request.getSession(false);
        if (sessionCheck == null || sessionCheck.getAttribute("email") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        String message = (String) sessionCheck.getAttribute("message");
        String messageType = (String) sessionCheck.getAttribute("messageType");
        sessionCheck.removeAttribute("message");
        sessionCheck.removeAttribute("messageType");
    %>
    
    
    <nav class="navbar navbar-expand-lg navbar-custom">
    <a class="navbar-brand" href="#">Employee Portal</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link " href="#">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Task Manager</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="LogoutServlet">Logout</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container-fluid mt-4">
    <div class="row">
        <!-- Employee Details Section -->
        <div class="col-md-4">
            <h3>Employee Details</h3>
            <ul class="list-group">
                <li class="list-group-item"><h3>Welcome, <%= session.getAttribute("empname") %> !</h3></li>
                <li class="list-group-item">Email: <%= sessionCheck.getAttribute("email") %></li>
                <li class="list-group-item">Dept: <%= sessionCheck.getAttribute("empdept") %></li>
                <!-- Add more employee details here -->
            </ul>
        </div>
        
        <!-- Task Log Section -->
        <div class="col-md-8">
            <h3>Log Your Task</h3>
            <% if (message != null) { %>
                    <div class="alert alert-<%= messageType %>" role="alert">
                        <%= message %>
                    </div>
                <% } %>
            <form action="EmpProjUpdate" method="post">
            <div class="form-group">
                    <label for="projectName">Project ID</label>
                    <input type="text" class="form-control" id="projectName" name="projid" placeholder="Project ID" required>
                </div>
                <div class="form-group">
                    <label>Task Type</label><br>
                    <input type="text" class="form-control" id="Task done" name="taskdone" placeholder="Task done" required>
                </div>
                <div class="form-group">
                    <label for="comments">Comments</label>
                    <textarea class="form-control" id="comments" name="comments" rows="3" placeholder="Description/Comment of what you updated"  required></textarea>
                </div>
                
                <button type="submit" class="btn btn-primary" name="action" value="logout">update</button>
            </form>
        </div>
    </div>
</div>
<div class="footer">
    Powered by Surya Technologies
  </div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</body>
</html>
