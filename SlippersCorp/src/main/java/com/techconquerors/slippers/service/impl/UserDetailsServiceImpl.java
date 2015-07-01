package com.techconquerors.slippers.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techconquerors.slippers.common.LoginType;
import com.techconquerors.slippers.jpa.User;
import com.techconquerors.slippers.service.interfaces.UserService;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	//private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Autowired
	private UserService userService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(final String userName)
			throws UsernameNotFoundException, DataAccessException {
		User user = userService.getUserByUserName(userName);

		final List<String> authorities = userService.getAuthoritiesByUserName(userName);
	//	final List<String> authorities = new ArrayList<String>();

		LoginType loginType = null;
		if (user.getRole() != null
				&& (loginType = LoginType.valueOf(user.getRole().getRoleName())) != null) {
				authorities.add("ROLE_" + loginType.name());

			user.setUserAuthorities(authorities);

			final UserDetails ud = user;
			return ud;
		}

		return null;
	}
}