package com.parse.starter;

import java.util.List;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;

public class test extends Activity {
	float d;
	String bb;
	@Override
  public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//AbsoluteLayout absoluteLayout = new AbsoluteLayout(this); 
		//setContentView(absoluteLayout);
		setContentView(R.layout.lecture5t);

		Parse.initialize(this, "MKIBFNmKgL8OL7cujgOPavuViXAkPBG10ubFQq39", "HCQk4oW34fksE4yUZiyJRBV0WaanjtYJhloYdNhc");
		
		
		
		
		
		

        TextView textView = new TextView(getApplicationContext());
        
        TextView textView2 = (TextView)findViewById(R.id.textView1);
        textView2.setText("情報社会論");
        
        
        
        TextView textView6 = (TextView)findViewById(R.id.textView7);
        textView6.setText("登録");
        
        
        //RatingBar ratingBar2 = (RatingBar)findViewById(R.id.ratingBar2);
        //ratingBar2.setOnRatingBarChangeListener(null);
        //RatingBar ratingBar2 = (RatingBar)findViewById(R.id.ratingBar2);
        //ratingBar2.setOnRatingBarChangeListener(this);
        
        //ratingBar2.setNumStars(7);
        // レートの変更を可能にする
        //ratingBar2.setIsIndicator(false);
        // レートが加減される時のステップ幅を0.5に設定
        //ratingBar2.setStepSize((float) 0.5);
        // レートの初期値を2.0に設定
        //ratingBar2.setRating((float) 2.0);
        

        final RatingBar ratingbar = (RatingBar) findViewById(R.id.ratingBar2);
        ratingbar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                //Toast.makeText(null, "New Rating: " + rating, Toast.LENGTH_SHORT).show();
            	
            	TextView textView7 = (TextView)findViewById(R.id.textView8);
            	textView7.setText("今のレート：" + ratingBar.getRating() + "/"
                        + ratingBar.getNumStars());
            	
            	d = ratingBar.getRating();
            }
        });
        
        
        
        
        
        
        final EditText edit = (EditText) findViewById(R.id.edittext1);
        edit.setHeight(100);
        final CharSequence str = edit.getText();
        
        SpannableStringBuilder sp = (SpannableStringBuilder)edit.getText();
        
        final CharSequence aa="";
        
        
        Button button = (Button) findViewById(R.id.button);
        button.setText("登録");
        
        button.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                SpannableStringBuilder sp = (SpannableStringBuilder)edit.getText();
                
                bb = sp.toString();
                //Log.v("onCreate", bb);
                ParseObject gameScore = new ParseObject("lecture5");
                gameScore.put("review", bb);
                gameScore.put("score", d);
                gameScore.saveInBackground();
            }
        });
        
        
        Button button1 = (Button) findViewById(R.id.button1);
        button1.setText("テスト");
        
		
        /*
		Button btn = new Button(this);
        btn.setText("戻る");
        //absoluteLayout.addView(btn, new AbsoluteLayout.LayoutParams(150,150, 280, 200));
		
		//Button btn = (Button)findViewById(R.id.button02);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
				}
			});
			*/
		}
	
}