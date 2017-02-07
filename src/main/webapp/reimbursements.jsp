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


<%


UserPojo user = (UserPojo)session.getAttribute("user");

ReimbursementPojo r = new ReimbursementPojo();
DaoFunctions daoUser = new DaoFunctions();
List<ReimbursementPojo> list = daoUser.unprocessedReimbursements();
request.setAttribute("list", list);

%>



<table border = "1" width = "90%">
	<tr> 
		<th>R_ID</th>
		<th> AMOUNT</th>
		<th> DESCRIPTION</th>
		<th> RECEIPT</th>
		<th> SUBMITTED </th>
		<th> RESOLVED</th>
		<th> AUTHOR ID </th>
		<th> RESOLVER ID</th>
		<th>TYPE </th>
		<th>STATUS </th>
	
		</tr>





	
		<c:forEach items = "${list}" var = "user">
		<tr>
			<td>${user.getrId()}  </td>
			<td>${user.getrAmount()}  </td>
			<td>${user.getrDescription()} </td>
			<td>${user.getrReceipt()} </td>
			<td>${user.getrSubmitted()} </td>
			<td>${user.getrResolved()} </td>
			
			<td>${user.getU_idAuthor()} </td>
			<td>${user.getU_idResolver()} </td>
			<td>${user.getRtType()} </td>
			<td>${user.getRtStatus()} </td>
			
			
		</tr>
	</c:forEach>
	
	
	
</table>


</body>
</html>