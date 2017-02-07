<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.revature.pojo.UserPojo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>




<title>Manager Login</title>
</head>
<body>



<ul class="nav nav-tabs">
  <li role="presentation" class="active"><a href="viewEmployee.jsp">View All Employees</a></li>
  <li role="presentation"><a href = "addEmployee.jsp"> Add Employee</a></li>
  <li role="presentation"><a href="logout" >Logout</a></li>
</ul>
	<h1>WELCOME TO THE MANAGER HOME PAGE</h1>
	
	 
	 
	 <br>
	 <br>
	 
	 <a href = "reimbursements.jsp"> View Employee Request</a>
	<%-- 
	<h2><a href="logout" >Logout</a></h2>
	
	<a href = "addEmployee.jsp"> Add Employee </a><br>
	<a href = "viewEmployee.jsp"> View Employees </a>
	--%>
</body>
</html>