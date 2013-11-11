package com.parse.starter.model.courses;

import java.util.ArrayList;
import java.util.List;

public class Category {
	
	final private String categoryName;
	final private List<Course> courses = new ArrayList<Course>();
	
	public Category(String categoryName) {
		this.categoryName = categoryName;
	}
	
	public String getCategoryName() {
		return this.categoryName;
	}
	
	public void addCourse(Course course) {
		this.courses.add(course);
	}
	
	public Course[] getCourses() {
		return this.courses.toArray(new Course[this.courses.size()]);
	}
}
