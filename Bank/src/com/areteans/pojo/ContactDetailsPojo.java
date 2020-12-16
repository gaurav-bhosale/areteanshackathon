package com.areteans.pojo;

public class ContactDetailsPojo {

	private int id;
	private String email;
	private String mobile;
	private String altMobiel;
	private String addLine1;
	private String addLine2;
	private String city;
	private String state;
	private String pincode;
	
	public ContactDetailsPojo() {
		// TODO Auto-generated constructor stub
	}

	public ContactDetailsPojo(int id, String email, String mobile, String altMobiel, String addLine1, String addLine2,
			String city, String state, String pincode) {
		super();
		this.id = id;
		this.email = email;
		this.mobile = mobile;
		this.altMobiel = altMobiel;
		this.addLine1 = addLine1;
		this.addLine2 = addLine2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public ContactDetailsPojo(String email, String mobile, String altMobiel, String addLine1, String addLine2,
			String city, String state, String pincode) {
		super();
		this.email = email;
		this.mobile = mobile;
		this.altMobiel = altMobiel;
		this.addLine1 = addLine1;
		this.addLine2 = addLine2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAltMobiel() {
		return altMobiel;
	}

	public void setAltMobiel(String altMobiel) {
		this.altMobiel = altMobiel;
	}

	public String getAddLine1() {
		return addLine1;
	}

	public void setAddLine1(String addLine1) {
		this.addLine1 = addLine1;
	}

	public String getAddLine2() {
		return addLine2;
	}

	public void setAddLine2(String addLine2) {
		this.addLine2 = addLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "ContactDetailsPojo [id=" + id + ", email=" + email + ", mobile=" + mobile + ", altMobiel=" + altMobiel
				+ ", addLine1=" + addLine1 + ", addLine2=" + addLine2 + ", city=" + city + ", state=" + state
				+ ", pincode=" + pincode + "]";
	}
}
