package com.parse.starter.courses;

import com.parse.starter.R;
import com.parse.starter.model.courses.Category;
import com.parse.starter.model.courses.CourseMockData;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

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
		
		final CourseListTabListener tabListener = new CourseListTabListener();
		
		// Load mock data
		// TODO This should be replaced with actual data.
		categories = CourseMockData.getMockData();
		for(Category category : categories) {
			actionBar.addTab(actionBar.newTab().setText(category.getCategoryName()).setTabListener(tabListener));
		}
		
		CourseListFragmentPagerAdapter pagerAdapter = new CourseListFragmentPagerAdapter(getSupportFragmentManager());
		viewPager.setOnPageChangeListener(this);
		viewPager.setAdapter(pagerAdapter);
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
