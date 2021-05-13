


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.test.curd.model.Person"
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


<%

Person person = new Person();
person=(Person)request.getAttribute("person");

%>

<form action="save" method="POST">  

<input type="hidden" name="personid" value="<%=person.getPersonid() %>"/>  
<table>  
<tr>
<td>Name</td>
<td><input type="text" name="personname" value="<%= person.getPersonname()%>"/></td>
</tr>  
<tr>
<td>Password:</td>
<td>  
<input type="password" name="personpassword" value="<%= person.getPersonpassword()%>"/></td>
</tr> 
<tr>
<td>Department:</td>
<td><input type="text" name="persondept" value="<%= person.getPersondept()%>"/></td>
</tr>  
<tr><td>Behaviour:</td><td>  
<%= person.getPersonbehaviour()%>
<input type="radio" name="personbehaviour" value="Good"/>Good   
<input type="radio" name="personbehaviour" value="bad"/>Bad</td></tr>  
<tr><td>City:</td><td>  
<%= person.getPersoncity()%>
<select name="personcity" style="width:155px">  
<option value="Nellore">Nellore</option>  
<option value="Muthukur">Muthukur</option>  
<option value="USA">USA</option>  
<option value="Canada">Canada</option>  
<option value="Other">Other</option>  
</select>  
</td></tr>  
<tr><td colspan="2"><input type="submit" name="btn" value="UpdatePetrson"/></td></tr>  
</table>  
</form>  
</body>
</html>