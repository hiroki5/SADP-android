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
 * �ȖڃN���X
 * ���̃N���X�ŉȖڏ���ۗL����
 * @author kitabayashi
 *
 */
public class kamoku extends Activity {
	
	/**
	 * onCreate�n���h��
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
		
		data[0] = Html.fromHtml(("<font color=\"Red\">�����w���Ȗ�</font>"));
		data[1] = "�Љ���w���ꌤ��1";
		data[2] = "�Љ���w���ꌤ��2";
		data[3] = "���V�X�e���݌v�_�T";
		data[4] = "���V�X�e���݌v�_�U";
		
		Spanned s= Html.fromHtml("<font color='#0000ff'>��</font>");
		*/
		
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
		//ArrayAdapter<TextView> adapter = new ArrayAdapter<TextView>(this, android.R.layout.simple_list_item_1);
		//ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, data);
		//ArrayAdapter<Spanned> adapter = new ArrayAdapter<Spanned>(this, android.R.layout.simple_list_item_1);
		
		//adapter.add(s);
		// �A�C�e��
		/*
		TextView textView1 = new TextView(this);
        // �e�L�X�g�r���[�̃e�L�X�g��ݒ�
        textView1.setText("12345");
        TextView textView2 = new TextView(this);
        // �e�L�X�g�r���[�̃e�L�X�g��ݒ�
        textView2.setText("123");
        //adapter.add(textView1);
        //adapter.add(textView2);
        absoluteLayout.addView(textView1);
        ArrayAdapter<TextView> adapter = new ArrayAdapter<TextView>(this, 0);
        adapter.add(textView1);
        */
		
	    adapter.add("�������w���Ȗ�");
		adapter.add("�Љ���w���ꌤ��1");
        adapter.add("�Љ���w���ꌤ��2");
        adapter.add("�������ȋ��ʉȖ�");
        adapter.add("���w�W�]1");
        adapter.add("���w�W�]2");
        adapter.add("���w�W�]3");
        adapter.add("���w�W�]4");
        adapter.add("���w�W�]5");
        adapter.add("�v�Z�@�Ȋw����");
        adapter.add("�v�Z�Ȋw���KA");
        adapter.add("���ƒm��");
        adapter.add("���f�B�A��񏈗��_");
        adapter.add("�C�m�x�[�V�����Ə��");
        adapter.add("��񕪐͊Ǘ��_");
        adapter.add("��񕪐͊Ǘ��_");
        adapter.add("��񕪐͊Ǘ����K");
        adapter.add("��񕪐͊Ǘ����K");
        adapter.add("���w�ɂ�����Љ�v��");
        adapter.add("���w�ɂ�����C���^�[���V�b�v");
        adapter.add("����U�J�݉Ȗ�");
        adapter.add("�@�|��U��b�Ȗ�");
        adapter.add("���Љ�_");
        adapter.add("���V�X�e���݌v�_�T");
        adapter.add("���V�X�e���݌v�_�U");
        adapter.add("���V�X�e�����͘_");
        adapter.add("�@�|�I�����K�E�Z�~�i�[");
        adapter.add("�Љ��񃂃f���Z�~�i�[");
        adapter.add("�Љ���l�b�g���[�N�Z�~�i�[");
        adapter.add("���������w�Z�~�i�[");
        adapter.add("�h�Џ��w�Z�~�i�[1");
        adapter.add("�h�Џ��w�Z�~�i�[2");
        adapter.add("�h�Џ��w�Z�~�i�[3");
        adapter.add("��Ï��w���K");
        adapter.add("��񋳈�w�Z�~�i�[");
        adapter.add("�@�|��U���Ȗ�");
        adapter.add("���U���V�X�e��");
        adapter.add("�}���`�G�[�W�F���g�V�X�e��");
        adapter.add("���g�D���E�����_");
        adapter.add("���������w");
        adapter.add("�h�Џ����_");
        adapter.add("��@�Ǘ����_");
        adapter.add("��Ï��w");
        adapter.add("�r�W�l�X���_");
        adapter.add("��񋳈�_");
        adapter.add("��񃂃f�����O�_");
        adapter.add("�Í��Ə��Љ�");
        adapter.add("�T�[�r�X���f�����O�_");
        adapter.add("���f�U�C���w�Ȗ�");
        adapter.add("�C���t�H���[�V�����f�U�C���_");
        adapter.add("�t�B�[���h���͖@");
        adapter.add("��蔭���^/�����^�w�K1");
        adapter.add("��蔭���^/�����^�w�K2");
        adapter.add("�헪�I�R�~���j�P�[�V�����Z�~�i�[(���{��)");
        adapter.add("�헪�I�R�~���j�P�[�V�����Z�~�i�[(�p��)");
        adapter.add("���w���K�T");
        adapter.add("���w���K�U");
        adapter.add("���v���W�F�N�g�Ȗ�");
        adapter.add("�M�������Z�~�i�[");
        adapter.add("�v�Z�Ȋw���KB");
        adapter.add("�r�b�O�f�[�^�̌v�Z�Ȋw");
        
        ListView listView = new ListView(this);
        // �A�_�v�^�[��ݒ肵�܂�
        listView.setAdapter(adapter);
        

        
        absoluteLayout.addView(listView, new AbsoluteLayout.LayoutParams(720,750, 0, 0));
	
        // ���X�g�r���[�̃A�C�e�����N���b�N���ꂽ���ɌĂяo�����R�[���o�b�N���X�i�[��o�^���܂�
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
                // �N���b�N���ꂽ�A�C�e�����擾���܂�
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
        		//startActivityForResult(intent, 1);�@�@
                if(item == "���V�X�e���݌v�_�T"){
        		startActivity(intent1);
                }
                else if(item == "���V�X�e���݌v�_�U"){
            		startActivity(intent2);
                }
                else if(item == "���V�X�e�����͘_"){
            		startActivity(intent3);
                }
                
        		//finish();
                
                //Toast.makeText(kamoku.this, item, Toast.LENGTH_LONG).show();
            }
            
            
        });
        
        
        
        

		Button btn = new Button(this);
        btn.setText("�߂�");
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
        btn2.setText("�u�`��");
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