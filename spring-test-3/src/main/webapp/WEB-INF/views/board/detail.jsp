<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<input type="hidden" id="articleNo" value="${article.articleNo}">
<table>
	<tr>
		<td>작성자</td>
		<td>${article.userId}</td>
	</tr>
	<tr>
		<td>제목</td>
		<td>${article.subject}</td>
	</tr>
	<tr>
		<td>작성일</td>
		<td>${article.registerTime}</td>
	</tr>
	<tr>
		<td>글내용</td>
		<td>${article.content}</td>
	</tr>
</table>

<table id="commentList">
</table>

<!-- <form action="">
	<input type="text" name="userId">
	<input type="text" name="comment">
	<input type="button" onclick="makeComment();">
</form> -->

<script>
	let root = "/spring";
	let articleNo = document.getElementById("articleNo").value;
	
	fetch(`${root}/board/comment/${articleNo}`)
	  .then((response) => response.json())
	  .then((data) => makeList(data));
	
	function makeList(comments) {
		let commentList = ``;
		comments.forEach(function(data) {
			console.log(data);
			console.log(data.userId);
			console.log(`${data.userId}`);
			console.log(`${articleNo}`);
			commentList += `
				<tr>
					<td>` + data.commentNo + `</td>
					<td>` + data.userId + `</td>
					<td>` + data.comment + `</td>
					<td>` + data.commentTime + `</td>
				</tr>
			`;
		});

		document.getElementById("commentList").innerHTML = commentList;
		console.log(commentList);
	}
	
	/* function makeComment() {
		fetch(`${root}/board/comment/${articleNo}`)
		  .then((response) => response.json())
		  .then((data) => makeList(data));
	} */
</script>