package com.oosdclass.taskTrackerApp2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oosdclass.taskTrackerApp2.dao.TaskDAO;
import com.oosdclass.taskTrackerApp2.model.Task;
import com.oosdclass.taskTrackerApp2.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskDAO taskdao;

	@Override
	public List<Task> getAllTasks() {
		return taskdao.retrieveAllTasks();
	}

	// to be replaced by whatever the service layer creates

	@Override
	public void saveTask(Task task) {
		task.setStatus("OPEN");
		task.setAssignedTo("UNASSIGNED");
		taskdao.saveTask(task);
	}

}