package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.parse.Parse;
import com.parse.starter.courses.CourseListActivity;
import com.parse.starter.timetable.TimeTableActivity;

public class top extends Activity implements OnClickListener {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.top1);
		Parse.initialize(this, "MKIBFNmKgL8OL7cujgOPavuViXAkPBG10ubFQq39", "HCQk4oW34fksE4yUZiyJRBV0WaanjtYJhloYdNhc");
        
        Button timeTableButton = (Button) findViewById(R.id.button2);
        Button courseListButton = (Button) findViewById(R.id.button3);
        
        timeTableButton.setOnClickListener(this);
        courseListButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId()) {
			case R.id.button2:
				startActivity(new Intent(this, TimeTableActivity.class));
				break;
			case R.id.button3:
        		startActivity(new Intent(this, CourseListActivity.class));
        		break;
		}
	}
}
