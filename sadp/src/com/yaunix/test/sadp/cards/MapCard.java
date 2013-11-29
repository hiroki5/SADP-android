package com.yaunix.test.sadp.cards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.fima.cardsui.objects.Card;
import com.yaunix.test.sadp.R;

public class MapCard extends Card {

	@Override
	public View getCardContent(Context context) {
		// TODO This is a mock implementation.
		View view = LayoutInflater.from(context).inflate(R.layout.map_card, null);
		
		ImageView mapImageView = (ImageView) view.findViewById(R.id.mapImageView);
		mapImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.building_7));
		
		return view;
	}

}
