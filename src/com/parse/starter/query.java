package com.parse.starter;

import java.util.Arrays;
import java.util.List;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import com.parse.ParseUser;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class query extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("Debug:", "ParseApplication onCreate");
		// Add your initialization code here
		
		Parse.initialize(this, "MKIBFNmKgL8OL7cujgOPavuViXAkPBG10ubFQq39", "HCQk4oW34fksE4yUZiyJRBV0WaanjtYJhloYdNhc");
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("TestObject");
		//String names=("k5");
		query.whereEqualTo("foo", "k5");
		//query.whereContainedIn("foo", Arrays.asList(names));
		int score = 10000; // �����̒l�͓K�؂ɐݒ�
		try{
			System.out.println("�A�N�Z�X");
			List<ParseObject> objects = query.find();
			ParseObject object = objects.get(0);
			score = object.getInt("score");
		}catch(Exception e){
			// parse�̃A�N�Z�X�Ɏ��s�����Ƃ��̏���
			System.out.println("�A�N�Z�X���s");
		}
		
		
        TextView textView = new TextView(getApplicationContext());
        // �e�L�X�g�r���[�̃e�L�X�g��ݒ�
        textView.setText(String.valueOf(score));
        //��ʂɕ\��
        
        LinearLayout absoluteLayout = new LinearLayout(this); 
        //setContentView(absoluteLayout);
        
        absoluteLayout.addView(textView);
        
        Button btn = new Button(this);
        btn.setText("�߂�");
        absoluteLayout.addView(btn, new AbsoluteLayout.LayoutParams(150,150, 300, 200));
		
        btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				//finish();
			}
        });
			

		//ParseAnalytics.trackAppOpened(getIntent());
	}
	
}