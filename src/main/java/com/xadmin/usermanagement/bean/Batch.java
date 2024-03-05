package com.xadmin.usermanagement.bean;



//CREATE TABLE batches (
//	    id INT AUTO_INCREMENT PRIMARY KEY,
//		    name VARCHAR(50),
//		    time varchar(50),
//		    instructor varchar(50),
//            location varchar(50),
//            session_type varchar(20)
//		);

public class Batch {

	private int id;
	private String name;

	private String time;
	private String instructor;
	private String location;
	private String session_type;

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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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

	public String getSession_type() {
		return session_type;
	}

	public void setSession_type(String session_type) {
		this.session_type = session_type;
	}

	public Batch(int id, String name, String time, String instructor, String location, String session_type) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.instructor = instructor;
		this.location = location;
		this.session_type = session_type;
	}

	public Batch(String name, String time, String instructor, String location, String session_type) {
		super();
		this.name = name;
		this.time = time;
		this.instructor = instructor;
		this.location = location;
		this.session_type = session_type;
	}

}
