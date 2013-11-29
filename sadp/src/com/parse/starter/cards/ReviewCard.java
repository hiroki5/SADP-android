package com.parse.starter.cards;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.fima.cardsui.objects.Card;
import com.parse.CountCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.starter.R;
import com.parse.starter.dal.TimeTableDAL;

public class ReviewCard extends Card implements OnClickListener {
	
	private final String courseId;
	private TimeTableDAL timeTableDAL = null;
	private LinearLayout notRegisteredLayout = null;
	private LinearLayout registeredLayout = null;
	float score;
	
	public ReviewCard(String courseId) {
		this.courseId = courseId;
	}
	
	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.review_card, null);
		
		timeTableDAL = new TimeTableDAL(context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE));
		
		registeredLayout = (LinearLayout) view.findViewById(R.id.layoutRegistered);
		notRegisteredLayout = (LinearLayout) view.findViewById(R.id.layoutNotRegistered);
		
		updateLayout();
		
		//Button registerButton = (Button) view.findViewById(R.id.registerCourseButton);
		//registerButton.setOnClickListener(this);
		//Button unRegisterButton = (Button) view.findViewById(R.id.unRegisterCourseButton);
		//unRegisterButton.setOnClickListener(this);
		
		float[] a = new float[3];
		float sum;
		int count=3;
		
		ParseQuery<ParseObject> query2 = ParseQuery.getQuery(courseId);
		query2.orderByDescending("createdAt");
		
		try{
			System.out.println("�A�N�Z�X");
			List<ParseObject> objects2 = query2.find();
			ParseObject object2 = objects2.get(0);
			//a[0] = (Integer) object2.get("score");
			a[0] = object2.getInt("score");
			if(a[0]==0){
				count=count-1;
			}
			ParseObject object3 = objects2.get(1);
			
			a[1] = object3.getInt("score");
			if(a[1]==0){
				count=count-1;
			}
			ParseObject object4 = objects2.get(2);
			a[2] = object4.getInt("score");
			if(a[2]==0){
				count=count-1;
			}
			
			sum=(a[0]+a[1]+a[2])/count;
			score=sum;
			/*
			TextView[] Review = new TextView[3];
			Review[0] = (TextView) view.findViewById(R.id.description);
	        Review[0].setText("レビュー1："+a[0]);
	        Review[1] = (TextView) view.findViewById(R.id.description2);
	        Review[1].setText("レビュー2："+a[1]);
	        Review[2] = (TextView) view.findViewById(R.id.description3);
	        Review[2].setText("レビュー3："+sum);
	        */
	       
			
		}catch(Exception e){
			// parse�̃A�N�Z�X�Ɏ��s�����Ƃ��̏���
			System.out.println("�A�N�Z�X���s");
		}
		
		TextView text1 = (TextView) view.findViewById(R.id.description);
		text1.setText("評価");
		
		RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar1);
        ratingBar.setNumStars(5);
        ratingBar.setRating(score);
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
