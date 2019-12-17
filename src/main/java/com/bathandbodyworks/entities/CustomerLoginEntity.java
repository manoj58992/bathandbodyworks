package com.bathandbodyworks.entities;

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

@Entity
@Table(name = "customer_login")
public class CustomerLoginEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "uname")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "last_sign_on")
	private Date lastSignOn;

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid")

	private CustomerEntity customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastSignOn() {
		return lastSignOn;
	}

	public void setLastSignOn(Date lastSignOn) {
		this.lastSignOn = lastSignOn;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerLoginEntity [id=" + id + ", username=" + username + ", password=" + password + ", lastSignOn="
				+ lastSignOn + ", customer=" + customer + "]";
	}

}
