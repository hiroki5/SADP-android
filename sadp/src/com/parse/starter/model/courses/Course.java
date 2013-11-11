package com.parse.starter.model.courses;

import java.io.Serializable;

public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final String courseName;
	
	public Course(String courseName) {
		this.courseName = courseName;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
}
