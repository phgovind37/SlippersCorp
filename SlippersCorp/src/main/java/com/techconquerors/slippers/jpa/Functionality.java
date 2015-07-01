package com.techconquerors.slippers.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="functionality")
public class Functionality implements Serializable {
	/**
	 * @author Govind
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable = false, unique = true)
	private Long id;
	@Column(name="functionality_name")
	private String functionalityName;
	
	public Functionality(){
	}

	public Functionality(Long id, String functionalityName) {
		super();
		this.id = id;
		this.functionalityName = functionalityName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFunctionalityName() {
		return functionalityName;
	}

	public void setFunctionalityName(String functionalityName) {
		this.functionalityName = functionalityName;
	}

}
