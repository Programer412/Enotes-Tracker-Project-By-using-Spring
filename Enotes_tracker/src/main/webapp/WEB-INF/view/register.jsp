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
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-header text-center">
<h1>Register Page</h1>

<c:if test="${not empty msg}">
<p class="fs-3 fw-bold text-success">${msg }</p>

<c:remove var="msg"/>
</c:if>
</div>
<div class="card-body">
<form action="registerUser" method="post">
<div class="mb-3">

<label>Enter Full Name</label>
<input type="text" name="fullname" class="form-control">
</div>

<div class="mb-3">

<label>Enter Qualification</label>
<input type="text" name="qualification" class="form-control">
</div>


<div class="mb-3">

<label>Enter Email</label>
<input type="text" name="email" class="form-control">
</div>

<div class="mb-3">

<label>Enter Password</label>
<input type="password" name="password" class="form-control">
</div>
<button class="btn btn-primary col-md-12" value="submit">Register</button>
</form>

</div>
</div>

</div>
</div>
</div>

</body>
</html>