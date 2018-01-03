package com.oosdclass.taskTrackerApp2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oosdclass.taskTrackerApp2.model.Task;
import com.oosdclass.taskTrackerApp2.service.TaskService;


//Spring Framework: Controller
@Controller
public class TaskController {
	// DI/IOC: Autowire the UI to the Service layer
	@Autowired
	TaskService taskService;

	@RequestMapping(value = "/adminTasks")
	public ModelAndView viewTasks(ModelAndView model) {

		// map list of tasks to table in view page
		List<Task> taskList = taskService.getAllTask();
		model.addObject(taskList);
		model.setViewName("viewTask");
		return model;

	}

	// GET: show the task view page - for EMPLOYEES
	@RequestMapping(value = "/empTasks/{username}")
	public ModelAndView viewEmpTasks(ModelAndView model, @PathVariable String username) {
		// map list of tasks to table in view page
		List<Task> taskList = taskService.getAllTask();
		model.addObject(taskList);
		model.addObject(username);
		model.setViewName("empTask");
		return model;
	}

	// Get: show the admin only"create task" from
	@RequestMapping(value = "/createTaskForm")
	public ModelAndView createTaskForm(ModelAndView model) {
		// map create task from in the view page
		Task task = new Task();
		model.addObject(task);
		model.setViewName("createTask");
		return model;
	}

	// POST: post the newly created task to do the DAO, and the display the updayed
	// table in the "view task" page
	@RequestMapping(value = "/createTask", method = RequestMethod.POST)
	public ModelAndView createTask(Task task) {
		ModelAndView model = null;
		taskService.saveTask(task);
		model = new ModelAndView("redirect:/adminTasks");
		return model;
	}

	// GET: show the employee-only "update task" form
	@RequestMapping(value = "/viewTask/{taskID}/{username}")
	public ModelAndView viewTask(ModelAndView model, @PathVariable int taskID, @PathVariable String username) {
		Task task = taskService.getByTaskId(taskID);
		model.addObject(task);
		model.addObject(username);
		model.setViewName("viewTask");
		return model;
	}

	// From View Task page: Button: ASSIGN TO ME - reroute to empTasks
	@RequestMapping(value = "/updateTask/{status}/{taskID}/{username}", method = RequestMethod.GET)
	// use @PathVariable to pull variables from URL/use them as values for updated
	// attributes
	public ModelAndView updateStatus(@PathVariable int taskID, @PathVariable String status,
			@PathVariable String username) {
		ModelAndView model = null;
		taskService.updateTaskStatus(taskID, status, username);
		model = new ModelAndView("redirect:/empTasks/{username}");
		return model;
	}

	// From View Task page: Button: UPDATE STATUS: In Progress or Completed -
	// reroute to empTasks
	@RequestMapping(value="/updateTask/ASSIGN/{taskID}/{username}", method = RequestMethod.GET)
		//use @PathVariable to pull variables from URL/use them as values for updated attributes
		public ModelAndView updateAssignedTo(@PathVariable int taskID, @PathVariable String username) {
			ModelAndView model=null;
			taskService.updateTaskAssignedTo(taskID, username);
			model = new ModelAndView("redirect:/empTasks/{username}");
			return model;









	}

}
