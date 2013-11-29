package com.yaunix.test.sadp.timetable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.fima.cardsui.objects.Card;
import com.yaunix.test.sadp.R;

public class DayCard extends Card {

	private final String day;
	
	public DayCard(String day) {
		this.day = day;
	}
	
	@Override
	public View getCardContent(Context context) {
		View view = LayoutInflater.from(context).inflate(R.layout.day_card, null);
		
		((TextView) view.findViewById(R.id.dayTextView)).setText(day);
		
		return view;
	}

}
