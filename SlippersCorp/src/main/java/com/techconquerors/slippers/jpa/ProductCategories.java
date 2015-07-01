package com.techconquerors.slippers.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="productcategories")
public class ProductCategories implements Serializable {

	/**
	 * @author Govind
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable=false)
	private Long id;
	@Column(name="tenant_id")
	private Long tenantId;
	@Column(name = "category", nullable = false)
	private String category;
	@Column(name = "lastUpdatedBy", nullable = true)
	private Long lastUpdatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastUpdatedTime", nullable = true, length = 19)
	private Date lastUpdatedTime;
	
	public ProductCategories(){
	}

	public ProductCategories(Long id, Long tenantId, String category,
			Long lastUpdatedBy, Date lastUpdatedTime) {
		super();
		this.id = id;
		this.tenantId = tenantId;
		this.category = category;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedTime = lastUpdatedTime;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(Long lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(Date lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

}
