package com.webwork.eventmanagementengine.dto;

public class Address {

	private String state;

	private String district;

	private String taluka;

	private String localAddress;

	public Address() {
	}

	public Address(String state, String district, String taluka, String localAddress) {
		this.state = state;
		this.district = district;
		this.taluka = taluka;
		this.localAddress = localAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getTaluka() {
		return taluka;
	}

	public void setTaluka(String taluka) {
		this.taluka = taluka;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", district=" + district + ", taluka=" + taluka + ", localAddress="
				+ localAddress + "]";
	}

}
