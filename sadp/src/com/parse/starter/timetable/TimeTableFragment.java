package com.parse.starter.timetable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fima.cardsui.views.CardUI;
import com.parse.starter.R;
import com.parse.starter.cards.CourseCard;
import com.parse.starter.dal.TimeTableDAL;
import com.parse.starter.model.courses.Course;
import com.parse.starter.model.courses.CourseDataLoader;
import com.parse.starter.model.courses.Day;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TimeTableFragment extends Fragment {
	
	public static final String ARG_DAY = "ArgDay";
	
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
		
		CardUI cardUi = (CardUI)root.findViewById(R.id.cardUi);
		
		Bundle args = getArguments();
		Day day = (Day) args.getSerializable(ARG_DAY);
		
		// Set dayTextView
		TextView dayTextView = (TextView) root.findViewById(R.id.dayTextView);
		dayTextView.setText(getString(day.getIdOfString()));
		
		Course[] courses = getRegisteredCourses(day);
		for(Course course: courses) {
			cardUi.addCard(new CourseCard(course, getActivity(), false));
		}
		cardUi.refresh();
		
		return root;
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
