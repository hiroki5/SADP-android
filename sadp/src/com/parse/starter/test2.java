package com.parse.starter;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.starter.courses.CourseListActivity;
import com.parse.starter.timetable.TimeTableActivity;
import com.parse.starter.util.LoginUtil;

public class test2 extends Activity implements OnClickListener {
	String bb;
	int flag=0;
	String []a = new String[3];
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.top);
        
		LoginUtil loginUtil = LoginUtil.getLoginUtil();
		
        //Button timeTableButton = (Button) findViewById(R.id.timeTableButton);
        Button courseListButton = (Button) findViewById(R.id.courseListButton);
        courseListButton.setText("ログイン");
        
        Parse.initialize(this, "MKIBFNmKgL8OL7cujgOPavuViXAkPBG10ubFQq39", "HCQk4oW34fksE4yUZiyJRBV0WaanjtYJhloYdNhc");
        ParseQuery<ParseObject> query = ParseQuery.getQuery("code");
	        try{
		        //List<ParseObject> objects2 = query.find();
	        	
	        	query.findInBackground(new FindCallback<ParseObject>() {
	        		  public void done(List<ParseObject> objects2, ParseException e) {
	        			    if (e == null) {
	        			    	for(int j=0;j<3;j++){
	        			        	ParseObject object2 = objects2.get(j);
	        						a[j] = object2.getString("code");
	        			        } 
	        			    } else {
	        			        // Something went wrong.
	        			    }
	        			  }
	        			});
	        	
		        
		        
	     
	        	
		        /*
				ParseObject object2 = objects2.get(0);
				a[0] = object2.getString("code");
				ParseObject object3 = objects2.get(1);
				a[1] = object3.getString("code");
				ParseObject object4 = objects2.get(2);
				a[2] = object4.getString("code");
				*/
	        }catch(Exception e){
			}
        /*
        if(bb.equals("1221")){
         flag=1;
        }
        */
        
        //timeTableButton.setOnClickListener(this);
        courseListButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		final EditText edit = (EditText) findViewById(R.id.edittext1);
        	edit.setHeight(100);
		
		SpannableStringBuilder sp = (SpannableStringBuilder)edit.getText();
        	bb = sp.toString();
		System.out.println(bb);
		for(int i=0;i<3;i++){
			if(bb.equals(a[i])){
        			startActivity(new Intent(this, lecture5t.class));
			}
		}
	}
}
