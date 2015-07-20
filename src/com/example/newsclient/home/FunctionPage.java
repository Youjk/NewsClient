package com.example.newsclient.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.newsclient.base.BasePage;

public class FunctionPage extends BasePage{

	public FunctionPage(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View initView(LayoutInflater inflater) {
		// TODO Aumto-generated method stub
		TextView textview = new TextView(context);
		textview.setText("ÎÒÊÇÊ×Ò³");
		
		return textview;
	}
}
