package com.webwork.event.management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "states")
public class States {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "country_id")
	private int CountryId;

	public States() {
	}

	public States(int id, String name, int countryId) {
		this.id = id;
		this.name = name;
		CountryId = countryId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCountryId() {
		return CountryId;
	}

	public void setCountryId(int countryId) {
		CountryId = countryId;
	}

	@Override
	public String toString() {
		return "States [id=" + id + ", name=" + name + ", CountryId=" + CountryId + "]";
	}

}
