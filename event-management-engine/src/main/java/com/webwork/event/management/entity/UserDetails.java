package com.webwork.event.management.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user_detail")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "mobile")
	private String phone;

	@Column(name = "Address")
	private String address;

	@Column(name = "city")
	private String city;

	@Column(name = "dist")
	private String dist;

	@Column(name = "state")
	private String state;

	@Column(name = "pin_code")
	private String pinCode;

	@JsonBackReference
	@OneToOne(mappedBy = "userDetails")
	private User user;

	public UserDetails() {
	}

	public UserDetails(int id, String phone, String address, String city, String dist, String state, String pinCode,
			User user) {
		this.id = id;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.dist = dist;
		this.state = state;
		this.pinCode = pinCode;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", phone=" + phone + ", address=" + address + ", city=" + city + ", dist="
				+ dist + ", state=" + state + ", pinCode=" + pinCode + "]";
	}
	

	
}
