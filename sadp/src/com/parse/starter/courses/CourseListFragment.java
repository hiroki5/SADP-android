package com.parse.starter.courses;

import com.fima.cardsui.views.CardUI;
import com.parse.starter.R;
import com.parse.starter.lecture1;
import com.parse.starter.lecture2;
import com.parse.starter.lecture3;
import com.parse.starter.lecture5;
import com.parse.starter.model.courses.Course;
import com.parse.starter.timetable.CourseCard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class CourseListFragment extends Fragment {
	
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
			CourseCard courseCard = new CourseCard(course.getCourseName());
			
			// TODO This is temporary implementation, onClickHandler should not be hard-coded here.
			if(course.getCourseName().equals("情報システム設計論Ⅰ")) {
				courseCard.setOnClickListener(new TemporaryOnClickListener(new Intent(getActivity(), lecture1.class)));
			} else if(course.getCourseName().equals("情報システム設計論Ⅱ")) {
				courseCard.setOnClickListener(new TemporaryOnClickListener(new Intent(getActivity(), lecture2.class)));	
			} else if(course.getCourseName().equals("情報システム分析論")) {
				courseCard.setOnClickListener(new TemporaryOnClickListener(new Intent(getActivity(), lecture3.class)));	
			} else if(course.getCourseName().equals("情報社会論")) {
				courseCard.setOnClickListener(new TemporaryOnClickListener(new Intent(getActivity(), lecture5.class)));	
			}
			
			cardUi.addCard(courseCard);
		}
		cardUi.refresh();
		
		return root;
	}
	
	private class TemporaryOnClickListener implements OnClickListener {

		private final Intent intent;
		
		public TemporaryOnClickListener(Intent intent) {
			this.intent = intent;
		}

		@Override
		public void onClick(View view) {
			startActivity(this.intent);
		}
		
	}
}
