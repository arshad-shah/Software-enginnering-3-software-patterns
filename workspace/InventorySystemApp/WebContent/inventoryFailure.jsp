<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>

<body>
    <c:set var="heading" value="${sessionScope.heading}" />
    <c:set var="message" value="${sessionScope.message}" />
	<h1>${heading}</h1>
	<h1>${message}</h1>
	<br/>
	<br/>	
	<a href="login.jsp">Return to Login page...</a>
</body>

</html>