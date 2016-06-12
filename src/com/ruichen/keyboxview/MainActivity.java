package com.ruichen.keyboxview;


import java.util.List;
import android.app.Activity;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.Keyboard.Key;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.Toast;

/**
 * 
 * @author chenrui
 *
 * 2016年6月12日
 */
public class MainActivity extends Activity implements OnClickListener{

	private KeyboardView custom_keyboard_view;
	private EditText et_inputpassword;
	
	public boolean isnun = false;// 是否数字键盘
	public boolean isupper = false;// 是否大写
	public boolean isjiajian = false;//是否有加减号的键盘
	private Keyboard k1;//字母显示键盘
	private Keyboard k2;//数字字符键盘
	private Keyboard k3;//数字和带有运算符的键盘

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		custom_keyboard_view = (KeyboardView) findViewById(R.id.custom_keyboard_view);
		et_inputpassword = (EditText) findViewById(R.id.et_inputpassword);
		et_inputpassword.setOnClickListener(this);
		k1 = new Keyboard(this, R.xml.qwerty);
		k2 = new Keyboard(this, R.xml.characterkeybox);
		k3 = new Keyboard(this,R.xml.jiajiankeybox);
		custom_keyboard_view.setKeyboard(k1);
		custom_keyboard_view.setOnKeyboardActionListener(listener);
		et_inputpassword.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				int inputType = et_inputpassword.getInputType();
				//点击edittext不弹出键盘
				et_inputpassword.setInputType(InputType.TYPE_NULL);
				showKeyboard();
				return false;
			}
		});
	}

	private TranslateAnimation getCloseAnimation() {
		TranslateAnimation mCloseAction = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				0.0f, Animation.RELATIVE_TO_SELF, 0.0f,
				Animation.RELATIVE_TO_SELF, 1.0f);
		mCloseAction.setDuration(300);
		return mCloseAction;
	}
	public TranslateAnimation getShowAnimation() {
		TranslateAnimation mShowAction = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
				0.0f, Animation.RELATIVE_TO_SELF, 1.0f,
				Animation.RELATIVE_TO_SELF, 0.0f);
		mShowAction.setDuration(300);
		return mShowAction;
	}
	
	public void showKeyboard() {
        int visibility = custom_keyboard_view.getVisibility();
        if (visibility == View.GONE || visibility == View.INVISIBLE) {
        	custom_keyboard_view.setVisibility(View.VISIBLE);
        }
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.et_inputpassword:
			custom_keyboard_view.setAnimation(getShowAnimation());
			getShowAnimation().start();
			break;

		default:
			break;
		}
	}
	  public void hideKeyboard() {
	        int visibility = custom_keyboard_view.getVisibility();
	        if (visibility == View.VISIBLE) {
	        	custom_keyboard_view.setVisibility(View.INVISIBLE);
	        }
	    }
	    
	    private boolean isword(String str){
	    	String wordstr = "abcdefghijklmnopqrstuvwxyz";
	    	if (wordstr.indexOf(str.toLowerCase())>-1) {
				return true;
			}
	    	return false;
	    }
	
	/**
	 * 键盘大小写切换
	 */
	private void changeKey() {
		List<Key> keylist = k1.getKeys();
		if (isupper) {//大写切换小写
			isupper = false;
			for(Key key:keylist){
				if (key.label!=null && isword(key.label.toString())) {
					key.label = key.label.toString().toLowerCase();
					key.codes[0] = key.codes[0]+32;
				}
			}
		} else {//小写切换大写
			isupper = true;
			for(Key key:keylist){
				if (key.label!=null && isword(key.label.toString())) {
					key.label = key.label.toString().toUpperCase();
					key.codes[0] = key.codes[0]-32;
				}
			}
		}
	}
	/**
	 * 键盘按钮的监听事件
	 */
	private OnKeyboardActionListener listener = new OnKeyboardActionListener() {


		@Override
		public void swipeUp() {
		}

		@Override
		public void swipeRight() {
		}

		@Override
		public void swipeLeft() {
		}

		@Override
		public void swipeDown() {
		}

		@Override
		public void onText(CharSequence text) {
		}

		@Override
		public void onRelease(int primaryCode) {
		}

		@Override
		public void onPress(int primaryCode) {
			
		}
		@Override
		public void onKey(int primaryCode, int[] keyCodes) {
			Editable editable = et_inputpassword.getText();
			int start = et_inputpassword.getSelectionStart();
			if (primaryCode == Keyboard.KEYCODE_CANCEL) {// 完成
				custom_keyboard_view.setAnimation(getCloseAnimation());
				getCloseAnimation().start();
				custom_keyboard_view.setVisibility(View.GONE);
				
			} else if (primaryCode == Keyboard.KEYCODE_DELETE) {//删除
				if (editable != null && editable.length() > 0) {
					if (start > 0) {
						editable.delete(start - 1, start);
					}
				}
			} else if (primaryCode == Keyboard.KEYCODE_SHIFT) {// 大小写切换
				changeKey();
				custom_keyboard_view.setKeyboard(k1);

			}else if(primaryCode == 254){
				if (isjiajian) {
					isjiajian = false;
					custom_keyboard_view.setKeyboard(k2);
				} else {
					isjiajian = true;
					custom_keyboard_view.setKeyboard(k3);
				}
				
			}else if (primaryCode == Keyboard.KEYCODE_MODE_CHANGE) {// 数字键盘切换
				if (isnun) {
					isnun = false;
					custom_keyboard_view.setKeyboard(k1);
				} else {
					isnun = true;
					custom_keyboard_view.setKeyboard(k2);
				}
				
			} else if (primaryCode == 57419) { // go left
				if (start > 0) {
					et_inputpassword.setSelection(start - 1);
				}
			} else if (primaryCode == 57421) { // go right
				if (start < et_inputpassword.length()) {
					et_inputpassword.setSelection(start + 1);
				}
			} else {
				editable.insert(start, Character.toString((char) primaryCode));
			}
		}
	};

}
