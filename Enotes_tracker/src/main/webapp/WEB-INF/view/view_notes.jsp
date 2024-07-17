<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/WEB-INF/resources/component/all_link.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/resources/component/navbar.jsp"%>
	<div class="container-fluid p-4">
		<h4 class="text-center">View All Notes</h4>
		<c:if test="${not empty msg}">
<p class="fs-2 fw-bold text-center text-success">${msg }</p>

<c:remove var="msg"/>
</c:if>
		<div class="row">
		<c:forEach items="${list}" var="n">
			<div class="col-md-10 offset-md-1">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<img alt="" src="<c:url value="/resources/img/note.jpg"/>"
								width="50px" height="50px">
						</div>
						<p>${n.title}</p>
						<p>${n.description}</p>
						<p>Publish Date ${n.date}</p>
						<div class="text-center">
							<a href="editNotes?id=${n.id}" class="btn btn-primary btn-sm">Edit</a> <a
								href="deleteNotes?id=${n.id}" class="btn btn-danger btn-sm">Delete</a>
						</div>
					</div>

				</div>
			</div>
			</c:forEach>
<%-- 
			<div class="col-md-10 offset-md-1 mt-2">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<img alt="" src="<c:url value="/resources/img/note.jpg"/>"
								width="50px" height="50px">
						</div>
						<p>What is Java?</p>
						<p>Java is programming Language</p>
						<p>Publish Date : 2023-05-08</p>
						<div class="text-center">
							<a href="editNotes" class="btn btn-primary btn-sm">Edit</a> <a
								href="editNotes" class="btn btn-danger btn-sm">Delete</a>
						</div>
					</div>

				</div>
			</div> --%>
		</div>
	</div>
</body>
</html>