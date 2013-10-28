package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 科目クラス
 * このクラスで科目情報を保有する
 * @author kitabayashi
 *
 */
public class kamoku extends Activity {
	
	/**
	 * onCreateハンドラ
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AbsoluteLayout absoluteLayout = new AbsoluteLayout(this); 
		absoluteLayout.setBackgroundColor(Color.BLACK);
		setContentView(absoluteLayout);
		
		/*
        String[] color = { "Red", "Maroon", "Purple","Olive","Fuchsia" };
		
		CharSequence[] data = new CharSequence[5];
		
		data[0] = Html.fromHtml(("<font color=\"Red\">研究指導科目</font>"));
		data[1] = "社会情報学特殊研究1";
		data[2] = "社会情報学特殊研究2";
		data[3] = "情報システム設計論Ⅰ";
		data[4] = "情報システム設計論Ⅱ";
		
		Spanned s= Html.fromHtml("<font color='#0000ff'>青</font>");
		*/
		
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		//ArrayAdapter<TextView> adapter = new ArrayAdapter<TextView>(this, android.R.layout.simple_list_item_1);
		//ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, data);
		//ArrayAdapter<Spanned> adapter = new ArrayAdapter<Spanned>(this, android.R.layout.simple_list_item_1);
		
		//adapter.add(s);
		// アイテム
		/*
		TextView textView1 = new TextView(this);
        // テキストビューのテキストを設定
        textView1.setText("12345");
        TextView textView2 = new TextView(this);
        // テキストビューのテキストを設定
        textView2.setText("123");
        //adapter.add(textView1);
        //adapter.add(textView2);
        absoluteLayout.addView(textView1);
        ArrayAdapter<TextView> adapter = new ArrayAdapter<TextView>(this, 0);
        adapter.add(textView1);
        */
		
	    adapter.add("◎研究指導科目");
		adapter.add("社会情報学特殊研究1");
        adapter.add("社会情報学特殊研究2");
        adapter.add("◎研究科共通科目");
        adapter.add("情報学展望1");
        adapter.add("情報学展望2");
        adapter.add("情報学展望3");
        adapter.add("情報学展望4");
        adapter.add("情報学展望5");
        adapter.add("計算機科学入門");
        adapter.add("計算科学演習A");
        adapter.add("情報と知財");
        adapter.add("メディア情報処理論");
        adapter.add("イノベーションと情報");
        adapter.add("情報分析管理論");
        adapter.add("情報分析管理論");
        adapter.add("情報分析管理演習");
        adapter.add("情報分析管理演習");
        adapter.add("情報学における社会貢献");
        adapter.add("情報学におけるインターンシップ");
        adapter.add("◎専攻開設科目");
        adapter.add("　－専攻基礎科目");
        adapter.add("情報社会論");
        adapter.add("情報システム設計論Ⅰ");
        adapter.add("情報システム設計論Ⅱ");
        adapter.add("情報システム分析論");
        adapter.add("　－選択演習・セミナー");
        adapter.add("社会情報モデルセミナー");
        adapter.add("社会情報ネットワークセミナー");
        adapter.add("生物圏情報学セミナー");
        adapter.add("防災情報学セミナー1");
        adapter.add("防災情報学セミナー2");
        adapter.add("防災情報学セミナー3");
        adapter.add("医療情報学演習");
        adapter.add("情報教育学セミナー");
        adapter.add("　－専攻専門科目");
        adapter.add("分散情報システム");
        adapter.add("マルチエージェントシステム");
        adapter.add("情報組織化・検索論");
        adapter.add("生物圏情報学");
        adapter.add("防災情報特論");
        adapter.add("危機管理特論");
        adapter.add("医療情報学");
        adapter.add("ビジネス情報論");
        adapter.add("情報教育論");
        adapter.add("情報モデリング論");
        adapter.add("暗号と情報社会");
        adapter.add("サービスモデリング論");
        adapter.add("◎デザイン学科目");
        adapter.add("インフォメーションデザイン論");
        adapter.add("フィールド分析法");
        adapter.add("問題発見型/解決型学習1");
        adapter.add("問題発見型/解決型学習2");
        adapter.add("戦略的コミュニケーションセミナー(日本語)");
        adapter.add("戦略的コミュニケーションセミナー(英語)");
        adapter.add("情報学演習Ⅰ");
        adapter.add("情報学演習Ⅱ");
        adapter.add("◎プロジェクト科目");
        adapter.add("信号処理セミナー");
        adapter.add("計算科学演習B");
        adapter.add("ビッグデータの計算科学");
        
        ListView listView = new ListView(this);
        // アダプターを設定します
        listView.setAdapter(adapter);
        

        
        absoluteLayout.addView(listView, new AbsoluteLayout.LayoutParams(720,750, 0, 0));
	
        // リストビューのアイテムがクリックされた時に呼び出されるコールバックリスナーを登録します
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        	
        	/*
        	@Override
        	public boolean isEnabled(int position) {
        		if (position == 1)
        			return false;
        		else
        			return true;
            }
            */
        	
        	
           // @Override
            public void onItemClick(AdapterView<?> parent, View view,
                    int position, long id) {
                ListView listView = (ListView) parent;
                // クリックされたアイテムを取得します
                String item = (String) listView.getItemAtPosition(position);
                
                Intent intent1 = new Intent(kamoku.this, lecture1.class);
                Intent intent2 = new Intent(kamoku.this, lecture2.class);
                Intent intent3 = new Intent(kamoku.this, lecture3.class);
                Intent intent4 = new Intent(kamoku.this, lecture1.class);
                Intent intent5 = new Intent(kamoku.this, lecture2.class);
                Intent intent6 = new Intent(kamoku.this, lecture3.class);
                Intent intent7 = new Intent(kamoku.this, lecture1.class);
                Intent intent8 = new Intent(kamoku.this, lecture2.class);
                Intent intent9 = new Intent(kamoku.this, lecture3.class);
                Intent intent10 = new Intent(kamoku.this, lecture1.class);
                Intent intent11 = new Intent(kamoku.this, lecture2.class);
                Intent intent12 = new Intent(kamoku.this, lecture3.class);
        		//startActivityForResult(intent, 1);　　
                if(item == "情報システム設計論Ⅰ"){
        		startActivity(intent1);
                }
                else if(item == "情報システム設計論Ⅱ"){
            		startActivity(intent2);
                }
                else if(item == "情報システム分析論"){
            		startActivity(intent3);
                }
                
        		//finish();
                
                //Toast.makeText(kamoku.this, item, Toast.LENGTH_LONG).show();
            }
            
            
        });
        
        
        
        

		Button btn = new Button(this);
        btn.setText("戻る");
        absoluteLayout.addView(btn, new AbsoluteLayout.LayoutParams(150,150, 280, 820));
		
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