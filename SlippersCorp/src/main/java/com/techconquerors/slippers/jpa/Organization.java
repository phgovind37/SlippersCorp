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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "organization")
public class Organization implements Serializable {

	/**
	 * @author Govind
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", nullable = false, unique = true)
	private Long id;
	@Column(name="name")
	private String name;
	@Column(name = "phone", length = 15)
	private String phone;
	@Column(name = "mobile", length = 100)
	private String mobile;
	@Column(name = "fax", length = 100)
	private String fax;
	@Column(name = "email", length = 100)
	private String email;
	@Column(name = "tan_no", length = 100)
	private String tanNno;
	@Column(name = "tin_no", length = 100)
	private String tinNo;
	@Column(name = "image", length = 100)
	private String image;
	@Column(name = "lastUpdatedBy", nullable = true)
	private Long lastUpdatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastUpdatedTime", nullable = true, length = 19)
	private Date lastUpdatedTime;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="address_id")
	private Address address;
	
	public Organization() {
	}

	public Organization(Long id, String name, String phone, String mobile,
			String fax, String email, String tanNno, String tinNo,
			String image, Long lastUpdatedBy, Date lastUpdatedTime,
			Address address) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.mobile = mobile;
		this.fax = fax;
		this.email = email;
		this.tanNno = tanNno;
		this.tinNo = tinNo;
		this.image = image;
		this.lastUpdatedBy = lastUpdatedBy;
		this.lastUpdatedTime = lastUpdatedTime;
		this.address = address;
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

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTanNno() {
		return tanNno;
	}

	public void setTanNno(String tanNno) {
		this.tanNno = tanNno;
	}

	public String getTinNo() {
		return tinNo;
	}

	public void setTinNo(String tinNo) {
		this.tinNo = tinNo;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
