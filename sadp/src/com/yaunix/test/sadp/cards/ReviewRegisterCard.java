package com.yaunix.test.sadp.cards;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.RatingBar.OnRatingBarChangeListener;

import com.fima.cardsui.objects.Card;
import com.parse.ParseObject;
import com.yaunix.test.sadp.R;
import com.yaunix.test.sadp.dal.TimeTableDAL;

public class ReviewRegisterCard extends Card implements OnClickListener {
	
	private final String courseId;
	private TimeTableDAL timeTableDAL = null;
	private LinearLayout notRegisteredLayout = null;
	private LinearLayout registeredLayout = null;
	float d;
	String bb;
	//EditText edit;
	
	
	public ReviewRegisterCard(String courseId) {
		this.courseId = courseId;
	}
	
	@Override
	public View getCardContent(Context context) {
		final View view = LayoutInflater.from(context).inflate(R.layout.reviewregister_card, null);
		
		timeTableDAL = new TimeTableDAL(context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE));
		
		registeredLayout = (LinearLayout) view.findViewById(R.id.layoutRegistered);
		notRegisteredLayout = (LinearLayout) view.findViewById(R.id.layoutNotRegistered);
		
		updateLayout();
		
		//Button registerButton = (Button) view.findViewById(R.id.registerCourseButton);
		//registerButton.setOnClickListener(this);
		//Button unRegisterButton = (Button) view.findViewById(R.id.unRegisterCourseButton);
		//unRegisterButton.setOnClickListener(this);
		
		
		
		RatingBar ratingbar = (RatingBar) view.findViewById(R.id.ratingBar1);
		ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            	
            	/*
            	TextView textView7 = (TextView) view.findViewById(R.id.textView1);
            	textView7.setText("今のレート：" + ratingBar.getRating() + "/"
                        + ratingBar.getNumStars());
                        */
            	
            	d = ratingBar.getRating();
            }
        });
		
		final EditText edit = (EditText) view.findViewById(R.id.edittext1);
        edit.setHeight(100);
		
        Button button = (Button) view.findViewById(R.id.button1);
        button.setText("登録");
        
        //button.setOnClickListener(this);
        
        final TextView text1 = (TextView) view.findViewById(R.id.textView2);
        
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	text1.setText("登録しました");
                SpannableStringBuilder sp = (SpannableStringBuilder)edit.getText();
                bb = sp.toString();
                ParseObject gameScore = new ParseObject(courseId);
                gameScore.put("review", bb);
                gameScore.put("score", d);
                gameScore.saveInBackground();
            }
        });
        
        
        
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
		/*
		SpannableStringBuilder sp = (SpannableStringBuilder)edit.getText();
        bb = sp.toString();
        ParseObject gameScore = new ParseObject("lecture5");
        gameScore.put("review", bb);
        gameScore.put("score", d);
        gameScore.saveInBackground();
        */
		/*
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
		*/
	}
}
