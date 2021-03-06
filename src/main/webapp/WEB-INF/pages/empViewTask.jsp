<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Task Management</title>
</head>
<body>
<div class="container">
		<div class="row col-lg-6 col-md-offset-2 custyle">
<!-- Here is the table to display the tasks -->
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
<!-- The TaskID is hyperlinked and reroutes to the update task page -->
				<td><a href="${contextPath}/viewTask/${task.taskID}/${username}">${task.taskID}</a></td>
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