<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.revature.userDao.DaoFunctions.*,java.util.*" %>
<%@ page import = "com.revature.userDao.DaoFunctions" %>
<%@ page import = "com.revature.pojo.UserPojo" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View All Employees</title>
</head>
<body>
<h1> Employees List</h1>
<%--List<UserPojo> list = daoUser.getEmployeeRecords(); --%>
<%--request.getRequestDispatcher("viewEmployee.jsp").forward(request, response);--%>
<%
UserPojo user = null;

DaoFunctions daoUser = new DaoFunctions();
List<UserPojo> list = daoUser.getEmployeeRecords();
request.setAttribute("list", list);

%>


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

	
	<c:forEach items = "${list}" var = "user">
		<tr>
			<td><c:out value = "${user.getU_id()}"/> </td>
			<td>${user.getU_userName()}  </td>
			<td>${user.getU_password()} </td>
			<td>${user.getU_firstName()} </td>
			<td>${user.getU_lastName()} </td>
			<td>${user.getU_email()} </td>
			<td>${user.getUserRolesId()} </td>
		</tr>
	</c:forEach>
	
	
</table>

<br>
<a href = "managerLogin.jsp"> HomePage </a>
</body>
</html>

