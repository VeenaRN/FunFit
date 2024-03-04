package com.xadmin.usermanagement.bean;

public class User {

	protected int participant_id;
	protected String name;
	protected String age;
	protected String email;
	protected String phone;
	//changed
	protected String batchname;  
	protected String address;
	//private String registration_date;
	public int getParticipant_id() {
		return participant_id;
	}
	public void setParticipant_id(int participant_id) {
		this.participant_id = participant_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBatchname() {
		return batchname;
	}
	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User(int participant_id, String name, String age, String email, String phone, String batchname,
			String address) {
		super();
		this.participant_id = participant_id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.batchname=batchname;
		this.address = address;
	}
	public User(String name, String age, String email, String phone,String batchname,  String address) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.batchname=batchname;
		this.address = address;
	}
	
	
	
}
