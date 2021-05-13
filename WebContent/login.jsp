<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>login</title>
<script type="text/javascript">
function validateform(){
	var name= document.myform.personname.value;
	var password= document.myform.personpassword.value;
	alert("PersonName>>>>>  "+name+"     password>>>>>>   "+password);
	if(name==null || name=="") {
		alert("Personname is not valid");
		return false;
	}else if (password.length<6) {
		alert("password is too weak");
		return false;			
	}
}
</script>
</head>
<body>
<form name="myform" action="login" method="post" onsubmit="validateform()">

PersonName:<input type="text"
 name="personname"><br><br>

Password:<input type="password" name="personpassword"><br><br>
<input type="submit" value="login">
</form>
</body>
</html>