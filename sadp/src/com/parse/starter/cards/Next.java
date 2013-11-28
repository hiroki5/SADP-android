package com.parse.starter.cards;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.fima.cardsui.objects.Card;
import com.parse.starter.R;
import com.parse.starter.top;
import com.parse.starter.courses.CopyOfCourseDetailActivity;
import com.parse.starter.courses.CourseDetailActivity;
import com.parse.starter.courses.CourseDetailFragment;
import com.parse.starter.courses.CourseListActivity;
import com.parse.starter.model.courses.Course;

public class Next extends Card implements OnClickListener {
	
	private final Course course;
	private final boolean showFullDescription;
	private final Activity activity;
	
	public Next(Course course, Activity activity, boolean showFullDescription) {
		super(course.getCourseName());
		
		this.course = course;
		this.activity = activity;
		this.showFullDescription = showFullDescription;
	}
	
	@Override
	public View getCardContent(Context context) {
		
		View view = LayoutInflater.from(context).inflate(R.layout.next, null);
		/*
		((TextView)view.findViewById(R.id.title)).setText(title);
		
		TextView descriptionTextView = (TextView)view.findViewById(R.id.description);
		descriptionTextView.setText(course.getDescription());
		if(showFullDescription) {
			descriptionTextView.setMaxLines(Integer.MAX_VALUE);
		}
		*/
		
		Button button1 = (Button) view.findViewById(R.id.button1);
        button1.setText("レビューを登録する");
		
		button1.setOnClickListener(this);
		
		return view;
	}

	@Override
	public void onClick(View view) {
		if(activity != null) {
			Intent intent = new Intent(activity.getApplicationContext(), CopyOfCourseDetailActivity.class);
			intent.putExtra(CourseDetailActivity.ARG_COURSE_ID, course.getCourseId());
			activity.startActivity(intent);	
		}
	}

}
