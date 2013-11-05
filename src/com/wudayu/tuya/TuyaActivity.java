package com.wudayu.tuya;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;

public class TuyaActivity extends Activity {

	private TuyaView tuyaView = null;

	FrameLayout fmtTuyaBoard;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tuya);

		/*
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		dm.widthPixels, dm.heightPixels
		*/

		fmtTuyaBoard = (FrameLayout) findViewById(R.id.fmt_tuya_board);

	}

	public void clear(View v) {
		tuyaView = new TuyaView(TuyaActivity.this, fmtTuyaBoard.getWidth(), fmtTuyaBoard.getHeight());
		fmtTuyaBoard.removeAllViews();
		fmtTuyaBoard.addView(tuyaView);
	}

	public void save(View v) {
		if (tuyaView == null)
			return;

		tuyaView.saveToSDCard();
	}

	public void undo(View v) {
		if (tuyaView == null)
			return;

		tuyaView.undo();
	}

	public void haha(View v) {
		tuyaView = new TuyaView(TuyaActivity.this, fmtTuyaBoard.getWidth(), fmtTuyaBoard.getHeight());
		fmtTuyaBoard.removeAllViews();
		fmtTuyaBoard.addView(tuyaView);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {// 返回键
			tuyaView.undo();
			return true;
		} else if (keyCode == KeyEvent.KEYCODE_MENU) {// MENU
			tuyaView.redo();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
