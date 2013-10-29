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
import android.widget.TextView;

public class lecture2 extends Activity {
	@Override
  public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AbsoluteLayout absoluteLayout = new AbsoluteLayout(this); 
		setContentView(absoluteLayout);

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
        absoluteLayout.addView(textView);
        
        TextView textView2 = new TextView(getApplicationContext());
        // �e�L�X�g�r���[�̃e�L�X�g��ݒ�
        textView2.setText("情報システム設計論Ⅱ");
        //��ʂɕ\��
        absoluteLayout.addView(textView2);
		
		Button btn = new Button(this);
        btn.setText("戻る");
        absoluteLayout.addView(btn, new AbsoluteLayout.LayoutParams(150,150, 280, 200));
		
		//Button btn = (Button)findViewById(R.id.button02);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
				}
			});
		}
	
}