package com.oosdclass.taskTrackerApp2.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oosdclass.taskTrackerApp2.dao.UserDAO;
 import com.oosdclass.taskTrackerApp2.model.User;
 import com.oosdclass.taskTrackerApp2.service.UserService;
 
 @Service
 public class UserServiceImpl implements UserService {

 	@Autowired
 	UserDAO userDAO;

 	
 	@Override
 	public boolean isUserValid(User user) {
 		
 		User userFromDb = userDAO.retrieveByUserName(user.getUsername()); 
 		
 		//if no user with username exists in the DB return false
 		if (userFromDb == null) {
 			 			return false;
 			 		}
 			 
 			 		// if username/password typed in by user matches username/password from db
 			 		// return true
 			 		if (user.getUsername().equals(userFromDb.getUsername())
 			 				&& user.getPassword().equals(userFromDb.getPassword())) {
 			 			return true;
 			 		} else {
 			 			return false;
 			 		}
 	}
}