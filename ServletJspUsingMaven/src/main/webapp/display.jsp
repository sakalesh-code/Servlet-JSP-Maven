<%@ page import="com.learn.model.TechDetails" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Page</title>
</head>
<body>
 <%
 TechDetails a1 =(TechDetails) request.getAttribute( "techDetails");
 out.println(a1);
 %>
</body>
</html>
