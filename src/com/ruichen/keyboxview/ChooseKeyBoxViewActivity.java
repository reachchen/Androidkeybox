package com.ruichen.keyboxview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ChooseKeyBoxViewActivity extends Activity implements OnClickListener{
	
	private Button btn_custom_randomkeybox;
	private Button  btn_custom_systemkeybox;
	private Intent myintent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_keyboxview);
		btn_custom_randomkeybox = (Button) findViewById(R.id.btn_custom_randomkeybox);
		btn_custom_systemkeybox = (Button) findViewById(R.id.btn_custom_systemkeybox);
		btn_custom_randomkeybox.setOnClickListener(this);
		btn_custom_systemkeybox.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_custom_randomkeybox:
			myintent = new Intent(ChooseKeyBoxViewActivity.this,RandomKeyboxActivity.class);
			startActivity(myintent);
			break;
		case R.id.btn_custom_systemkeybox:
			myintent = new Intent(ChooseKeyBoxViewActivity.this,MainActivity.class);
			startActivity(myintent);
			break;

		default:
			break;
		}
		
	}

}
