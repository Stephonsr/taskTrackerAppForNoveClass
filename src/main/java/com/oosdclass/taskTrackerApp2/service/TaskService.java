package com.oosdclass.taskTrackerApp2.service;

import java.util.List;
import com.oosdclass.taskTrackerApp2.model.Task;

public interface TaskService {

	//Display all the tasks in a table 
		List<Task> getAllTask();
		//Create a new task (admin)
		public void saveTask(Task task);
		//To display just one task in the table - used for employees' update task
		Task getByTaskId(int taskID);
		//These are the methods to update the task (using the buttons)
		//the controller and service have two separate methods for updating task: specific to STATUS and ASSIGNEDTO
		//both these methods will invoke ONLY ONE method in the DAO: TaskDAO.UpdateTask
		public void updateTaskStatus(int taskID, String status, String username);
		public void updateTaskAssignedTo(int taskID, String username);
	}
