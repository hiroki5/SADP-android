package com.yaunix.test.sadp.timetable;

import com.yaunix.test.sadp.R;
import com.yaunix.test.sadp.ParseStarterProjectActivity;
import com.yaunix.test.sadp.model.courses.Day;

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

public class TimeTableActivity extends FragmentActivity implements OnPageChangeListener {
	
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
