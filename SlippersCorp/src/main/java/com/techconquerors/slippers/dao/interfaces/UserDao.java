package com.techconquerors.slippers.dao.interfaces;

import java.util.List;

import com.techconquerors.slippers.jpa.User;

public interface UserDao {
	public User getUserByUserName(final String userName);
	public List<User> getAllUsers();
}
