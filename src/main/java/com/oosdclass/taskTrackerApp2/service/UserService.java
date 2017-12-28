package com.oosdclass.taskTrackerApp2.service;

import com.oosdclass.taskTrackerApp2.model.User;
public interface UserService {
	public boolean isUserValid(User user);
	public boolean doesUserExist(User user);
	public boolean isUserAdmin(User user);
}
