package com.example.newsclient;

import com.example.newsclient.fragment.Fragment1;
import com.example.newsclient.fragment.HomeFragment;
import com.example.newsclient.fragment.MenuFragment;
import com.example.newsclient.fragment.RightMenuFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class MainActivity extends SlidingFragmentActivity {
	private SlidingMenu sm = null;
	
	/*
	 * 1���õ������˵�
	 * 2�����û����˵�����߳��������ұ߳���
	 * 3�����û����˵�����֮������ҳ��ʾ��ʣ����
	 * 4�����û����˵�����Ӱ ������Ӱ����Ӱ��Ҫ�ڿ�ʼ��ʱ���ܰ���Ȼ�������䵭����Ȼ������ɫһ��������
	 * 4��������Ӱ�Ŀ�ȡ�
	 * 5�������ֻ�����Ļ�ķ�Χ���˵��ų���
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setBehindContentView(R.layout.menu);
		setContentView(R.layout.content);
		
		//���ó�ʼҳ��Ϊ��һ��fragment
		Fragment fragment1 = new Fragment1();
		getSupportFragmentManager().beginTransaction().
		replace(R.id.content_fram, fragment1)
		.commit();
		
		//�õ������˵�
		sm = getSlidingMenu();
		//���û����˵�������߻����ұ�
		sm.setMode(SlidingMenu.LEFT);
		//���û����˵������Ŀ��
		sm.setBehindWidthRes(R.dimen.slidingmenu_offset);
		//���û����˵�����Ӱ
		sm.setShadowDrawable(R.drawable.shadow);
		//������Ӱ���
		sm.setShadowWidth(R.dimen.shadow_width);
		//���û����˵��ķ�Χ,��������ȫ�����������ػ��������߲�����
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		
		//����fragment
		MenuFragment menuFragment = new MenuFragment();
		getSupportFragmentManager().beginTransaction().
				replace(R.id.menu_frame, menuFragment)
				.commit();
		
		
		HomeFragment homeFragment = new HomeFragment();
		getSupportFragmentManager().beginTransaction().
			replace(R.id.content_fram, homeFragment)
			.commit();
		/*
		 * �ұ߲໬
		 */
//		sm.setSecondaryMenu(R.layout.right_menu);
//		sm.setSecondaryShadowDrawable(R.drawable.shadowright);
//		RightMenuFragment rightMenuFragment = new RightMenuFragment();
//		getSupportFragmentManager().beginTransaction()
//			.replace(R.id.right_menu, rightMenuFragment)
//			.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(com.actionbarsherlock.view.Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, (Menu) menu);
		return true;
	}
	
	/**
	 *  ����D
	 *  �ص�
	 * @param f
	 */
	public void switchFragment(Fragment f){
		getSupportFragmentManager().beginTransaction().
			replace(R.id.content_fram, f)
			.commit();
		//�л������˵�
		sm.toggle();
	}

}
