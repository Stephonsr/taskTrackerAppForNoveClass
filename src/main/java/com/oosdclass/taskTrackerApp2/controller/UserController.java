package com.oosdclass.taskTrackerApp2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oosdclass.taskTrackerApp2.model.User;
import com.oosdclass.taskTrackerApp2.service.UserService;

@Controller
public class UserController {
	
	
	//DI/IOC: Autowire the service layer to the UI layer
	@Autowired
	UserService userService;

	// (/) method (GET) is the FIRST method that is called when the user accesses
		// our app using
		// the root context and display's the home page, which is nothing but "login"
		//when the user accessses the login page we are initializing User object for the user to fill in
		@RequestMapping(value = "/")
		public ModelAndView login(ModelAndView model) {
				User user = new User();
				//by adding object we are informing 
				//spring mvc to initialize user object on the login page
				model.addObject(user);
				//by setting viewname to home spring mvc displays 
				//the jsp that is named home
				model.setViewName("home");
				return model;
			}
		
			//(/login) method (POST) is mapped to /login URL where user post/submits the
			// form which is mapped to user object and we pass to service
			@RequestMapping(value = "/login", method = RequestMethod.POST)
			public ModelAndView login(User userLoginFormObject) {
				ModelAndView model = null;
				//if user is a valid user then display view Task page
				if(userService.isUserValid(userLoginFormObject)) {
					model = new ModelAndView("viewTask");
					model.addObject("error", "Username does not exist");
					//Second Check: Is the password correct?
					} else if(!userService.isUserValid(userLoginFormObject)) {
						model = new ModelAndView("home");
						model.addObject("error", "User input is not valid");
					//Third Check: Is the user an admin?
					} else if(userService.isUserAdmin(userLoginFormObject)){
						model = new ModelAndView("redirect:/adminTasks");
					//Passed all the checks, send to employee task page
					} else {
						model = new ModelAndView("redirect:/empTasks/" + userLoginFormObject.getUsername());
					}
					//And then, depending on which conditions were met, display that specified model
					return model;
			}
			

	}
	