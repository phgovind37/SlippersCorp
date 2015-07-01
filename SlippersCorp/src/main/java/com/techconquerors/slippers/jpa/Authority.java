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
@Table(name="authority")
public class Authority implements Serializable {
	/**
	 * @author Govind
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable = true,unique = true)
	private Long id;
	@Column(name = "authority_name")
	private String authorityName;
	@Column(name="authority_display_text")
	private String authorityDisplayText;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="functionality_id", nullable= false)
	private Functionality functionality;
	
	public Authority(){
	}

	public Authority(Long id, String authorityName,
			String authorityDisplayText, Functionality functionality) {
		super();
		this.id = id;
		this.authorityName = authorityName;
		this.authorityDisplayText = authorityDisplayText;
		this.functionality = functionality;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	public String getAuthorityDisplayText() {
		return authorityDisplayText;
	}

	public void setAuthorityDisplayText(String authorityDisplayText) {
		this.authorityDisplayText = authorityDisplayText;
	}

	public Functionality getFunctionality() {
		return functionality;
	}

	public void setFunctionality(Functionality functionality) {
		this.functionality = functionality;
	}
	
}
