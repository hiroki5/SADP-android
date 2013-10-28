package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;

public class time extends Activity {
	private static final String[] WORDS = { "��", "��", "��", "��", "��", "���V�X�e���݌v�_�T", "","��@�Ǘ����_","","","","���V�X�e���݌v�_�T","���Љ�_","���V�X�e�����͘_","���w�W�]1","","���V�X�e���݌v�_�T","�h�Џ����_","���V�X�e���݌v�_2","�Љ���w���ꌤ��","","���V�X�e�����͘_","","���V�X�e���݌v�_�U","�Љ���w���ꌤ��","","�C���t�H���[�V�����f�U�C���_","","���V�X�e���݌v�_�U","�Љ���w���ꌤ��" };
	
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