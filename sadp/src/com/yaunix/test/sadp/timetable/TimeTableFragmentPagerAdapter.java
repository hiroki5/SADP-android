package com.yaunix.test.sadp.timetable;

import com.yaunix.test.sadp.model.courses.Day;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TimeTableFragmentPagerAdapter extends FragmentPagerAdapter {

	private static final int numOfDays = 5;
	
	public TimeTableFragmentPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	
	@Override
	public Fragment getItem(int position) {
		return TimeTableFragment.newInstance(Day.converToDay(position));
	}
	
	@Override
	public int getCount() {
		return numOfDays;
	}
}
