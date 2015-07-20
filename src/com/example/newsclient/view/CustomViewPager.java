package com.example.newsclient.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class CustomViewPager extends LazyViewPager{

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		return super.dispatchTouchEvent(ev);
	}

	private boolean setTouchModel = false;
	public CustomViewPager(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public CustomViewPager(Context context, AttributeSet attrs){
		 super(context, attrs);
	 }
	       
	
	
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		if(setTouchModel)
			return super.onInterceptTouchEvent(ev);
		else
			return false;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		if(setTouchModel)
			return super.onTouchEvent(ev);
		else
			return false;
	}
}
