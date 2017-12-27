package com.oosdclass.taskTrackerApp2.dao;

import com.oosdclass.taskTrackerApp2.model.User;

public interface UserDAO {
	public User retrieveByUserName(String username);
}
