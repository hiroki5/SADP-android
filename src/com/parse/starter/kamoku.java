package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class kamoku extends Activity {
	@Override
  public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AbsoluteLayout absoluteLayout = new AbsoluteLayout(this); 
		absoluteLayout.setBackgroundColor(Color.BLACK);
		setContentView(absoluteLayout);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        // アイテム
        adapter.add("情報システム設計論Ⅰ");
        adapter.add("情報システム設計論Ⅱ");
        adapter.add("情報社会論");
        ListView listView = new ListView(this);
        // アダプターを設定します
        listView.setAdapter(adapter);
        
        absoluteLayout.addView(listView, new AbsoluteLayout.LayoutParams(200,350, 100, 100));
	
        // リストビューのアイテムがクリックされた時に呼び出されるコールバックリスナーを登録します
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                ListView listView = (ListView) parent;
                // クリックされたアイテムを取得します
                String item = (String) listView.getItemAtPosition(position);
                
                Intent intent1 = new Intent(kamoku.this, query2.class);
                Intent intent2 = new Intent(kamoku.this, lecture1.class);
        		//startActivityForResult(intent, 1);　　
                if(item == "情報システム設計論Ⅱ"){
        		startActivity(intent1);
                }
                else if(item == "情報システム設計論Ⅰ"){
            		startActivity(intent2);
                }
        		//finish();
                
                //Toast.makeText(kamoku.this, item, Toast.LENGTH_LONG).show();
            }
        });
        
        

		Button btn = new Button(this);
        btn.setText("戻る");
        absoluteLayout.addView(btn, new AbsoluteLayout.LayoutParams(150,150, 300, 500));
		
		//Button btn = (Button)findViewById(R.id.button02);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
				}
			});
		/*
		Button btn2 = new Button(this);
        btn2.setText("講義名");
        absoluteLayout.addView(btn2, new AbsoluteLayout.LayoutParams(150,150, 300, 700));
        */
        /*
        btn2.setOnClickListener(new View.OnClickListener() {
        	@Override
        	public void onClick(View v) {
        		Intent intent2 = new Intent(kamoku.this, query2.class);
        		//startActivityForResult(intent, 1);
        		startActivity(intent2);
        		//finish();
        	}
        });
        */
	}
	
}