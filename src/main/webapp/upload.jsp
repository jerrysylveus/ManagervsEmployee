<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




<center>
        <h1>File Upload to Database Demo</h1>
        <form method="post" action="uploadServlet" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Amount: </td>
                    <td><input type="number" amount="amount" size="50"/></td>
                </tr>
                <tr>
                    <td>Last Description: </td>
                    <td><input type="text" name="description" size="50"/></td>
                </tr>
                <tr>
                    <td>Receipt: </td>
                    <td><input type="file" name="photo" size="50"/></td>
                </tr>
                
                 <tr>
                    <td>Author ID: </td>
                    <td><input type="number" name="authorId" size="50"/></td>
                </tr>
                
                 <tr>
                    <td>Type ID: </td>
                    <td><input type="number" name="typeId" size="50"/></td>
                </tr>
                
                 <tr>
                    <td>Time Submitted: </td>
                    <td><input type="datetime-local" name="timeSubmitted" size="50"/></td>
                </tr>
                
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
    </center>




</body>
</html>