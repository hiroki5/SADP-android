package com.yaunix.test.sadp.model.courses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.yaunix.test.sadp.R;

import android.content.Context;
import android.util.Log;

public class CourseDataLoader {

	private static String TAG = "PARSER";
	
	private static Category[] cache = null;
	private static Map<String, Course> coursesMap = new HashMap<String, Course>();
	
	/**
	 * Return course of specified course id.
	 * @param courseId
	 * @return
	 */
	public static Course getCourse(String courseId, Context context) {
		loadCourses(context);
		
		if(coursesMap.containsKey(courseId)) {
			return coursesMap.get(courseId);
		} else {
			return null;
		}
	}
	
	// Load categories from XML file
	public static Category[] loadCourses(Context context) {
		if(cache != null) {
			return cache;
		}
		
		List<Category> categories = new ArrayList<Category>();
		
		try {
			XmlPullParser parser = context.getResources().getXml(R.xml.courses);
			
			Category category = null;
			
			int type = parser.getEventType();
			while(type != XmlPullParser.END_DOCUMENT) {
				type = parser.next();
				switch(type) {
					case XmlPullParser.START_TAG:
						String tag = parser.getName();
						if(tag.equals("category")) {
							String categoryName = parser.getAttributeValue(null, "name");
							Log.d(TAG, "Category name: " + categoryName);
							category = new Category(categoryName);
							categories.add(category);
						} else if(tag.equals("course")) {
							String courseName = parser.getAttributeValue(null, "name");
							Log.d(TAG, "Course name: " + courseName);
							String courseId = parser.getAttributeValue(null, "id");
							String day = parser.getAttributeValue(null, "day");
							String description = parser.getAttributeValue(null, "description");
							Course course = new Course(
									courseId,
									courseName,
									description,
									Day.convertToDay(day));
							coursesMap.put(course.getCourseId(), course);
							category.addCourse(course);
						}
						break;
				}
			}
		
		} catch (XmlPullParserException e) {
			Log.e(TAG, "PullparserException");
			e.printStackTrace();
		} catch (IOException e) {
			Log.e(TAG, "IOException");
			e.printStackTrace();
		}
		
		cache = categories.toArray(new Category[categories.size()]);
		return cache;
	}
}
