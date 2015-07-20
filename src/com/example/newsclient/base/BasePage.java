package com.example.newsclient.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public abstract class BasePage {
	/*
	 * 1��������
	 * 2����ʼ������
	 */
	private View view;
	protected Context context;
	public BasePage(Context context){
		this.context = context;
		LayoutInflater inflater = LayoutInflater.from(context);
		view = initView(inflater);
	}
	
	public View getRootView()
	{
		return this.view;
	}
	
	public abstract View initView(LayoutInflater inflater);
}
