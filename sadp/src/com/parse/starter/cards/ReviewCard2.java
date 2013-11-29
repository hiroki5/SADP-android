package com.parse.starter.cards;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.fima.cardsui.objects.Card;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.starter.R;
import com.parse.starter.courses.CourseDetailActivity;
import com.parse.starter.model.courses.Course;

// TODO Remove this class if this class is not used.

public class ReviewCard2 extends Card implements OnClickListener {
	
	//private final String courseId;
	private final Course course;
	private final boolean showFullDescription;
	private final Activity activity;
	
	public ReviewCard2(Course course, Activity activity, boolean showFullDescription) {
		super(course.getCourseName());
		
		this.course = course;
		this.activity = activity;
		this.showFullDescription = showFullDescription;
	}
	
	@Override
	public View getCardContent(Context context) {
		
		View view = LayoutInflater.from(context).inflate(R.layout.review2_card, null);
		((TextView)view.findViewById(R.id.title)).setText("レビュー");
		
        String []a = new String[3];
		
		ParseQuery<ParseObject> query2 = ParseQuery.getQuery("lecture5");
		try{
			System.out.println("�A�N�Z�X");
			List<ParseObject> objects2 = query2.find();
			ParseObject object2 = objects2.get(0);
			a[0] = object2.getString("review");
			ParseObject object3 = objects2.get(1);
			a[1] = object3.getString("review");
			ParseObject object4 = objects2.get(2);
			a[2] = object4.getString("review");
			
			/*
			TextView[] Review = new TextView[3];
			Review[0] = (TextView) view.findViewById(R.id.description);
	        Review[0].setText("レビュー1："+a[0]);
	        Review[1] = (TextView) view.findViewById(R.id.description2);
	        Review[1].setText("レビュー2："+a[1]);
	        Review[2] = (TextView) view.findViewById(R.id.description3);
	        Review[2].setText("レビュー3："+a[2]);
	        if(showFullDescription) {
				Review[0].setMaxLines(Integer.MAX_VALUE);
			}
			*/
		}catch(Exception e){
			// parse�̃A�N�Z�X�Ɏ��s�����Ƃ��̏���
			System.out.println("�A�N�Z�X���s");
		}
		
		/*
		TextView descriptionTextView = (TextView)view.findViewById(R.id.description);
		descriptionTextView.setText("楽である");
		TextView descriptionTextView2 = (TextView)view.findViewById(R.id.description2);
		descriptionTextView2.setText("楽である");
		TextView descriptionTextView3 = (TextView)view.findViewById(R.id.description3);
		descriptionTextView3.setText("楽である");
		if(showFullDescription) {
			descriptionTextView.setMaxLines(Integer.MAX_VALUE);
		}
		*/
		
		setOnClickListener(this);
		
		return view;
	}

	@Override
	public void onClick(View view) {
		if(activity != null) {
			Intent intent = new Intent(activity.getApplicationContext(), CourseDetailActivity.class);
			intent.putExtra(CourseDetailActivity.ARG_COURSE_ID, course.getCourseId());
			activity.startActivity(intent);	
		}
	}

}
