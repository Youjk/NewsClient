package com.example.newsclient.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.newsclient.MainActivity;
import com.example.newsclient.R;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RightMenuFragment extends Fragment implements OnItemClickListener{
	
	static String TAG = "DEBUGE";
	private View view;
	private List<String> list;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.d(TAG, "onCreate");
	}
	
	private void initData(){
		list = new ArrayList<>();
		list.add("fragment1");
		list.add("fragment2");
		list.add("fragment3");
		list.add("fragment4");
		list.add("fragment5");
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Log.d(TAG, "onActivityCreated");
		initData();
		ListView list_view = (ListView) view.findViewById(R.id.listview_fragment);
		ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), 
				android.R.layout.simple_list_item_1,list);
		
		list_view.setAdapter(adapter);
		
		list_view.setOnItemClickListener(this);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.d(TAG, "onCreateView");
		view = inflater.inflate(R.layout.listview_fragment, null);
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		// TODO Auto-generated method stub
		Fragment f = null;
		switch(position){
		case 0:
			f = new Fragment1();
			break;
		case 1:
			f = new Fragment2();
			break;
		case 2:
			f = new Fragment3();
			break;
		case 3:
			f = new Fragment4();
			break;
		case 4:
			f = new Fragment5();
			break;
		}
		
		switchFragment(f);
	}
	
	private void switchFragment(Fragment f){
		if(f != null){
			if(getActivity() instanceof MainActivity){
				((MainActivity)getActivity()).switchFragment(f);
			}
		}
	}
}
