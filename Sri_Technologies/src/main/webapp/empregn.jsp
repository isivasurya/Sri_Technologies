<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
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
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h3 class="text-center">Employee Registration</h3>
                </div>
                <div class="card-body">
                    <%
                    HttpSession sessionCheck = request.getSession(false);
                    String message = (String) sessionCheck.getAttribute("message");
                    String messageType = (String) sessionCheck.getAttribute("messageType");
                    sessionCheck.removeAttribute("message");
                    sessionCheck.removeAttribute("messageType");
                    if (message != null) { %>
                        <div class="alert alert-<%= messageType %>" role="alert">
                            <%= message %>
                        </div>
                    <% } %>
                    <form action="RegisterServlet" method="post">
                        <div class="form-group">
                            <label for="empid">Employee ID</label>
                            <input type="text" class="form-control" id="empid" name="empid" placeholder="Enter your ID" required>
                        </div>
                        <div class="form-group">
                            <label for="empname">Employee Name</label>
                            <input type="text" class="form-control" id="empname" name="empname" placeholder="Enter your name" required>
                        </div>
                        <div class="form-group">
                            <label for="email">Email address</label>
                            <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
                        </div>
                        <div class="form-group">
                            <label for="contact">Contact</label>
                            <input type="text" class="form-control" id="contact" name="mobile" placeholder="Enter your Mobile No" required>
                        </div>
                        <div class="form-group">
                            <label for="dept">Department</label>
                            <input type="text" class="form-control" id="dept" name="empdept" placeholder="Enter your Department" required>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Register</button>
                    </form>
                </div>
                <div class="card-footer text-center">
                	<a href="login.jsp">Go to employee Login</a>
                	<br>
                    <a href="adminhome.jsp">Go to admin home</a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    Powered by Surya Technologies
</div>
<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
