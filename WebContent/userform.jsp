<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="view">View All Records</a><br/>  
  
<h1>Add New User</h1>  
<form action="save" method="POST">  
<table>  
<tr><td>PersonName:</td><td><input type="text" name="personname"/></td></tr>  
<tr><td>Password:</td><td>  
<input type="password" name="personpassword"/></td></tr>  
<tr><td>Department:</td><td><input type="text" name="persondept"/></td></tr>  
<tr><td>Behaviour:</td><td>  
<input type="radio" name="personbehaviour" value="good"/>Good   
<input type="radio" name="personbehaviour" value="bad"/>Bad</td></tr>  
<tr><td>City:</td><td>  
<select name="personcity" style="width:155px">  
<option >Nellore</option>  
<option >Muthukur</option>  
<option>USA</option>  
<option>Canada</option>  
<option>Other</option>  
</select>  
</td></tr>  
<tr><td colspan="2"><input type="submit" name="btn" value="AddPerson"/></td></tr>  
</table>  
</form>  
</body>
</html>