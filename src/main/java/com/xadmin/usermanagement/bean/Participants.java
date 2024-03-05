package com.xadmin.usermanagement.bean;


//CREATE TABLE participants (
//	    id INT AUTO_INCREMENT PRIMARY KEY,
//	    name VARCHAR(50),
//	    gender VARCHAR(50),
//        email varchar(20),
//	    address varchar(50),
//	    phone varchar(100),
//	    batch_id INT,
//	    FOREIGN KEY (batch_id) REFERENCES batches(id)
//	);

public class Participants {

	private int id;
	private String name;
	private String gender;
	private String email;
	private String address;
	private String phone;
	private int batch_id;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}
	public Participants(int id, String name, String gender, String email, String address, String phone, int batch_id) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.batch_id = batch_id;
	}
	public Participants(String name, String gender, String email, String address, String phone, int batch_id) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.batch_id = batch_id;
	} 
	
	
	
	
}
