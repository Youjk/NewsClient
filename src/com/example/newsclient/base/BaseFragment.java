package com.example.newsclient.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
	protected Context  context;
	private View view;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		view =initView(inflater);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stubview 
		super.onActivityCreated(savedInstanceState);
		context = getActivity();
		initData();
	}
	
	public View getRootView()
	{
		return this.view;
	}
	
	/*
	 * ��ʼ��View
	 */
	public abstract View initView(LayoutInflater inflater);
	/*
	 * ��ʼ������
	 */
	public abstract void initData();
}
