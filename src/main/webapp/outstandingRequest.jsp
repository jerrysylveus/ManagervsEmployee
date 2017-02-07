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

<%-- 
DaoFunctions daoUser = new DaoFunctions();
List<UserPojo> list = daoUser.getEmployeeRecords();
request.setAttribute("list", list);

List<ReimbursementPojo> list = daoUser.getOutstandingReimbursements(user.getU_id());
UserPojo user = null
UserPojo user = new UserPojo();
--%>


<%

UserPojo user = (UserPojo)session.getAttribute("user");

ReimbursementPojo r = new ReimbursementPojo();
DaoFunctions daoUser = new DaoFunctions();
List<ReimbursementPojo> list = daoUser.getOutstandingReimbursements(user.getU_id());
request.setAttribute("list", list);

%>



<%-- 
<%
ReimbursementPojo r = new ReimbursementPojo();
DaoFunctions daoUser = new DaoFunctions();
List<ReimbursementPojo> list = daoUser.getOutstandingReimbursements(r.getU_idAuthor());
request.setAttribute("list", list);
%>
--%>

<table border = "1" width = "90%">
	<tr> 
		<th>AMOUNT</th>
		<th> DESCRIPTION</th>
		<th> RECEIPT</th>
		<th> AUTHOR ID</th>
		<th> TYPE ID</th>
		<th> SUBMITTED</th>
		
	
		</tr>

	<%--s
		<tr>
			<td>${r.getrAmount()} </td>
			<td>${r.getRDescription()}</td>
			<td>${r.getrReceipt()}</td>
			<td>${r.getrSubmitted()}</td>
			<td>${r.getU_idAuthor()}</td>
			<td>${r.getRtType()}</td>
			<td> <a href = "editForm.jsp?u_id =${user.getU_id()}">Edit</a></td>
		</tr>
	--%>
	
	
	<c:forEach items = "${list}" var = "user">
		<tr>
			
			<td>${user.getrAmount()}  </td>
			<td>${user.getrDescription()} </td>
			<td>${user.getrReceipt()} </td>
			<td>${user.getU_idAuthor()} </td>
			<td>${user.getRtType()} </td>
			
		</tr>
	</c:forEach>
	
	
</table>



</body>
</html>