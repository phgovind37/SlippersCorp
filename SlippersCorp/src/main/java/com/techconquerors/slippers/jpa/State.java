package com.techconquerors.slippers.jpa;

import java.io.Serializable;
import java.util.Date;

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
@Table(name="state")
public class State implements Serializable {

	/**
	 * @author Govind
	 */
	private static final long serialVersionUID = 1L;
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="id",nullable=false, unique =true)
	 private Long id;
	 @Column(name="name")
	 private String name;
	 @Column(name="lastUpdatedBy")
	 private Long lastUpdatedBy;
	 @Column(name="lastUpdatedTime",nullable=false,length=19)
	 private Date lastUpdatedTime;
	 
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="country_id", nullable = false)
	 private Country country;
	 
	 public State(){
	 }

	public State(Long id, String name, Long lastUpdatedBy,
			Date lastUpdatedTime, Country country) {
		this.id = id;
		this.name = name;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedTime = lastUpdatedTime;
		this.country = country;
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
