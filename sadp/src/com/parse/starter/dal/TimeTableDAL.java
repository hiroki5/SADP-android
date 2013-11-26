package com.parse.starter.dal;

import java.util.HashSet;
import java.util.Set;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class TimeTableDAL {
	static private final String REGISTERED_COURSES = "RegisteredCourses";
	private final SharedPreferences pref;
	
	public TimeTableDAL(SharedPreferences pref) {
		this.pref = pref;
	}
	
	public Set<String> getRegisteredCourses() {
		return pref.getStringSet(REGISTERED_COURSES, new HashSet<String>());
	}
	
	public boolean isRegistered(String courseId) {
		return getRegisteredCourses().contains(courseId);
	}
	
	public void register(String courseId) {
		Editor editor = pref.edit();
		Set<String> registeredCourses = getRegisteredCourses();
		if(!registeredCourses.contains(courseId)) {
			registeredCourses.add(courseId);
		}
		editor.putStringSet(REGISTERED_COURSES, registeredCourses);
		editor.commit();
	}
	
	public void unRegister(String courseId) {
		Editor editor = pref.edit();
		Set<String> registeredCourses = getRegisteredCourses();
		if(registeredCourses.contains(courseId)) {
			registeredCourses.remove(courseId);
		}
		editor.putStringSet(REGISTERED_COURSES, registeredCourses);
		editor.commit();
	}
}
