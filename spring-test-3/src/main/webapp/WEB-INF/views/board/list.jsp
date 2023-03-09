<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<p>게시글 목록</p>
<a href="${root}/board/write">글쓰기</a><br>
<table>
	<tr>
		<td>글번호</td>
		<td>글제목</td>
		<td>작성자</td>
		<td>작성일</td>
	</tr>
	<c:forEach items="${articles}" var="article" varStatus="vs">
		<tr>
			<td>${vs.count}</td>
			<td>${article.subject}</td>
			<td>${article.userId}</td>
			<td>${article.registerTime}</td>
		</tr>
	</c:forEach>
</table>