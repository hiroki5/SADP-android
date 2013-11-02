package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

public class time extends Activity {
	private static final String[] WORDS = {  "月", "火", "水", "木", "金", "情報システム設計論Ⅰ", "","危機管理特論","","","","情報システム設計論Ⅰ","情報社会論","情報システム分析論","情報学展望1","","情報システム設計論Ⅰ","防災情報特論","情報システム設計論2","社会情報学特殊研究","","情報システム分析論","","情報システム設計論Ⅱ","社会情報学特殊研究","","インフォメーションデザイン論","","情報システム設計論Ⅱ","社会情報学特殊研究" };	
	@Override
  public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*
		AbsoluteLayout absoluteLayout = new AbsoluteLayout(this); 
		setContentView(absoluteLayout);

		Button btn = new Button(this);
        btn.setText("�߂�");
        absoluteLayout.addView(btn, new AbsoluteLayout.LayoutParams(150,150, 300, 200));
		
		//Button btn = (Button)findViewById(R.id.button02);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
				}
			});
	    */
		Button btn = (Button) findViewById(R.id.button_id);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
				}
			});
		
		
		GridView gridView = (GridView) findViewById(R.id.gridView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.grid_main, WORDS);
        gridView.setAdapter(adapter);
        
			
		}
		
}