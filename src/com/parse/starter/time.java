package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;

public class time extends Activity {
	@Override
  public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AbsoluteLayout absoluteLayout = new AbsoluteLayout(this); 
		setContentView(absoluteLayout);

		Button btn = new Button(this);
        btn.setText("–ß‚é");
        absoluteLayout.addView(btn, new AbsoluteLayout.LayoutParams(150,150, 300, 200));
		
		//Button btn = (Button)findViewById(R.id.button02);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
				}
			});
		}
	
}