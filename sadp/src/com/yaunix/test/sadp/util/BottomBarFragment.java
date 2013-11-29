package com.yaunix.test.sadp.util;

import com.yaunix.test.sadp.ParseStarterProjectActivity;
import com.yaunix.test.sadp.R;
import com.yaunix.test.sadp.courses.CourseListActivity;
import com.yaunix.test.sadp.timetable.TimeTableActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class BottomBarFragment extends Fragment implements OnClickListener {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.bottom_bar_fragment, container, false);
		
		ImageButton topButton = (ImageButton) root.findViewById(R.id.topButton);
		ImageButton timeTableButton = (ImageButton) root.findViewById(R.id.timeTableButton);
		ImageButton courseListButton = (ImageButton) root.findViewById(R.id.courseListButton);
		
		topButton.setOnClickListener(this);
		timeTableButton.setOnClickListener(this);
		courseListButton.setOnClickListener(this);
		
		return root;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.topButton:
			Intent top = new Intent(getActivity().getApplicationContext(), ParseStarterProjectActivity.class);
			startActivity(top);
			break;
		case R.id.timeTableButton:
			Intent timeTable = new Intent(getActivity().getApplicationContext(), TimeTableActivity.class);
			startActivity(timeTable);
			break;
		case R.id.courseListButton:
			Intent courseList = new Intent(getActivity().getApplicationContext(), CourseListActivity.class);
			startActivity(courseList);
			break;
		}
	}
	
}
