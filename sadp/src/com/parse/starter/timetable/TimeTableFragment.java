package com.parse.starter.timetable;

import com.fima.cardsui.views.CardUI;
import com.parse.starter.R;
import com.parse.starter.model.courses.Course;
import com.parse.starter.model.courses.Day;

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
		
		String[] mockData = getMockData(day);
		for(String s : mockData) {
			// TODO Set actual course data
			cardUi.addCard(new CourseCard(new Course(null, s, null, null)));
		}
		cardUi.refresh();
		
		return root;
	}

	private static String[] getMockData(Day day) {
		switch (day) {
			case Monday:
				return new String[] {"熱力学", "線形代数学入門"};
			case Tuesday:
				return new String[] {"情報検索論"};
			case Wednesday:
				return new String[] {"データベース", "マルチエージェントシステム"};
			case Thursday:
				return new String[] {"微分積分学入門", "コンパイラ", "学生実験4データベース"};
			case Friday:
				return new String[] {"学生実験4データベース"};
		}
		return null;
	}
}
