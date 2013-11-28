package com.parse.starter.cards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;

import com.fima.cardsui.objects.Card;
import com.parse.starter.R;
import com.parse.starter.dal.TimeTableDAL;

public class ReviewRegisterCard extends Card implements OnClickListener {
	
	private final String courseId;
	private TimeTableDAL timeTableDAL = null;
	private LinearLayout notRegisteredLayout = null;
	private LinearLayout registeredLayout = null;
	
	public ReviewRegisterCard(String courseId) {
		this.courseId = courseId;
	}
	
	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.reviewregister_card, null);
		
		timeTableDAL = new TimeTableDAL(context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE));
		
		registeredLayout = (LinearLayout) view.findViewById(R.id.layoutRegistered);
		notRegisteredLayout = (LinearLayout) view.findViewById(R.id.layoutNotRegistered);
		
		updateLayout();
		
		//Button registerButton = (Button) view.findViewById(R.id.registerCourseButton);
		//registerButton.setOnClickListener(this);
		//Button unRegisterButton = (Button) view.findViewById(R.id.unRegisterCourseButton);
		//unRegisterButton.setOnClickListener(this);
		
		RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar1);
        ratingBar.setNumStars(5);
        ratingBar.setRating(3);
        ratingBar.setIsIndicator(true);
		
		return view;
	}

	private void updateLayout() {
		if(timeTableDAL.isRegistered(courseId)) {
			notRegisteredLayout.setVisibility(View.GONE);
			registeredLayout.setVisibility(View.VISIBLE);
		} else {
			notRegisteredLayout.setVisibility(View.VISIBLE);
			registeredLayout.setVisibility(View.GONE);
		}
	}
	
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.registerCourseButton:
			timeTableDAL.register(courseId);
			updateLayout();	
			break;
		case R.id.unRegisterCourseButton:
			timeTableDAL.unRegister(courseId);
			updateLayout();	
			break;
		}
		
	}
}
