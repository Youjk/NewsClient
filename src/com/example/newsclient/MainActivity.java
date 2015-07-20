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
	 * 1、得到滑动菜单
	 * 2、设置滑动菜单是左边出来还是右边出来
	 * 3、设置滑动菜单出来之后内容页显示的剩余宽度
	 * 4、设置滑动菜单的阴影 设置阴影，阴影需要在开始的时候会很暗，然后慢慢变淡，不然背景颜色一样看不见
	 * 4、设置阴影的宽度。
	 * 5、设置手机按屏幕的范围，菜单才出来
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setBehindContentView(R.layout.menu);
		setContentView(R.layout.content);
		
		//设置初始页面为第一个fragment
		Fragment fragment1 = new Fragment1();
		getSupportFragmentManager().beginTransaction().
		replace(R.id.content_fram, fragment1)
		.commit();
		
		//得到滑动菜单
		sm = getSlidingMenu();
		//设置滑动菜单是在左边还是右边
		sm.setMode(SlidingMenu.LEFT);
		//设置滑动菜单出来的宽度
		sm.setBehindWidthRes(R.dimen.slidingmenu_offset);
		//设置滑动菜单的阴影
		sm.setShadowDrawable(R.drawable.shadow);
		//设置阴影宽度
		sm.setShadowWidth(R.dimen.shadow_width);
		//设置滑动菜单的范围,可以设置全屏滑动，边沿滑动，或者不滑动
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		
		//创建fragment
		MenuFragment menuFragment = new MenuFragment();
		getSupportFragmentManager().beginTransaction().
				replace(R.id.menu_frame, menuFragment)
				.commit();
		
		
		HomeFragment homeFragment = new HomeFragment();
		getSupportFragmentManager().beginTransaction().
			replace(R.id.content_fram, homeFragment)
			.commit();
		/*
		 * 右边侧滑
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
	 *  方法D
	 *  回调
	 * @param f
	 */
	public void switchFragment(Fragment f){
		getSupportFragmentManager().beginTransaction().
			replace(R.id.content_fram, f)
			.commit();
		//切换滑动菜单
		sm.toggle();
	}

}
