<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="com.revature.userDao.DaoFunctions.*,java.util.*" %>
<%@ page import = "com.revature.userDao.DaoFunctions" %>
<%@ page import = "com.revature.pojo.UserPojo" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>




</head>
<body>
<%--UserPojo u = daoUser.getEmployeeById(Integer.parseInt(u.getU_id()));      
UserPojo u = daoUser.getEmployeeById(getU_id());  
 --%>
<%--	
<%
	DaoFunctions daoUser = new DaoFunctions();
	String id = request.getParameter("id");
	 UserPojo u = daoUser.getEmployeeById(Integer.parseInt(id));
	 out.print(id);
%>	
--%>
 
 <%-- 
 <%
	 UserPojo u;
 	String id = " ";
	 DaoFunctions daoUser = new DaoFunctions();
 	if(request.getParameter("id")!=null)
 	{
 		id = request.getParameter("id");
 		u = daoUser.getEmployeeById(Integer.parseInt(id));
 	}
 	if(id.trim().length()==0)
 	{%>
 		<div>Empty Field</div>
 	<%}
 	else{%>
 		<div><span><%=id %>> </span>> </div>
 	 <%}%>
 --%>

 

<h1>Edit Employee Form</h1>
<form action = "EditEmployee" method = "post">
	<input type = "hidden" name = "id" value = "${user.getU_id()}" />  
	   
	<table>
		<tr> <td>USERNAME:</td> <td>
		<input type = "text" name = "username" value = "${user.getU_userName()}" /> </td> </tr>
		<tr> <td>PASSWORD:</td> <td>
		<input type = "password" name = "password" value = "${user.getU_password()}" /> </td> </tr>
		<tr> <td>FIRSTNAME:</td> <td>
		<input type = "text" name = "firstname" value = "${user.getU_firstName()}" /> </td> </tr>
		
		<tr> <td>LASTNAME:</td> <td>
		<input type = "text" name = "lastname" value = "${user.getU_lastName()}" /> </td> </tr>
		<tr> <td>EMAIL:</td> <td>
		<input type = "text" name = "email" value = "${user.getU_email()}" /> </td> </tr>
		
		<tr><td>UR_ID:</td> <td>
		<select name = "ur_id" >
		<option> 2</option>
		</select>
		</td> </tr>
		
		<tr> <td colspan = "2"> <input type = "submit" value = "Submit Changes"/> </td> </tr> 
		
		

	</table>

</form>




 

<%-- 
 <form  action = "EditEmployee"  method="post" class="form-horizontal"  name="EditEmployee" id="signup" enctype="multipart/form-data" >
<div class="container">
	<div class="row">
    <div class="col-md-8">
           
        <h1 class="entry-title"><span>Sign Up</span> </h1>
        <hr>
           <!--   <form class="form-horizontal"  method="post" name="signup" id="signup" enctype="multipart/form-data" > -->   
              
            <input type = "hidden" name = "id" value = "${user.getU_id()}" />    
      
      
        
         <div class="form-group">
          <label class="control-label col-sm-3">User Name <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
            <input type="text" class="form-control" name="username" id="mem_name" placeholder="Enter your User Name here" value="${user.getU_userName()}"/>
          </div>
        </div>
        
        
        
        <div class="form-group">
          <label class="control-label col-sm-3"> Password <span class="text-danger">*</span></label>
          <div class="col-md-5 col-sm-8">
            <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
              <input type="password" class="form-control" name="password" id="cpassword" placeholder="Confirm your password" value="${user.getU_password()}"/>
            </div>  
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-3">First Name <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
            <input type="text" class="form-control" name="firstname" id="mem_name" placeholder="Enter your First Name here" value="${user.getU_firstName()}"/>
          </div>
        </div>
        
        
        <div class="form-group">
          <label class="control-label col-sm-3">Last Name <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
            <input type="text" class="form-control" name="lastname" id="mem_name" placeholder="Enter your Last Name here" value="${user.getU_lastName()}"/>
          </div>
        </div>
        
     
        
          <div class="form-group">
          <label class="control-label col-sm-3">Email <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
              <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
              <input type="email" class="form-control" name="email" id="emailid" placeholder="Enter your Email" value="${user.getU_email()}"/>
            </div>
            <small> Your Email Id is being used for ensuring the security of your account, authorization and access recovery. </small> </div>
        </div>
        
        <h5>Employee UR_ID</h5>
        <select name = "ur_id" >
		<option> 2</option>
		</select>
		<br>
		<br>
        
        <div class="form-group">
          <label class="control-label col-sm-3">Profile Photo <br>
          <small>(optional)</small></label>
          <div class="col-md-5 col-sm-8">
            <div class="input-group"> <span class="input-group-addon" id="file_upload"><i class="glyphicon glyphicon-upload"></i></span>
              <input type="file" name="file_nm" id="file_nm" class="form-control upload" placeholder="" aria-describedby="file_upload">
            </div>
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-3">Security Code If You Have Received One </label>
          <div class="col-md-5 col-sm-8">
            <div >
                
                <input type="text" name="captcha" id="captcha" class="form-control label-warning"  />                
              </div>
          </div>
        </div>
        
            <input name="Submit" type="submit" value="Submit Changes" class="btn btn-primary">
          </div>
        </div>
      
    </div>
 </form>
--%>



















</body>
</html>