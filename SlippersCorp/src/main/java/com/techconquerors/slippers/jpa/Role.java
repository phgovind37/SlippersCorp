package com.techconquerors.slippers.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	@Column(name="tenant_id")
	private Long tenantId;
	@Column(name="role_name")
	private String roleName;
	@OneToMany(mappedBy="role")
	private List<RoleAuthorityMapping> roleAuthorityMappings = new ArrayList<RoleAuthorityMapping>();
	
	public Role(){
	}

	public Role(Long id, Long tenantId, String roleName) {
		super();
		this.id = id;
		this.tenantId = tenantId;
		this.roleName = roleName;
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

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<RoleAuthorityMapping> getRoleAuthorityMappings() {
		return roleAuthorityMappings;
	}

	public void setRoleAuthorityMappings(
			List<RoleAuthorityMapping> roleAuthorityMappings) {
		this.roleAuthorityMappings = roleAuthorityMappings;
	}
	
}
