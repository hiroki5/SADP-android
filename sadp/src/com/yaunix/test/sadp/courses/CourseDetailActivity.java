package com.yaunix.test.sadp.courses;

import com.yaunix.test.sadp.R;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;

public class CourseDetailActivity extends FragmentActivity {
	public static final String ARG_COURSE_ID = "ArgCourseId";
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.course_detail_activity);
		
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
