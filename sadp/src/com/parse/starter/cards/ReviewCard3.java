package com.parse.starter.cards;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fima.cardsui.objects.Card;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.starter.R;

/**
 * Review card is a card to show review statements of the course
 */
public class ReviewCard3 extends Card {

	private static final String TAG = "ReviewCard3";
	private final String courseId;
	
	public ReviewCard3(String courseId) {
		this.courseId = courseId;
	}
	
	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.review2_card, null);
		
		// TODO Change this model. This model requires same number of models as the number of courses.
        // Same comment on ReviewCard.java
		ParseQuery<ParseObject> query = ParseQuery.getQuery(courseId);
		query.orderByDescending("createdAt");
		
		try{
			LinearLayout reviewsLayout = (LinearLayout) view.findViewById(R.id.reviews_layout);
			List<ParseObject> courseReviews = query.find();
			for(ParseObject courseReview : courseReviews) {
				View reviewStatement = LayoutInflater.from(context).inflate(R.layout.review_statement, null);
				
				TextView textView = (TextView) reviewStatement.findViewById(R.id.review_text_view);
				// TODO Make the string "review" to a constant variable.
				textView.setText(courseReview.getString("review"));
				
				reviewsLayout.addView(reviewStatement);
			}
		}catch(Exception e){
			Log.e(TAG, "Caught an exception while calculating review score. " + e.toString());
		}
		
		return view;
	}
}
