package com.yaunix.test.sadp.cards;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fima.cardsui.objects.Card;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.yaunix.test.sadp.R;
import com.yaunix.test.sadp.lecture5t;
import com.yaunix.test.sadp.top;
import com.yaunix.test.sadp.courses.CopyOfCourseDetailActivity;
import com.yaunix.test.sadp.courses.CourseDetailActivity;
import com.yaunix.test.sadp.courses.CourseDetailFragment;
import com.yaunix.test.sadp.courses.CourseListActivity;
import com.yaunix.test.sadp.model.courses.Course;

public class Next extends Card implements OnClickListener {
	
	private final Course course;
	private final boolean showFullDescription;
	private final Activity activity;
	String []a = new String[3];
	String bb;
	Button button1;
	String c="22";
	
	public Next(Course course, Activity activity, boolean showFullDescription) {
		super(course.getCourseName());
		
		this.course = course;
		this.activity = activity;
		this.showFullDescription = showFullDescription;
	}
	
	@Override
	public View getCardContent(Context context) {
		
		final View view = LayoutInflater.from(context).inflate(R.layout.next, null);
		/*
		((TextView)view.findViewById(R.id.title)).setText(title);
		
		TextView descriptionTextView = (TextView)view.findViewById(R.id.description);
		descriptionTextView.setText(course.getDescription());
		if(showFullDescription) {
			descriptionTextView.setMaxLines(Integer.MAX_VALUE);
		}
		*/
		
		TextView text1 = (TextView) view.findViewById(R.id.textView1);
		text1.setText("この講義に対するレビューを登録するには認証コードを入力してください");
		
		Button button1 = (Button) view.findViewById(R.id.button1);
        button1.setText("レビューを登録する");
        
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
             }catch(Exception e){
		     }
        
        //button1.setOnClickListener(this);
        
        final EditText edit = (EditText) view.findViewById(R.id.edittext1);
    	edit.setHeight(100);
	
	   // SpannableStringBuilder sp = (SpannableStringBuilder)edit.getText();
    	//bb = sp.toString();
	    
    	final TextView text2 = (TextView) view.findViewById(R.id.textView2);
    	
    	button1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	
                SpannableStringBuilder sp = (SpannableStringBuilder)edit.getText();
                bb = sp.toString();
                for(int i=0;i<3;i++){
    				if(bb.equals(a[i])){
                Intent intent = new Intent(activity.getApplicationContext(), CopyOfCourseDetailActivity.class);
				intent.putExtra(CourseDetailActivity.ARG_COURSE_ID, course.getCourseId());
				activity.startActivity(intent);	
    				}
    				else{
    	        		text2.setText("認証コードが違います");
    				}
                }
            }
        });
		
		return view;
	}
	
	public void onCreate(Bundle savedInstanceState) {	
		
	}

	@Override
	public void onClick(View view) {
		
		/*
		if(activity != null) {
			Intent intent = new Intent(activity.getApplicationContext(), CopyOfCourseDetailActivity.class);
			intent.putExtra(CourseDetailActivity.ARG_COURSE_ID, course.getCourseId());
			activity.startActivity(intent);	
		}
		*/
		
		//if(activity != null) {
			
			//
			//System.out.println(bb);
			//TextView Review = (TextView) view.findViewById(R.id.textView1);
			//Review.setText(c);
			
		    //for(int i=0;i<3;i++){
				//if(bb.equals(a[i])){
		    			//startActivity(new Intent(this, lecture5t.class));
					//Intent intent = new Intent(activity.getApplicationContext(), CopyOfCourseDetailActivity.class);
					//intent.putExtra(CourseDetailActivity.ARG_COURSE_ID, course.getCourseId());
					//activity.startActivity(intent);	
				//}
		    //}
		    //}
		     
	}

}
