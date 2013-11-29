package com.yaunix.test.sadp.model.courses;

import java.io.Serializable;

public class Course implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private final String courseId;
	private final String courseName;
	private final String description;
	private final Day day;
	
	public Course(String courseId,  String courseName, String description, Day day) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.day = day;
	}
	
	public String getCourseId() {
		return this.courseId;
	}
	
	public String getCourseName() {
		return this.courseName;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public Day getDay() {
		return this.day;
	}
}
