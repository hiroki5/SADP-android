package com.parse.starter.courses;

import com.fima.cardsui.views.CardUI;
import com.parse.starter.R;
import com.parse.starter.cards.CourseCard;
import com.parse.starter.cards.Next;
import com.parse.starter.cards.Nextbutton;
import com.parse.starter.cards.RegisterCard;
import com.parse.starter.cards.ReviewCard;
import com.parse.starter.cards.ReviewCard2;
import com.parse.starter.cards.ReviewCard3;
import com.parse.starter.model.courses.Course;
import com.parse.starter.model.courses.CourseDataLoader;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CourseDetailFragment extends Fragment {
	public static final String ARG_COURSE_ID = "ArgCourseId";
	private CardUI cardUi = null;
	
	public CourseDetailFragment newInstance(String courseId) {
		CourseDetailFragment courseDetailFragment = new CourseDetailFragment();
		
		Bundle args = new Bundle();
		args.putString(ARG_COURSE_ID, courseId);
		courseDetailFragment.setArguments(args);
		
		return courseDetailFragment;
	}
	
	public void setCourseId(String courseId) {
		cardUi.clearCards();
		
		Course course = CourseDataLoader.getCourse(courseId, getActivity().getApplicationContext());
		CourseCard courseCard = new CourseCard(course, null, true);
		cardUi.addCard(courseCard);
		
		RegisterCard registerCard = new RegisterCard(course.getCourseId());
		cardUi.addCard(registerCard);
		
		ReviewCard reviewCard = new ReviewCard(course.getCourseId());
		cardUi.addCard(reviewCard);
		
		//Course course2 = CourseDataLoader.getCourse(courseId, getActivity().getApplicationContext());
		//ReviewCard2 ReviewCard2 = new ReviewCard2(course2, null, true);
		//cardUi.addCard(ReviewCard2);
		
		ReviewCard3 reviewCard3 = new ReviewCard3(course.getCourseId());
		cardUi.addCard(reviewCard3);
		
		//Nextbutton nextbutton = new Nextbutton(course.getCourseId());
		//cardUi.addCard(nextbutton);
		
		//Course course3 = CourseDataLoader.getCourse(courseId, getActivity().getApplicationContext());
		Next next = new Next(course, getActivity(), false);
		cardUi.addCard(next);
		
		//CourseCard courseCard2 = new CourseCard(course, getActivity(), false);
		//cardUi.addCard(courseCard2);
		
		cardUi.refresh();
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.course_detail_fragment, container, false);
		
		cardUi = (CardUI) root.findViewById(R.id.cardUi);
		
		return root;
	}
}
