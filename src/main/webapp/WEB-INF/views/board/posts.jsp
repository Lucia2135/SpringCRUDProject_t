<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" pageEncoding="UTF-8" %>
<%@page import="com.crud.common.BoardDAO, com.crud.common.BoardVO,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>OurPlaylist</title>
<style>
body{
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  padding-top: 5px;
	padding-left: 10px;
  padding-bottom: 10px;
  text-align: left;
  background-color: white;
  color: #1f1f1f;
}

</style>
<script>
	function delete_ok(id){
		var a = confirm("정말로 삭제하겠습니까?");
		if(a) location.href='delete/' + id;
	}
</script>
</head>
<body>
<h1>OurPlaylist</h1>
<h4>공유 플레이리스트</h4>

<table id="posts" width="100%";>
<tr>
	<th>Id</th>
	<th>Title</th>
	<th>Singer</th>
	<th>Genre</th>
	<th>Writer</th>
	<th>Composer</th>
	<th>Release Date</th>
	<th>Label</th>
	<th>Add Date</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>
<c:forEach items="${posts}" var="u">
	<tr>
		<td>${u.seq}</td>
		<td>${u.title}</td>
		<td>${u.singer}</td>
		<td>${u.genre}</td>
		<td>${u.writer}</td>
		<td>${u.composer}</td>
		<td>${u.releaseD}</td>
		<td>${u.label}</td>
		<td>${u.addD}</td>
		<td><a href="editform/${u.seq}">Edit</a></td>
		<td><a href="javascript:delete_ok('${u.seq}')">Delete</a></td>
	</tr>
</c:forEach>
</table>
<br/><button type="button" onclick="location.href='add'"> Add New Post</button>
</body>
</html>