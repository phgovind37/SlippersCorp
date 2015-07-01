package com.techconquerors.slippers.service.interfaces;

import java.util.List;

import com.techconquerors.slippers.jpa.User;

public interface UserService {
	public User getUserByUserName(final String userName);
	public List<String> getAuthoritiesByUserName(final String userName);
	public List<User> getAllUsers();
}
