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
@Table(name="address")
public class Address implements Serializable {

	/**
	 * @author Govind
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	@Column(name="tenant_id")
	private Long tenantId;
	@Column(name="line1")
	private String line1;
	@Column(name="city")
	private String city;
	@Column(name="pin")
	private long pin;
	@Column(name="lastUpdatedBy")
	private Long lastUpdatedBy;
	@Column(name="lastUpdatedTime",nullable=false,length=19)
	private Date lastUpdatedTime;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="state_id",nullable=false)
	private State state;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="country_id",nullable=false)
	private Country country;
	
	public Address(){
	}

	public Address(Long id, Long tenantId, String line1, String city, long pin,
			Long lastUpdatedBy, Date lastUpdatedTime, State state,
			Country country) {
		this.id = id;
		this.tenantId = tenantId;
		this.line1 = line1;
		this.city = city;
		this.pin = pin;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedTime = lastUpdatedTime;
		this.state = state;
		this.country = country;
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

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPin() {
		return pin;
	}

	public void setPin(long pin) {
		this.pin = pin;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}
