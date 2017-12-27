package com.oosdclass.taskTrackerApp2.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oosdclass.taskTrackerApp2.model.Task;
import com.oosdclass.taskTrackerApp2.service.TaskService;
@Controller
public class TaskController {
	
	@Autowired
	 	TaskService taskService;
	 	
	 	
	 	@RequestMapping(value="/adminTasks")
	 	public ModelAndView viewTasks(ModelAndView model) {
	 		
	 		//map list of tasks to table in view page
	 		List<Task> taskList = taskService.getAllTasks();
	 		model.addObject(taskList);
	 		model.setViewName("viewTask");
	 		return model;
	 		
	 	}
	 	//Get: show the admin only"create task" from
	 	@RequestMapping(value="/createTaskForm")
	 	public ModelAndView createTaskForm(ModelAndView model) {
	 		//map create task from in the view page 
	 		Task task = new Task();
	 		model.addObject(task);
	 		model.setViewName("createTask");
	 		return model;
	 	}
	 	
	 	//POST: post the newly created task to do the DAO, and the display the updayed table in the "view task" page
	 	@RequestMapping(value="/createTask", method= RequestMethod.POST)
	 	public ModelAndView createTask(Task task) {
			ModelAndView model=null;
			taskService.saveTask(task); 
			model = new ModelAndView("redirect:/adminTasks");
			return model;
	 	}
}
	 	
	 	
	 	
	 	
	 	
	 	
	 