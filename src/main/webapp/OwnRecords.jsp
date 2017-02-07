<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.revature.userDao.DaoFunctions.*,java.util.*" %>
<%@ page import = "com.revature.userDao.DaoFunctions" %>
<%@ page import = "com.revature.pojo.UserPojo" %>
<%@ page import = "com.revature.pojo.ReimbursementPojo" %>

<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br>


<table border = "1" width = "90%">
	<tr> 
		<th>ID</th>
		<th> USERNAME</th>
		<th> PASSWORD</th>
		<th> FIRSTNAME</th>
		<th> LASTNAME </th>
		<th> E_MAIL</th>
		<th> UR_ID </th>
		<th> </th>
	
		</tr>

	
		<tr>
			<td>${user.getU_id()} </td>
			<td>${user.getU_userName()}</td>
			<td>${user.getU_password()}</td>
			<td>${user.getU_firstName()}</td>
			<td>${user.getU_lastName()}</td>
			<td>${user.getU_email()}</td>
			<td>${user.getUserRolesId()}</td>
			<td> <a href = "editForm.jsp?u_id =${user.getU_id()}">Edit</a></td>
		</tr>
	
	
	
</table>
<br>
<%--<input type="file" multiple=""/> --%>

<a href = "employeeLogin.jsp"> Back to Homepage </a> 
<br>
<br>


  



<form action="uploadFile" enctype="multipart/form-data"  method="POST">
	
	<input type = "file" name = "file" size = "50" />
	
	<br>
	
	Amount: <input type="text"  name = "amt" /> <br>
	Description: <input type="text"  name = "description" /> <br>
	rtType: <input type="text"  name = "rtype" /> <br>
	
	<br>
	
	<input type="submit" value="Upload Receipt" /> 

</form>


<br>
<br>
	<%-- 
	<form action = "outstandingRequest" method = "post" >
	<input type = "submit" value = "View Outstanding Request" />
	</form>
	--%>

	<a href = "outstandingRequest.jsp"> View Request</a>
	<br>
	<br>
	
	<a href = "upload.jsp"> Pic Upload</a>

</body>
</html>