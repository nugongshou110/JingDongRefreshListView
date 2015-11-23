package com.zhangqi.jingdongrefreshlistview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PullToRefreshActivity extends Activity implements JingDongListView.OnJingDongRefreshListener {
	private JingDongListView mListView;
	private List<String> mDatas;
	private ArrayAdapter<String> mAdapter;
	private final static int REFRESH_COMPLETE = 0;

	private Handler mHandler = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case REFRESH_COMPLETE:
				mListView.setOnRefreshComplete();
				mAdapter.notifyDataSetChanged();
				mListView.setSelection(0);
				break;

			default:
				break;
			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pulltorefresh);
		mListView = (JingDongListView) findViewById(R.id.listview);
		String[] data = new String[]{"hello world","hello world","hello world","hello world",
				"hello world","hello world","hello world","hello world","hello world",
				"hello world","hello world","hello world","hello world","hello world",};
		mDatas = new ArrayList<String>(Arrays.asList(data));
		mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mDatas);
		mListView.setAdapter(mAdapter);
		mListView.setOnJingDongRefreshListener(this);
	}

	@Override
	public void onRefresh() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(3000);
					mDatas.add(0, "new data");
					mHandler.sendEmptyMessage(REFRESH_COMPLETE);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}


}
