package com.areteans.pojo;

public class PersonalDetailsPojo {

	private int id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String motherName;
	private String birthDate;
	private String gender;
	private String maritalStatus;
	
	public PersonalDetailsPojo() {
		// TODO Auto-generated constructor stub
	}

	public PersonalDetailsPojo(int id, String firstName, String middleName, String lastName, String motherName,
			String birthDate, String gender, String maritalStatus) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.motherName = motherName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
	}
	
	public PersonalDetailsPojo(String firstName, String middleName, String lastName, String motherName, String birthDate,
			String gender, String maritalStatus) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.motherName = motherName;
		this.birthDate = birthDate;
		this.gender = gender;
		this.maritalStatus = maritalStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Override
	public String toString() {
		return "PersonalDetails [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", motherName=" + motherName + ", birthDate=" + birthDate + ", gender=" + gender
				+ ", maritalStatus=" + maritalStatus + "]";
	}
}
