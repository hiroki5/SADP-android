package com.yaunix.test.sadp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.parse.Parse;
import com.yaunix.test.sadp.R;
import com.yaunix.test.sadp.courses.CourseListActivity;
import com.yaunix.test.sadp.timetable.TimeTableActivity;

public class top extends Activity implements OnClickListener {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.top1);
		Parse.initialize(this, "MKIBFNmKgL8OL7cujgOPavuViXAkPBG10ubFQq39", "HCQk4oW34fksE4yUZiyJRBV0WaanjtYJhloYdNhc");
        
        Button timeTableButton = (Button) findViewById(R.id.button2);
        Button courseListButton = (Button) findViewById(R.id.button3);
        
        timeTableButton.setOnClickListener(this);
        courseListButton.setOnClickListener(this);
        
        //View root = inflater.inflate(R.layout.course_list_fragment, container, false);
        /*
        CardUI cardUi = (CardUI) findViewById(R.id.cardUi);
        
	    CourseCard courseCard = new CourseCard(null, this, false);
	    
	    cardUi.addCard(courseCard);
	    
	    cardUi.refresh();
	    */
			
        
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
