package com.parse.starter;

import java.util.List;

import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;

public class lecture5 extends Activity {
	
	@Override
  public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//AbsoluteLayout absoluteLayout = new AbsoluteLayout(this); 
		//setContentView(absoluteLayout);
		setContentView(R.layout.lecture5);

		Parse.initialize(this, "MKIBFNmKgL8OL7cujgOPavuViXAkPBG10ubFQq39", "HCQk4oW34fksE4yUZiyJRBV0WaanjtYJhloYdNhc");
		
		/*
		ParseQuery<ParseObject> query = ParseQuery.getQuery("TestObject");
		//String names=("k5");
		query.whereEqualTo("foo", "k5");
		//query.whereContainsAll("foo", "k5");
		//query.whereContainedIn("foo", Arrays.asList(names));
		int score = 10000; // �����̒l�͓K�؂ɐݒ�
		try{
			System.out.println("�A�N�Z�X");
			List<ParseObject> objects = query.find();
			ParseObject object = objects.get(0);
			//ParseObject post = object.getParseObject("post");
			score = object.getInt("score");
		}catch(Exception e){
			// parse�̃A�N�Z�X�Ɏ��s�����Ƃ��̏���
			System.out.println("�A�N�Z�X���s");
		}
		*/
		
		//String[] b = null;
		String b;
		String []a = new String[2];
		
		ParseQuery<ParseObject> query2 = ParseQuery.getQuery("lecture5");
		try{
			System.out.println("�A�N�Z�X");
			List<ParseObject> objects2 = query2.find();
			ParseObject object2 = objects2.get(0);
			a[0] = object2.getString("review");
			ParseObject object3 = objects2.get(1);
			a[1] = object3.getString("review");
			
			TextView[] Review = new TextView[3];
			Review[0] = (TextView)findViewById(R.id.textView5);
	        Review[0].setText("レビュー1："+a[0]);
	        Review[1] = (TextView)findViewById(R.id.textView6);
	        Review[1].setText("レビュー2："+a[1]);
		}catch(Exception e){
			// parse�̃A�N�Z�X�Ɏ��s�����Ƃ��̏���
			System.out.println("�A�N�Z�X���s");
		}
		
		
		//ParseQuery<ParseObject> query2 = ParseQuery.getQuery("lecture5");
		//query.whereEqualTo("foo", "情報社会論");
		//[query2 whereKey:@"playerName" equalTo:@"Dan Stemkoski"];
		
		//TextView textView6 = (TextView)findViewById(R.id.textView5);
        //textView6.setText(b[1]);
		

        TextView textView = new TextView(getApplicationContext());
        // �e�L�X�g�r���[�̃e�L�X�g��ݒ�
        //textView.setText(String.valueOf(score));
        //��ʂɕ\��
        //absoluteLayout.addView(textView);
        
        //TextView textView2 = new TextView(getApplicationContext());
        // �e�L�X�g�r���[�̃e�L�X�g��ݒ�
        //textView2.setText("情報システム設計論Ⅱ");
        //��ʂɕ\��
        //absoluteLayout.addView(textView2);
        
        TextView textView2 = (TextView)findViewById(R.id.textView1);
        textView2.setText("情報社会論");
        
        TextView textView3 = (TextView)findViewById(R.id.textView2);
        textView3.setText("情報政策、情報と法制度、情報と経済、情報倫理、情報と教育など、情報技術の社会へのインパクトや社会との関わりについて論述する。これにより、受講者は、情報技術の歴史と動向、情報化社会の問題点、情報技術による社会革命、プライバシーとセキュリティ、情報政策、知的財産権、専門家の論理と責任など、情報技術と社会のかかわりについて、多角的に学習する。");
        
        TextView textView4 = (TextView)findViewById(R.id.textView3);
        textView4.setText("評価");
        
        TextView textView5 = (TextView)findViewById(R.id.textView4);
        textView5.setText("レビュー");
        
        RatingBar ratingBar = (RatingBar)findViewById(R.id.ratingBar1);
        ratingBar.setNumStars(5);
        ratingBar.setRating(3);
        ratingBar.setIsIndicator(true);
        
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
            }
        });
        
        Button button = (Button) findViewById(R.id.button);
        button.setText("登録");
        
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
		}
	
}