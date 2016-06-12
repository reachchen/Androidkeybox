package com.ruichen.keyboxview;

import java.util.Random;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
/**
 * 
 * @author chenrui
 *
 * 2016年6月12日
 */
public class RandomKeyboxActivity extends Activity implements OnClickListener{
	private TextView[] btn_keybaord  = new TextView[10];
	ImageView[] img_pwd = new ImageView[6];
	private TextView tv_password;
	private String str;
	private ImageView img_keyboard_cancle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_random);
		tv_password = (TextView) findViewById(R.id.tv_password_num);
		//键盘按键
		btn_keybaord[0] = (TextView) findViewById(R.id.tv_keyboard_0);
		btn_keybaord[1] = (TextView) findViewById(R.id.tv_keyboard_1);
		btn_keybaord[2] = (TextView) findViewById(R.id.tv_keyboard_2);
		btn_keybaord[3] = (TextView) findViewById(R.id.tv_keyboard_3);
		btn_keybaord[4] = (TextView) findViewById(R.id.tv_keyboard_4);
		btn_keybaord[5] = (TextView) findViewById(R.id.tv_keyboard_5);
		btn_keybaord[6] = (TextView) findViewById(R.id.tv_keyboard_6);
		btn_keybaord[7] = (TextView) findViewById(R.id.tv_keyboard_7);
		btn_keybaord[8] = (TextView) findViewById(R.id.tv_keyboard_8);
		btn_keybaord[9] = (TextView) findViewById(R.id.tv_keyboard_9);
		img_keyboard_cancle = (ImageView) findViewById(R.id.img_keyboard_cancle);
		img_keyboard_cancle.setOnClickListener(this);
		//密码显示
		img_pwd[0] = (ImageView) findViewById(R.id.img_password_one);
		img_pwd[1] = (ImageView) findViewById(R.id.img_password_two);
		img_pwd[2] = (ImageView) findViewById(R.id.img_password_three);
		img_pwd[3] = (ImageView) findViewById(R.id.img_password_four);
		img_pwd[4] = (ImageView) findViewById(R.id.img_password_five);
		img_pwd[5] = (ImageView) findViewById(R.id.img_password_six);
		
		tv_password.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				if (s.toString().length() <= 6 && s.toString().length() >= 0) {
					initPwd(s.toString().length());
				}

			}
		});
		initView();
		
	}
	
	private void initPwd(int num) {
		for (int i = 0; i < 6; i++) {
			if (i < num) {
				img_pwd[i].setImageResource(R.drawable.point_pre);
			} else {
				img_pwd[i].setImageResource(R.drawable.xian);
			}
		}
	}

	private void initView() {
		// TODO Auto-generated method stub
		Random randrom = new Random();
		int num[] = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int i = 0;
		while (i < 10) {
			int aNum = randrom.nextInt(10);
			int temp = num[0];
			num[0] = num[aNum];
			num[aNum] = temp;
			i++;
		}
		for (int j = 0; j < 10; j++) {
			btn_keybaord[j].setText(num[j] + "");
			btn_keybaord[j].setOnClickListener(this);
		}
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.tv_keyboard_0:
			str = tv_password.getText().toString().trim();
			if (str == null || str.length() == 0) {
				str = "";
			} else if (str.length() == 6) {
				break;
			}
			str = str + btn_keybaord[0].getText().toString();
			tv_password.setText(str);
			if (str.length() == 6) {
//				layout_keyboard.setAnimation(getCloseAnimation());
//				layout_keyboard.setVisibility(View.GONE);
				Toast.makeText(RandomKeyboxActivity.this, "输入密码为 :"+str, 0).show();
			}
			break;
		case R.id.tv_keyboard_1:
			str = tv_password.getText().toString().trim();
			if (str == null || str.length() == 0) {
				str = "";
			} else if (str.length() == 6) {
				break;
			}
			str = str + btn_keybaord[1].getText().toString();
			tv_password.setText(str);
			if (str.length() == 6) {
//				layout_keyboard.setAnimation(getCloseAnimation());
//				layout_keyboard.setVisibility(View.GONE);
				Toast.makeText(RandomKeyboxActivity.this, "输入密码为 :"+str, 0).show();
			}
			break;
		case R.id.tv_keyboard_2:
			str = tv_password.getText().toString().trim();
			if (str == null || str.length() == 0) {
				str = "";
			} else if (str.length() == 6) {
				break;
			}
			str = str + btn_keybaord[2].getText().toString();
			tv_password.setText(str);
			if (str.length() == 6) {
//				layout_keyboard.setAnimation(getCloseAnimation());
//				layout_keyboard.setVisibility(View.GONE);
				Toast.makeText(RandomKeyboxActivity.this, "输入密码为 :"+str, 0).show();
			}
			break;
		case R.id.tv_keyboard_3:
			str = tv_password.getText().toString().trim();
			if (str == null || str.length() == 0) {
				str = "";
			} else if (str.length() == 6) {
				break;
			}
			str = str + btn_keybaord[3].getText().toString();
			tv_password.setText(str);
			if (str.length() == 6) {
//				layout_keyboard.setAnimation(getCloseAnimation());
//				layout_keyboard.setVisibility(View.GONE);
				Toast.makeText(RandomKeyboxActivity.this, "输入密码为 :"+str, 0).show();
			}
			break;
		case R.id.tv_keyboard_4:
			str = tv_password.getText().toString().trim();
			if (str == null || str.length() == 0) {
				str = "";
			} else if (str.length() == 6) {
				break;
			}
			str = str + btn_keybaord[4].getText().toString();
			tv_password.setText(str);
			if (str.length() == 6) {
//				layout_keyboard.setAnimation(getCloseAnimation());
//				layout_keyboard.setVisibility(View.GONE);
				Toast.makeText(RandomKeyboxActivity.this, "输入密码为 :"+str, 0).show();
			}
			break;
		case R.id.tv_keyboard_5:
			str = tv_password.getText().toString().trim();
			if (str == null || str.length() == 0) {
				str = "";
			} else if (str.length() == 6) {
				break;
			}
			str = str + btn_keybaord[5].getText().toString();
			tv_password.setText(str);
			if (str.length() == 6) {
//				layout_keyboard.setAnimation(getCloseAnimation());
//				layout_keyboard.setVisibility(View.GONE);
				Toast.makeText(RandomKeyboxActivity.this, "输入密码为 :"+str, 0).show();
			}
			break;
		case R.id.tv_keyboard_6:
			str = tv_password.getText().toString().trim();
			if (str == null || str.length() == 0) {
				str = "";
			} else if (str.length() == 6) {
				break;
			}
			str = str + btn_keybaord[6].getText().toString();
			tv_password.setText(str);
			if (str.length() == 6) {
//				layout_keyboard.setAnimation(getCloseAnimation());
//				layout_keyboard.setVisibility(View.GONE);
				Toast.makeText(RandomKeyboxActivity.this, "输入密码为 :"+str, 0).show();
			}
			break;
		case R.id.tv_keyboard_7:
			str = tv_password.getText().toString().trim();
			if (str == null || str.length() == 0) {
				str = "";
			} else if (str.length() == 6) {
				break;
			}
			str = str + btn_keybaord[7].getText().toString();
			tv_password.setText(str);
			if (str.length() == 6) {
//				layout_keyboard.setAnimation(getCloseAnimation());
//				layout_keyboard.setVisibility(View.GONE);
				Toast.makeText(RandomKeyboxActivity.this, "输入密码为 :"+str, 0).show();
			}
			break;
		case R.id.tv_keyboard_8:
			str = tv_password.getText().toString().trim();
			if (str == null || str.length() == 0) {
				str = "";
			} else if (str.length() == 6) {
				break;
			}
			str = str + btn_keybaord[8].getText().toString();
			tv_password.setText(str);
			if (str.length() == 6) {
//				layout_keyboard.setAnimation(getCloseAnimation());
//				layout_keyboard.setVisibility(View.GONE);
				Toast.makeText(RandomKeyboxActivity.this, "输入密码为 :"+str, 0).show();
			}
			break;
		case R.id.tv_keyboard_9:
			str = tv_password.getText().toString().trim();
			if (str == null || str.length() == 0) {
				str = "";
			} else if (str.length() == 6) {
				break;
			}
			str = str + btn_keybaord[9].getText().toString();
			tv_password.setText(str);
			if (str.length() == 6) {
//				layout_keyboard.setAnimation(getCloseAnimation());
//				layout_keyboard.setVisibility(View.GONE);
				Toast.makeText(RandomKeyboxActivity.this, "输入密码为 :"+str, 0).show();
			}
			break;
			
		case R.id.img_keyboard_cancle:
			str = tv_password.getText().toString().trim();
			if (str == null || str.length() == 0) {
				break;
			} else if (str.length() == 1) {
				tv_password.setText("");
			} else {
				str = str.substring(0, str.length() - 1);
				tv_password.setText(str);
			}
			break;
	}
 }


}
