<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<form action="${root}/board/write" method="POST">
	<label>닉네임</label>
	<input type="text" name="userId"><br>
	<label>비밀번호</label>
	<input type="text" name="userPwd"><br>
	<label>글제목</label>
	<input type="text" name="subject"><br>
	<label>내용</label>
	<textarea rows="10" cols="50" name="content"></textarea><br>
	<input type="submit">
</form>