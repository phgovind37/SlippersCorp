package com.techconquerors.slippers.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.techconquerors.slippers.jpa.User;

public class RoleAnalyser {
	
	public static Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	@SuppressWarnings("unchecked")
	public static Collection<? extends GrantedAuthority> getAuthorities() {
		Authentication auth = getAuthentication();
		if(auth != null) {
			return auth.getAuthorities();
		}
		return Collections.EMPTY_LIST;
	}
	
	private static User getCurrentUser() {
		Authentication auth = getAuthentication();
		if(auth != null) {
			Object principal = auth.getPrincipal();
			return principal instanceof User ? (User) principal : null; 
		}
		return null;
	}
	
	public static String getRole() {
		User user = getCurrentUser();
		if(user != null && user.getRole() != null) {
			return user.getRole().getRoleName();
		}
		return null;
	}
}
