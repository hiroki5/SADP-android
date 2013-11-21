package com.parse.starter.model.courses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import com.parse.starter.R;

import android.content.Context;
import android.util.Log;

public class CourseDataLoader {

	private static String TAG = "PARSER";
	
	private static Category[] cache = null;
	
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
							category.addCourse(new Course(
									courseId,
									courseName,
									description,
									Day.convertToDay(day)));
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
