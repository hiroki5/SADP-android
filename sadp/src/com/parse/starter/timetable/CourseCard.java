package com.parse.starter.timetable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.fima.cardsui.objects.Card;
import com.parse.starter.R;

public class CourseCard extends Card {

	public CourseCard(String title) {
		super(title);
	}
	
	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.course_card, null);
		((TextView)view.findViewById(R.id.title)).setText(title);
		
		return view;
	}

}
