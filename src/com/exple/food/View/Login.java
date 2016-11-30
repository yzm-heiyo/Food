package com.exple.food.View;

import com.exple.food.R;
import com.exple.food.R.id;
import com.exple.food.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;

public class Login extends BasicActivity {
	
	private EditText editText1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		Button bt=(Button)findViewById(R.id.button1);
		editText1=(EditText)findViewById(R.id.editText1);
		final EditText editText2=(EditText)findViewById(R.id.editText2);
		
		getName();
		
		editText1.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View arg0, MotionEvent arg1) {
				// TODO Auto-generated method stub
				double x=arg0.getWidth()-arg0.getPaddingRight()-35;
				if(arg1.getX()>x){
					editText1.setText("");
				}
				return false;
			}
		});
		
		
		bt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
//				if(editText1.getText().toString().equals("123")&&editText2.getText().toString().equals("admin")){
					Intent intent=new Intent(Login.this,MainActivity.class);
					saveName();
					startActivity(intent);
//				}
			}
		});
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	protected void saveName() {
		// TODO Auto-generated method stub
		SharedPreferences sp=getSharedPreferences("name", MODE_PRIVATE);

		String id=editText1.getText().toString().trim();

		SharedPreferences.Editor editor=sp.edit();
		editor.putString("uid", id);
		editor.commit();
		}


		private void getName() {
		// TODO Auto-generated method stub
		SharedPreferences sp=getSharedPreferences("name",MODE_PRIVATE);
		String id=sp.getString("uid", null);
		if(id!=null){
			editText1.setText(id);
		}		
		}

}
