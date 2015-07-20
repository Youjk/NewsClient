package com.example.newsclient.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.newsclient.base.BasePage;

public class SmartServicePage extends BasePage{

	public SmartServicePage(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		TextView textview = new TextView(context);
		textview.setText("我是智慧服务");
		
		return textview;
	}

}
