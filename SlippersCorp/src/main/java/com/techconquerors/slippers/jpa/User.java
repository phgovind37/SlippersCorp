package com.techconquerors.slippers.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("deprecation")
@Entity
@Table(name="user")
public class User implements UserDetails, Serializable {
	/**
	 * @author Govind
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, unique = true)
	private Long id;
	@Column(name="tenant_id")
	private Long tenantId;
	@Column(name ="user_name",nullable = false, unique=true)
	private String userName;
	@Column(name="password")
	private String password;
	@ManyToOne()
	@JoinColumn(name="role_id",nullable = false)
	private Role role;
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL)
	private Employee employee;
	
	public User(){
	}
	
public User(Long id, String userName, String password, Role role) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public Long getTenantId() {
	return tenantId;
}

public void setTenantId(Long tenantId) {
	this.tenantId = tenantId;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public Role getRole() {
	return role;
}

public void setRole(Role role) {
	this.role = role;
}

public Employee getEmployee() {
	return employee;
}

public void setEmployee(Employee employee) {
	this.employee = employee;
}

public void setPassword(String password) {
	this.password = password;
}

	/*asdf
 * 
 * */
	//Spring Security props
	private transient Collection<GrantedAuthority> authorities;

	// UserDetails methods
	@Override
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Transient
	public void setUserAuthorities(final List<String> authorities) {
		final List<GrantedAuthority> listOfAuthorities = new ArrayList<GrantedAuthority>();
		for (final String role : authorities) {
			listOfAuthorities.add(new GrantedAuthorityImpl(role));
		}
		this.authorities = listOfAuthorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return getUserName();
	}

	@Override
	@Transient
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	@Transient
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	@Transient
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public boolean equals(final Object obj) {
		if (obj instanceof User) {
			final User user = (User) obj;
			return (getId().equals(user.getId()) && getUserName()
					.equalsIgnoreCase(user.getUserName()));
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int temp = ((31) * 1)
				+ (getUserName() == null ? 0 : getUserName().hashCode())
				+ (getId() == null ? 0 : getId().hashCode());
		return temp;
	}

}
