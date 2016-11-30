package com.exple.food.View;

import com.exple.food.data.ActivityCollector;

import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;

public class BasicActivity extends FragmentActivity {
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		ActivityCollector.addActovoty(this);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			ActivityCollector.finishAll();
			finish();
			break;

		default:
			break;
		}
		return super.onKeyDown(keyCode, event);
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
}
