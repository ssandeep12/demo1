<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*,com.test.curd.model.*,com.test.curd.dao.DaoPerson"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Users</title>
</head>
<body>

<form action="#" method="post">
	<h1>Persons List</h1>
	<table border='1' width='100%'>
		<thead>

			<tr>
				<th>personid</th>
				<th>personname</th>
				<th>personpassword</th>
				<th>persondept</th>
				<th>personbehaviour</th>
				<th>personcity</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

		</thead>

		<%
			List<Person> list = (List) request.getAttribute("list");

			for (Person p : list) {
		%>

		<tbody>

			<tr>
				<td><%=p.getPersonid()%></td>
				<td><%=p.getPersonname()%></td>
				<td><%=p.getPersonpassword()%></td>
				<td><%=p.getPersondept()%></td>
				<td><%=p.getPersonbehaviour()%></td>
				<td><%=p.getPersoncity()%></td>
				
				
				
				<td><a href="EditServlet?personid=<%=p.getPersonid()%>">edit</a></td>
				<td><a href="DeleteServlet?personid=<%=p.getPersonid()%>">delete</a></td>
			</tr>



		</tbody>
		<%
			}
		%>




	</table>
	
	<a href="userform.jsp">Add Person</a>
	

</form>
</body>
</html>