package com.techconquerors.slippers.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="roleauthoritymapping")
public class RoleAuthorityMapping implements Serializable {
	/**
	 * @author Govind
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false,unique = true)
	private Long id;
	@Column(name="tenant_id")
	private Long tenantId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id", nullable = false)
	private Role role;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="authority_id",nullable = false)
	private Authority authority;
	
	public RoleAuthorityMapping() {
	}

	public RoleAuthorityMapping(Long id, Long tenantId, Role role,
			Authority authority) {
		super();
		this.id = id;
		this.tenantId = tenantId;
		this.role = role;
		this.authority = authority;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
	
}
