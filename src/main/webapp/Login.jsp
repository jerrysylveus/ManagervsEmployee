<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

 <link rel="stylesheet" href="resources/style.css" type="text/css">
 
<title>Insert title here</title>

	
   

</head>
<body>
	
	
	<!--  	String msg = request.getAttribute("error");
	   if(msg != null){
		out.println("<font color=red size=4px>"+msg+"</font>");-->

<!--  
	
	<div class = "container">
	<div class="wrapper">
		<form action="Login" method="post" name="Login_Form" class="form-signin">       
		    <h3 class="form-signin-heading">Welcome Back! Please Sign In</h3>
			  <hr class="colorgraph"><br>
			  
			  <input type="text" class="form-control" name="username" placeholder="username" required="" autofocus="" />
			  <input type="password" class="form-control" name="password" placeholder="password" required=""/>     		  
			 
			  <button class="btn btn-lg btn-primary btn-block"  name="Submit" value="Login" type="Submit">Login</button>  			
		</form>			
	</div>
</div>


-->
<%-- 
<form action="Login" enctype="multipart/form-data" method="post">
	<input type="file" multiple=""/>
	<input type="submit" value="Upload Receipt" />
</form>
--%> 

<form action="Login" method="post" name="Login_Form" class="form-signin">  
<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
       
          <h1 class="text-center">Welcome</h1>
        </div>
         <div class="modal-body">
             <div class="form-group">
                 <input type="text" class="form-control input-lg" name = "username" placeholder="username"/>
             </div>

             <div class="form-group">
                 <input type="password" class="form-control input-lg" name = "password" placeholder="password"/>
             </div>

             <div class="form-group">
                 <input type="submit" class="btn btn-block btn-lg btn-primary" value="Login"/>
                 
             </div>
         
         </div>
    </div>
 </div>

   </form>










</body>
</html>