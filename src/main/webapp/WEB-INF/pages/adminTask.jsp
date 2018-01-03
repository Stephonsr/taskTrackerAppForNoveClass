<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<!--This is button that goes to create task screen -->
		<div class="row col-lg-6 col-md-offset-2 custyle">
		<a href="${contextPath}/createTaskForm"
						class="btn btn-primary btn-xs pull-right"><b>+</b> Add a new
						task</a>
<!-- The table to display list of tasks -->
			<table class="table table-striped custab">		
				<thead>
					<tr>
						<th>Task ID</th>
						<th>Task Description</th>
						<th>Status</th>
						<th>Assigned To</th>
					</tr>
				</thead>
<!-- This is where we are rendering from the array task and displaying on table with help of spring framework -->
				<c:forEach var="task" items="${taskList}">
				<tr>
<!-- note that the taskID is NOT hyperlinked for admin -->
				<td>${task.taskID}</td>
				<td>${task.description}</td>
				<td>${task.status}</td>
				<td>${task.assignedTo}</td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>