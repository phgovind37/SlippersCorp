package com.techconquerors.slippers.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="country")
public class Country implements Serializable {

	/**
	 * @author Govind
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable = false,unique = true)
	private Long id;
	@Column(name="name",nullable = false)
	private String name;
	@Column(name="lastUpdatedBy")
	private Long lastUpdatedBy;
	@Column(name="lastUpdatedTime",nullable=false,length=19)
	private Date lastUpdatedTime;
	
	public Country(){
	}

	public Country(Long id, String name, Long lastUpdatedBy,
			Date lastUpdatedTime) {
		super();
		this.id = id;
		this.name = name;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
