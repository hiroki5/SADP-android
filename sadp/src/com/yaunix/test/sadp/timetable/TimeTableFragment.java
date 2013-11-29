package com.yaunix.test.sadp.timetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fima.cardsui.views.CardUI;
import com.yaunix.test.sadp.R;
import com.yaunix.test.sadp.cards.CourseCard;
import com.yaunix.test.sadp.dal.TimeTableDAL;
import com.yaunix.test.sadp.model.courses.Course;
import com.yaunix.test.sadp.model.courses.CourseDataLoader;
import com.yaunix.test.sadp.model.courses.Day;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TimeTableFragment extends Fragment {
	
	public static final String ARG_DAY = "ArgDay";
	private CardUI cardUi = null;
	private Day day = null;
	
	static TimeTableFragment newInstance(Day day) {
		TimeTableFragment timeTableFragment = new TimeTableFragment();
		
		Bundle args = new Bundle();
		args.putSerializable(ARG_DAY, day);
		timeTableFragment.setArguments(args);
		
		return timeTableFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.time_table_fragment, container, false);
		
		cardUi = (CardUI)root.findViewById(R.id.cardUi);
		
		Bundle args = getArguments();
		day = (Day) args.getSerializable(ARG_DAY);
		
		return root;
	}
	
	@Override
	public void onResume() {
		super.onResume();
		
		cardUi.clearCards();
		
		Course[] courses = getRegisteredCourses(day);
		for(Course course: courses) {
			cardUi.addCard(new CourseCard(course, getActivity(), false));
		}
		
		cardUi.refresh();
	}
	
	private Course[] getRegisteredCourses(Day day) {
		TimeTableDAL timeTableDAL = new TimeTableDAL(getActivity().getSharedPreferences(getString(R.string.preference_file_key), Context.MODE_PRIVATE));
		
		List<Course> courses = new ArrayList<Course>();
		
		Set<String> courseIds = timeTableDAL.getRegisteredCourses();
		for(String courseId : courseIds) {
			Course course = CourseDataLoader.getCourse(courseId, getActivity().getApplicationContext());
			if(course.getDay().equals(day)) {
				courses.add(course);
			}
		}
		
		return courses.toArray(new Course[courses.size()]);
	}
}
