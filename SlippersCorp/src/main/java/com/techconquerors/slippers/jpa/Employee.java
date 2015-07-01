package com.techconquerors.slippers.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="employee")
public class Employee implements Serializable {

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
	@Column(name="first_name", nullable = false)
	private String firstName;
	@Column(name="middle_name")
	private String middlefirstName;
	@Column(name="last_name", nullable = false)
	private String lastName;
	@Column(name = "phone", length = 15)
	private String phone;
	@Column(name = "mobile", length = 100)
	private String mobile;
	@Column(name = "email", length = 100)
	private String email;
	@Column(name = "image", length = 100)
	private String image;
	@Temporal(TemporalType.DATE)
	@Column(name = "dob", nullable = false, length = 10)
	private Date dob;
	@Column(name = "gender", length = 1)
	private Character gender;
	@Column(name = "blood_group", length = 10)
	private String bloodGroup;
	@Column(name = "marital_status", nullable = false, length = 20)
	private String maritalStatus;
	@Column(name = "lastUpdatedBy", nullable = true)
	private Long lastUpdatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastUpdatedTime", nullable = true, length = 19)
	private Date lastUpdatedTime;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",nullable=false)
	private User user;
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="communication_address_id",nullable=false)
	private Address communicationAddress;
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="permanent_address_id",nullable=false)
	private Address permanentAddress;
	
	public Employee(){
	}

	public Employee(Long id, Long tenantId, String firstName,
			String middlefirstName, String lastName, String phone,
			String mobile, String email, String image, Date dob,
			Character gender, String bloodGroup, String maritalStatus,
			Long lastUpdatedBy, Date lastUpdatedTime, User user,
			Address communicationAddress, Address permanentAddress) {
		this.id = id;
		this.tenantId = tenantId;
		this.firstName = firstName;
		this.middlefirstName = middlefirstName;
		this.lastName = lastName;
		this.phone = phone;
		this.mobile = mobile;
		this.email = email;
		this.image = image;
		this.dob = dob;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.maritalStatus = maritalStatus;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedTime = lastUpdatedTime;
		this.user = user;
		this.communicationAddress = communicationAddress;
		this.permanentAddress = permanentAddress;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddlefirstName() {
		return middlefirstName;
	}

	public void setMiddlefirstName(String middlefirstName) {
		this.middlefirstName = middlefirstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getCommunicationAddress() {
		return communicationAddress;
	}

	public void setCommunicationAddress(Address communicationAddress) {
		this.communicationAddress = communicationAddress;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

}
