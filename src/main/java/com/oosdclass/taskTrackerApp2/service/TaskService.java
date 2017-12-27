package com.oosdclass.taskTrackerApp2.service;

import java.util.List;
import com.oosdclass.taskTrackerApp2.model.Task;

public interface TaskService {

	public List<Task> getAllTasks();

	public void saveTask(Task task);
}
