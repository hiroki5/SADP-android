package com.yaunix.test.sadp;

import java.util.Arrays;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import com.parse.ParseUser;

import android.app.Application;
import android.util.Log;
import android.widget.AbsoluteLayout;
import android.widget.TextView;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("Debug:", "ParseApplication onCreate");
		// Add your initialization code here
		Parse.initialize(this, "MKIBFNmKgL8OL7cujgOPavuViXAkPBG10ubFQq39", "HCQk4oW34fksE4yUZiyJRBV0WaanjtYJhloYdNhc");

		ParseObject testObject = new ParseObject("TestObject");
		testObject.put("foo", "k6");
		testObject.saveInBackground();
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("TestObject");
		String names=("k5");
		query.whereContainedIn("foo", Arrays.asList(names));
		
		AbsoluteLayout absoluteLayout = new AbsoluteLayout(this); 
        //setContentView(absoluteLayout);
        TextView textView = new TextView(getApplicationContext());
        // �e�L�X�g�r���[�̃e�L�X�g��ݒ�
        textView.setText(names);
        //��ʂɕ\��
        absoluteLayout.addView(textView);
		
		
		ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		// defaultACL.setPublicReadAccess(true);
		ParseACL.setDefaultACL(defaultACL, true);

		System.out.print("Hello, Java!");
	}
	

}
