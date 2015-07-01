package com.techconquerors.slippers.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techconquerors.slippers.dao.interfaces.UserDao;
import com.techconquerors.slippers.jpa.RoleAuthorityMapping;
import com.techconquerors.slippers.jpa.User;
import com.techconquerors.slippers.service.interfaces.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public User getUserByUserName(String userName) {
		final User user = userDao.getUserByUserName(userName);
		if(user == null){
			return null;
		}
		Hibernate.initialize(user.getRole());
		return user;
	}

	@Override
	@Transactional
	public List<String> getAuthoritiesByUserName(String userName) {
		final List<String> roleAuthorityMappings = new ArrayList<String>();
		final User user = userDao.getUserByUserName(userName);
		if(user != null){
			final List<RoleAuthorityMapping> mappings = user.getRole().getRoleAuthorityMappings();

			for (final RoleAuthorityMapping mapping : mappings) {
				roleAuthorityMappings.add(mapping.getAuthority().getAuthorityName());
			}
		}
		return roleAuthorityMappings;
	}

	@Override
	@Transactional
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}

}
