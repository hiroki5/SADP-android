package com.parse.starter;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.TextView;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.starter.courses.CourseListActivity;

public class ParseStarterProjectActivity extends Activity implements OnClickListener {
	
	// TODO Use xml to generate id in order to avoid corruption of Ids.
	private static final int START_COURSE_LIST_ACTIVITY = 1; 
	
	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState) {
		// TODO Remove unused codes.
		
		super.onCreate(savedInstanceState);
		Log.d("Debug:", "ParseStarterProjectApplication onCreate");
		//setContentView(R.layout.main);
        AbsoluteLayout absoluteLayout = new AbsoluteLayout(this); 
        setContentView(absoluteLayout);
        
        Button button = new Button(this);
        button.setId(START_COURSE_LIST_ACTIVITY);
        button.setText("Start CourseListActivity");
        button.setOnClickListener(this);
        absoluteLayout.addView(button);
        
        Button btn = new Button(this);
        btn.setText("時間割");
        btn.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent(ParseStarterProjectActivity.this, time.class);
        		startActivity(intent);
        	}
        });
        
        absoluteLayout.addView(btn, new AbsoluteLayout.LayoutParams(350,150, 300, 200));
        
        Button btn2 = new Button(this);
        btn2.setText("授業一覧");
        btn2.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent = new Intent(ParseStarterProjectActivity.this, kamoku.class);
        		startActivity(intent);
        	}
        });
        //LayoutParams lp2 = new LayoutParams(200, 100);
        //btn.setGravity(Gravity.TOP, 0, 0);  
        absoluteLayout.addView(btn2, new AbsoluteLayout.LayoutParams(350,150, 300, 500));
        
        /*
		Parse.initialize(this, "MKIBFNmKgL8OL7cujgOPavuViXAkPBG10ubFQq39", "HCQk4oW34fksE4yUZiyJRBV0WaanjtYJhloYdNhc");

		ParseObject testObject = new ParseObject("TestObject");
		testObject.put("foo", "k6");
		testObject.saveInBackground();
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("TestObject");
		//String names=("k5");
		query.whereEqualTo("foo", "k5");
		//query.whereContainedIn("foo", Arrays.asList(names));
		int score = 10000; // ここの値は適切に設定
		try{
			System.out.println("アクセス");
			List<ParseObject> objects = query.find();
			ParseObject object = objects.get(0);
			score = object.getInt("score");
		}catch(Exception e){
			// parseのアクセスに失敗したときの処理
			System.out.println("アクセス失敗");
		}
		
		
        TextView textView = new TextView(getApplicationContext());
        // テキストビューのテキストを設定
        textView.setText(String.valueOf(score));
        //画面に表示
        absoluteLayout.addView(textView);

		ParseAnalytics.trackAppOpened(getIntent());
		*/
		
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
			case START_COURSE_LIST_ACTIVITY:
				Intent intent = new Intent(this, CourseListActivity.class);
				startActivity(intent);
		}
	}
}
