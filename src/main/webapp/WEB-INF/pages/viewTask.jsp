Skip to content This repository Search Pull requests Issues Marketplace
Explore @Stephonsr Sign out Watch 0 Star 0 Fork 8
LisaKC/taskTrackerAppForNoveClass forked from
ramoosdclass/taskTrackerAppForNoveClass Code Pull requests 0 Projects 0
Wiki Insights Branch: master Find file Copy
pathtaskTrackerAppForNoveClass/src/main/webapp/WEB-INF/pages/viewTask.jsp
74215c0 20 minutes ago lisaciaccio Laptop dying, no charger, here's my
progress 0 contributors RawBlameHistory 55 lines (52 sloc) 2.19 KB
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- link html to bootstrap stylesheet -->
<link href="${contextPath}/resources/dist/css/bootstrap.css"
	rel="stylesheet">
<title>Update Task</title>
</head>
<body>
	<div class="container">
		<div class="row col-lg-6 col-md-offset-2 custyle">

			<!-- this is the table that displays the info about the specific task -->
			<table class="table table-striped custab">
				<thead>
					<tr>
						<th>Task ID</th>
						<th>Task Description</th>
						<th>Status</th>
						<th>Assigned To</th>
					</tr>
				</thead>
				<tr>
					<td>${task.taskID}</td>
					<td>${task.description}</td>
					<td>${task.status}</td>
					<td>${task.assignedTo}</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="container">
		<div class="row col-lg-6 col-md-offset-2">

			<!-- these are buttons that will update the parameters of the specific task displayed -->
			<!-- c:if is a .jsp condition to check something in order to run this section of code -->
			<!-- we use a condition for each button, so it won't display under certain circumstances -->
			<c:if test="${task.assignedTo == 'UNASSIGNED'}">
				<a
					href="${contextPath}/updateTask/ASSIGN/${task.taskID}/${username}"
					class="btn btn-primary btn-block"> <i
					class="glyphicon glyphicon-user"></i><strong>Assign To Me</strong></a>
			</c:if>
			<!-- OK HERE IS WHERE MY PROGRESS ENDS, I'VE GOT TO PICK IT UP AND FINISH THE CONDITIONAL BUTTONS LATER -->
			<a
				href="${contextPath}/updateTask/IN-PROGRESS/${task.taskID}/${username}"
				class="btn btn-warning btn-block"> <i
				class="glyphicon glyphicon-edit"></i> <strong>IN PROGRESS</strong></a> <a
				href="${contextPath}/updateTask/COMPLETED/${task.taskID}/${username}"
				class="btn btn-success btn-block"> <i
				class="glyphicon glyphicon-ok"></i> <strong>COMPLETED</strong></a>

		</div>
	</div>
</body>
</html>
