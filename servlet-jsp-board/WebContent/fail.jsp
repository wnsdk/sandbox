<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실패</title>
</head>
<body>
<h3><%= request.getAttribute("msg") %></h3>
<a href='<%=request.getAttribute("url")%>'><%=request.getAttribute("title")%></a>
</body>
</html>