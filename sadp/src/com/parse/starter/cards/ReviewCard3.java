package com.parse.starter.cards;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fima.cardsui.objects.Card;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.starter.R;
import com.parse.starter.dal.TimeTableDAL;

public class ReviewCard3 extends Card implements OnClickListener {
	
	private final String courseId;
	private TimeTableDAL timeTableDAL = null;
	private LinearLayout notRegisteredLayout = null;
	private LinearLayout registeredLayout = null;
	
	public ReviewCard3(String courseId) {
		this.courseId = courseId;
	}
	
	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.review2_card, null);
		((TextView)view.findViewById(R.id.title)).setText("レビュー");
		
		//timeTableDAL = new TimeTableDAL(context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE));
		
		//registeredLayout = (LinearLayout) view.findViewById(R.id.layoutRegistered);
		//notRegisteredLayout = (LinearLayout) view.findViewById(R.id.layoutNotRegistered);
		
		//updateLayout();
		//((TextView)view.findViewById(R.id.title)).setText("レビュー");
		
        String []a = new String[3];
		
		ParseQuery<ParseObject> query2 = ParseQuery.getQuery(courseId);
		try{
			System.out.println("�A�N�Z�X");
			List<ParseObject> objects2 = query2.find();
			ParseObject object2 = objects2.get(0);
			a[0] = object2.getString("review");
			ParseObject object3 = objects2.get(1);
			a[1] = object3.getString("review");
			ParseObject object4 = objects2.get(2);
			a[2] = object4.getString("review");
			
			TextView[] Review = new TextView[3];
			Review[0] = (TextView) view.findViewById(R.id.description);
	        Review[0].setText("レビュー1："+a[0]);
	        Review[1] = (TextView) view.findViewById(R.id.description2);
	        Review[1].setText("レビュー2："+a[1]);
	        Review[2] = (TextView) view.findViewById(R.id.description3);
	        Review[2].setText("レビュー3："+a[2]);
	        
		}catch(Exception e){
			// parse�̃A�N�Z�X�Ɏ��s�����Ƃ��̏���
			System.out.println("�A�N�Z�X���s");
		}
		
		//Button registerButton = (Button) view.findViewById(R.id.registerCourseButton);
		//registerButton.setOnClickListener(this);
		//Button unRegisterButton = (Button) view.findViewById(R.id.unRegisterCourseButton);
		//unRegisterButton.setOnClickListener(this);
		
		return view;
	}

	private void updateLayout() {
		if(timeTableDAL.isRegistered(courseId)) {
			notRegisteredLayout.setVisibility(View.GONE);
			registeredLayout.setVisibility(View.VISIBLE);
		} else {
			notRegisteredLayout.setVisibility(View.VISIBLE);
			registeredLayout.setVisibility(View.GONE);
		}
	}
	
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.registerCourseButton:
			timeTableDAL.register(courseId);
			updateLayout();	
			break;
		case R.id.unRegisterCourseButton:
			timeTableDAL.unRegister(courseId);
			updateLayout();	
			break;
		}
		
	}
}
