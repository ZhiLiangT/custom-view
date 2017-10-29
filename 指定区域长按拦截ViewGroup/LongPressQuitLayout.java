package com.bbwhm.omeng.custom;

import com.bbwhm.omeng.utils.ViewUtils;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class LongPressQuitLayout extends RelativeLayout {
	private int regionNum;

	private int x_down, y_down;

	public LongPressQuitLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		int widScreen = ViewUtils.getScreen(context, ViewUtils.WINDOW_WIDTH);
		regionNum = (int) (widScreen / 3.887);
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent event) {
		int x = (int) event.getX();
		int y = (int) event.getY();
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			if (x < regionNum && y < regionNum) {
				x_down = x;
				y_down = y;
				handler.postDelayed(runnable, 5000);
			}
			break;
		case MotionEvent.ACTION_UP:
			handler.removeCallbacks(runnable);
		case MotionEvent.ACTION_MOVE:
			if (Math.abs(x-x_down)>10||Math.abs(y-y_down)>10) {
				handler.removeCallbacks(runnable);
			}
			break;
		}

		return false;
	}
	Handler handler = new Handler();

	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			listener.onLongClick();
		}
	};
	public interface OnLongClickListener {
		void onLongClick();
	}
	private OnLongClickListener listener;
	public void onLongClikcListener(OnLongClickListener listener) {
		this.listener = listener;
	}
}
