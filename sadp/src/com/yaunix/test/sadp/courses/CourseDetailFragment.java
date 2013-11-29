package com.yaunix.test.sadp.courses;

import com.fima.cardsui.views.CardUI;
import com.yaunix.test.sadp.R;
import com.yaunix.test.sadp.cards.CourseCard;
import com.yaunix.test.sadp.cards.MapCard;
import com.yaunix.test.sadp.cards.Next;
import com.yaunix.test.sadp.cards.RegisterCard;
import com.yaunix.test.sadp.cards.ReviewCard;
import com.yaunix.test.sadp.cards.ReviewCard3;
import com.yaunix.test.sadp.model.courses.Course;
import com.yaunix.test.sadp.model.courses.CourseDataLoader;

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
		
		MapCard mapCard = new MapCard();
		cardUi.addCard(mapCard);
		
		ReviewCard reviewCard = new ReviewCard(course.getCourseId());
		cardUi.addCard(reviewCard);
		
		ReviewCard3 reviewCard3 = new ReviewCard3(course.getCourseId());
		cardUi.addCard(reviewCard3);
		
		Next next = new Next(course, getActivity(), false);
		cardUi.addCard(next);
		
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
