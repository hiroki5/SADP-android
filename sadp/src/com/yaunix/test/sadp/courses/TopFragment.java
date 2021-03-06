package com.yaunix.test.sadp.courses;

import com.fima.cardsui.views.CardUI;
import com.yaunix.test.sadp.R;
import com.yaunix.test.sadp.cards.CourseCard;
import com.yaunix.test.sadp.model.courses.Course;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TopFragment extends Fragment {
	
	public static final String ARG_COURSES = "ArgCourses";
	
	static CourseListFragment newInstance(Course[] courses) {
		CourseListFragment courseListFragment = new CourseListFragment();
		
		Bundle args = new Bundle();
		args.putSerializable(ARG_COURSES, courses);
		courseListFragment.setArguments(args);
		
		return courseListFragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.course_list_fragment, container, false);
		
		Bundle args = getArguments();
		Course[] courses = (Course[]) args.getSerializable(ARG_COURSES);
		
		CardUI cardUi = (CardUI) root.findViewById(R.id.cardUi);
		for(Course course : courses) {
			CourseCard courseCard = new CourseCard(course, getActivity(), false);
			cardUi.addCard(courseCard);
		}
		cardUi.refresh();
		
		return root;
	}
}
