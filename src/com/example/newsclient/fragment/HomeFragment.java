package com.example.newsclient.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.newsclient.R;
import com.example.newsclient.base.BaseFragment;
import com.example.newsclient.base.BasePage;
import com.example.newsclient.home.FunctionPage;
import com.example.newsclient.home.GovAffairsPage;
import com.example.newsclient.home.NewsCenterPage;
import com.example.newsclient.home.SettingPage;
import com.example.newsclient.home.SmartServicePage;
import com.example.newsclient.view.CustomViewPager;
import com.example.newsclient.view.CustomViewPager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class HomeFragment extends BaseFragment{
	
	/*
	 * 1、初始化viewpager 通过使用adapter的形式
	 */
	private View view;
	private CustomViewPager viewPager;
	private RadioGroup main_radio;
	private List<BasePage> list = new ArrayList<>();
	private int checkedId = R.id.rb_function;
	@Override
	public View initView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		view = inflater.inflate(R.layout.frag_home2, null);
		viewPager = (CustomViewPager) view.findViewById(R.id.viewpager);
		main_radio = (RadioGroup) view.findViewById(R.id.main_radio);
		return view;
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		list.add(new FunctionPage(context));
		list.add(new NewsCenterPage(context));
		list.add(new SmartServicePage(context));
		list.add(new GovAffairsPage(context));
		list.add(new SettingPage(context));
		
		HomePageAdapter adapter = new HomePageAdapter(context, list);
		viewPager.setAdapter(adapter);
		
		main_radio.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.rb_function:
					viewPager.setCurrentItem(0, false);
					checkedId = 0;
					break;
				case R.id.rb_news_center:
					viewPager.setCurrentItem(1, false);
					checkedId = 1;
					break;
				case R.id.rb_smart_service:
					viewPager.setCurrentItem(2, false);
					checkedId = 2;
					break;
				case R.id.rb_gov_affairs:
					viewPager.setCurrentItem(3, false);
					checkedId = 3;
					break;
				case R.id.rb_setting:
					viewPager.setCurrentItem(4, false);
					checkedId = 4; 
					break;
				default:
					break;
				}
			}
		});
	}
	
	class HomePageAdapter extends PagerAdapter{
		
		private Context context;
		private List<BasePage> list;
		
		public HomePageAdapter(Context context, List<BasePage> list){
			this.context = context;
			this.list = list;
		}
		
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			//super.destroyItem(container, position, object);
			((CustomViewPager)container).removeView(list.get(position).getRootView());
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			((CustomViewPager)container).addView(list.get(position).getRootView(), 0);
			return list.get(position).getRootView();
		}
		
	}
}
