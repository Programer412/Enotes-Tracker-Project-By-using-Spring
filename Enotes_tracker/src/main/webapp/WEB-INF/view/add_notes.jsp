<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page isELIgnored="false"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/resources/component/all_link.jsp" %>
</head>
<body style="background:color:#f0f0f0;">
<%@include file="/WEB-INF/resources/component/navbar.jsp" %>
<div class="container mt-3">
<div class="row">
<div class="col-md-10 offset-md-1">
<div class="card">
<div class="card-header text-center">
<h4>Add your Notes</h4>
<c:if test="${not empty msg}">
<p class="fs-3 fw-bold text-success">${msg }</p>

<c:remove var="msg"/>
</c:if>

</div>
<div class="card-body">
<form action="saveNotes" method="post">
<div class="mb-3">

<label>Enter Title</label>
<input type="text" name="title" class="form-control">
</div>

<div class="mb-3">

<label>Enter Description</label>

<textarea rows="6" cols="" class="form-control" name="description"></textarea>
</div>
<button class="btn btn-primary">Save</button>

</form>

</div>
</div>

</div>
</div>
</div>

</body>
</html>