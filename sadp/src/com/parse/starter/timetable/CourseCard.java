package com.parse.starter.timetable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.fima.cardsui.objects.Card;
import com.parse.starter.R;
import com.parse.starter.model.courses.Course;

public class CourseCard extends Card {
	
	private final Course course;
	private final boolean showFullDescription;
	
	public CourseCard(Course course, boolean showFullDescription) {
		super(course.getCourseName());
		
		this.course = course;
		this.showFullDescription = showFullDescription;
	}
	
	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.course_card, null);
		((TextView)view.findViewById(R.id.title)).setText(title);
		
		TextView descriptionTextView = (TextView)view.findViewById(R.id.description);
		descriptionTextView.setText(course.getDescription());
		if(showFullDescription) {
			descriptionTextView.setMaxLines(Integer.MAX_VALUE);
		}
		
		return view;
	}

}
