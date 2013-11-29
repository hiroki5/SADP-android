package com.yaunix.test.sadp.courses;

import com.yaunix.test.sadp.R;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.yaunix.test.sadp.ParseStarterProjectActivity;
import com.yaunix.test.sadp.top;
import com.yaunix.test.sadp.courses.CourseListActivity;
import com.yaunix.test.sadp.model.courses.Category;
import com.yaunix.test.sadp.model.courses.CourseDataLoader;
import com.yaunix.test.sadp.timetable.TimeTableActivity;

public class CourseListActivity extends FragmentActivity implements OnPageChangeListener {
	
	private Category[] categories = null;
	private ViewPager viewPager = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.course_list_activity);
		
		viewPager = (ViewPager) findViewById(R.id.pager);

		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayHomeAsUpEnabled(true);
		
		final CourseListTabListener tabListener = new CourseListTabListener();
		
		// Load data
		categories = CourseDataLoader.loadCourses(getApplicationContext());
		for(Category category : categories) {
			actionBar.addTab(actionBar.newTab().setText(category.getCategoryName()).setTabListener(tabListener));
		}
		
		CourseListFragmentPagerAdapter pagerAdapter = new CourseListFragmentPagerAdapter(getSupportFragmentManager());
		viewPager.setOnPageChangeListener(this);
		viewPager.setAdapter(pagerAdapter);
		
		Button button1 = (Button) findViewById(R.id.button1);
		Button button2 = (Button) findViewById(R.id.button2);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CourseListActivity.this, top.class);
				startActivity(intent);
				}
			});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CourseListActivity.this, TimeTableActivity.class);
				startActivity(intent);
				}
			});
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent(this, ParseStarterProjectActivity.class);
			startActivity(intent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	private class CourseListTabListener implements ActionBar.TabListener {
		
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) { }

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			viewPager.setCurrentItem(tab.getPosition());
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) { }
	}
	
	private class CourseListFragmentPagerAdapter extends FragmentPagerAdapter {

		public CourseListFragmentPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Category category = categories[position];
			return CourseListFragment.newInstance(category.getCourses());
		}

		@Override
		public int getCount() {
			return categories.length;
		}
	}

	@Override
	public void onPageScrollStateChanged(int arg0) { }

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) { }

	@Override
	public void onPageSelected(int position) {
		getActionBar().setSelectedNavigationItem(position);
	}
	
}
