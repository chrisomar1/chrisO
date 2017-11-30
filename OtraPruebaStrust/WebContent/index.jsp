<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Añadir el taglib para indicar que se usan tags de struts
         y se soporten en el JSP
     -->
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello World Index</title>
</head>
<body>
	<h1>Hello World From Struts2</h1>
	<form action="getHelloWorld">
		<label for="name">Please enter your name</label><br>
		<input type="text" name="name"/>
		<input type="submit"  value="Say Hello"/>
	</form>
</body>
</html>