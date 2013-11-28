package com.parse.starter.courses;

import com.parse.starter.R;
import com.parse.starter.top;
import com.parse.starter.timetable.TimeTableActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class CourseDetailActivity extends FragmentActivity {
	public static final String ARG_COURSE_ID = "ArgCourseId";
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.course_detail_activity);
		
		Button button1 = (Button) findViewById(R.id.button1);
		Button button2 = (Button) findViewById(R.id.button2);
		Button button3 = (Button) findViewById(R.id.button3);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CourseDetailActivity.this, top.class);
				startActivity(intent);
				}
			});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CourseDetailActivity.this, TimeTableActivity.class);
				startActivity(intent);
				}
			});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CourseDetailActivity.this, CourseListActivity.class);
				startActivity(intent);
				}
			});
		
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		String courseId = getIntent().getStringExtra(ARG_COURSE_ID);
		CourseDetailFragment fragment = (CourseDetailFragment) getSupportFragmentManager().findFragmentById(R.id.courseDetailFragment);
		
		fragment.setCourseId(courseId);
		
		
		
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
}
