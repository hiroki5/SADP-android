package com.parse.starter.timetable;

import com.parse.starter.ParseStarterProjectActivity;
import com.parse.starter.R;
import com.parse.starter.top;
import com.parse.starter.courses.CourseListActivity;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class TimeTableActivity extends FragmentActivity implements OnPageChangeListener {
	
	public enum Day {
		Monday(0, R.string.monday),
		Tuesday(1, R.string.tuesday),
		Wednesday(2, R.string.wednesday),
		Thursday(3, R.string.thursday),
		Friday(4, R.string.friday);
		
		private final int position;
		private final int stringId;
		
		private Day(int position, int stringId) {
			this.position = position;
			this.stringId = stringId;
		}
		
		public int getPosition() {
			return this.position;
		}
		
		public int getIdOfString() {
			return this.stringId;
		}
	
		public static Day converToDay(int position) {
			switch (position) {
				case 0:
					return Day.Monday;
				case 1:
					return Day.Tuesday;
				case 2:
					return Day.Wednesday;
				case 3:
					return Day.Thursday;
				case 4:
					return Day.Friday;
			}
			
			return Day.Monday; // Return Monday for error case.
		}
	}
	
	private TimeTableFragmentPagerAdapter pagerAdapter = null;
	private ViewPager viewPager = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time_table_activity);
		
		viewPager = (ViewPager) findViewById(R.id.pager);
		
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayHomeAsUpEnabled(true);

		final TimeTableTabListener tabListener = new TimeTableTabListener();
		addTab(Day.Monday, actionBar, tabListener);
		addTab(Day.Tuesday, actionBar, tabListener);
		addTab(Day.Wednesday, actionBar, tabListener);
		addTab(Day.Thursday, actionBar, tabListener);
		addTab(Day.Friday, actionBar, tabListener);
		
		pagerAdapter = new TimeTableFragmentPagerAdapter(getSupportFragmentManager());
		viewPager.setOnPageChangeListener(this);
		viewPager.setAdapter(pagerAdapter);
		
		Button button1 = (Button) findViewById(R.id.button1);
		Button button2 = (Button) findViewById(R.id.button3);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(TimeTableActivity.this, top.class);
				startActivity(intent);
				}
			});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(TimeTableActivity.this, CourseListActivity.class);
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
	
	private void addTab(Day day, ActionBar actionBar, TabListener tabListener) {
		actionBar.addTab(actionBar.newTab().setText(getString(day.getIdOfString())).setTabListener(tabListener));
	}
	
	private class TimeTableTabListener implements ActionBar.TabListener {
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			viewPager.setCurrentItem(tab.getPosition());
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}}

	@Override
	public void onPageScrollStateChanged(int arg0) { }

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) { }

	@Override
	public void onPageSelected(int position) {
		getActionBar().setSelectedNavigationItem(position);
	}
}
