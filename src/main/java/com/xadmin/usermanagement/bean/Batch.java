package com.xadmin.usermanagement.bean;

import java.sql.Time;

public class Batch {
	
	private int id;
	private String batch_name;
	
	private String session_type;
	private String instructor;
	private String location;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBatch_name() {
		return batch_name;
	}
	public void setBatch_name(String batch_name) {
		this.batch_name = batch_name;
	}
	
	public String getSession_type() {
		return session_type;
	}
	public void setSession_type(String session_type) {
		this.session_type = session_type;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Batch(int id, String batch_name,  String session_type, String instructor,
			String location) {
		super();
		this.id = id;
		this.batch_name = batch_name;
		//this.session_time = session_time;
		this.session_type = session_type;
		this.instructor = instructor;
		this.location = location;
	}
	public Batch(String batch_name,  String session_type, String instructor, String location) {
		super();
		this.batch_name = batch_name;
		//this.session_time = session_time;
		this.session_type = session_type;
		this.instructor = instructor;
		this.location = location;
	}
	
	
	
	

}
