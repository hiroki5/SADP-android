package com.yaunix.test.sadp.cards;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RatingBar;

import com.fima.cardsui.objects.Card;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.yaunix.test.sadp.R;

/**
 * Review card is a card to show rating score of the course.
 */
public class ReviewCard extends Card {
	
	private static final String TAG = "ReviewCard";
	
	private final String courseId;
	
	public ReviewCard(String courseId) {
		this.courseId = courseId;
	}
	
	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.review_card, null);
		
		// TODO Change this model. This model requires same number of models as the number of courses.
		ParseQuery<ParseObject> query = ParseQuery.getQuery(courseId);
		query.orderByDescending("createdAt");
		
		try{
			List<ParseObject> courseReviews = query.find();
			int total = 0;
			for(ParseObject courseReview : courseReviews) {
				// TODO Move the string score to constant variable. 
				total += courseReview.getInt("score");
			}
			float score = (float)total / (float)courseReviews.size();
			
			RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingBar1);
	        ratingBar.setRating(score);
		}catch(Exception e){
			Log.e(TAG, "Caught an exception while calculating review score. " + e.toString());
		}
		
		return view;
	}
}
