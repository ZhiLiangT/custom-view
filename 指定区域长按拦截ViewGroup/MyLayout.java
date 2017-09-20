package com.bjb.cultural.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;


public class MyLayout extends RelativeLayout {
	private boolean temp=false;
	
	 public MyLayout(Context context, AttributeSet attrs) {  
	        super(context, attrs);  
	    }  
	    @Override  
	    public boolean onInterceptTouchEvent(MotionEvent event) {  
	    	 int x= (int) event.getX();
             int y= (int) event.getY();
             Log.i("TouchActivity","坐标 X:"+x+" Y:"+y);
             if (x<200&&y<200){
                 switch (event.getAction()){
                     case MotionEvent.ACTION_DOWN:
                    	 temp=false;
                         handler.postDelayed(runnable,5000);
                         break;
                     case MotionEvent.ACTION_UP:
                    	 handler.removeCallbacks(runnable);
                    	 if (temp) {
							return true;
                    	 }
                    	 break;
                 }
             }
	        return false;  
	    }  
	    
	    Handler handler=new Handler();

	    Runnable runnable=new Runnable() {
	        @Override
	        public void run() {
	        	listener.onLongClick();
	        }
	    };
		public interface OnLongClickListener{
			void onLongClick();
		}
		private OnLongClickListener listener;
		public void onLongClikcListener(OnLongClickListener listener){
			this.listener=listener;
		}
}
