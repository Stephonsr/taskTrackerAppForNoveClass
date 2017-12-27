package com.oosdclass.taskTrackerApp2.model;

public class Task {
	private int taskID;
	private String taskdescription;
	private String assignedTo;
	private String status;
	
	
	public int getTaskID() {
		return taskID;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}
	public String getTaskDescription() {
		return taskdescription;
	}
	public void setTaskDescription(String description) {
		this.taskdescription = description;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}