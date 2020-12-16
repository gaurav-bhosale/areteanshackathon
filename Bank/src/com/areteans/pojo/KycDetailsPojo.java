package com.areteans.pojo;

public class KycDetailsPojo {

	private int id;
	private String aadhar;
	private String pancard;
	
	public KycDetailsPojo() {
		// TODO Auto-generated constructor stub
	}

	public KycDetailsPojo(int id, String aadhar, String pancard) {
		super();
		this.id = id;
		this.aadhar = aadhar;
		this.pancard = pancard;
	}

	public KycDetailsPojo(String aadhar, String pancard) {
		super();
		this.aadhar = aadhar;
		this.pancard = pancard;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	@Override
	public String toString() {
		return "KycDetailsPojo [id=" + id + ", aadhar=" + aadhar + ", pancard=" + pancard + "]";
	}
}
