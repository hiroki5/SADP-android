package com.parse.starter.courses;

import com.fima.cardsui.views.CardUI;
import com.parse.starter.R;
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
			CourseCard courseCard = new CourseCard(course);
			courseCard.setOnClickListener(new CardOnClickListener(course.getCourseId()));
			cardUi.addCard(courseCard);
		}
		cardUi.refresh();
		
		return root;
	}
	
	private class CardOnClickListener implements OnClickListener {

		private final String courseId;
		
		public CardOnClickListener(String courseId) {
			this.courseId = courseId;
		}

		@Override
		public void onClick(View view) {
			Intent intent = new Intent(getActivity().getApplicationContext(), CourseDetailActivity.class);
			intent.putExtra(CourseDetailActivity.ARG_COURSE_ID, courseId);
			startActivity(intent);
		}
	}
}
