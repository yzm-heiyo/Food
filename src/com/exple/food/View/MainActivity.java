package com.exple.food.View;

import com.exple.food.R;
import com.exple.food.MyUtil.HttpUtil;
import com.exple.food.MyUtil.getDataFromInternet;
import com.exple.food.R.drawable;
import com.exple.food.R.id;
import com.exple.food.R.layout;
import com.exple.food.R.menu;
import com.exple.food.data.MyFragmentPagerAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RemoteViews;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class MainActivity extends BasicActivity {

	private ViewPager viewPager;
	private String parseData;
	private TabHost tabHost;
	private TabWidget tabWidget;
	private TextView tv;
	private NotificationManager manager;
	private Notification notification;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.setup();
		tabHost.addTab(tabHost.newTabSpec("a").setIndicator("娱乐")
				.setContent(R.id.myviewPager));
		tabHost.addTab(tabHost.newTabSpec("b").setIndicator("点餐")
				.setContent(R.id.myviewPager));
		tabHost.addTab(tabHost.newTabSpec("c").setIndicator("推广")
				.setContent(R.id.myviewPager));

		viewPager = (ViewPager) findViewById(R.id.myviewPager);
		viewPager.setAdapter(new MyFragmentPagerAdapter(
				getSupportFragmentManager()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		// 利用循环创建监听器
		tabWidget = tabHost.getTabWidget();
		tabWidget.setStripEnabled(false);
		// tabWidget.setDividerDrawable(null);

		final int count = tabWidget.getChildCount();

		for (int i = 0; i != count; i++) {
			final int index = i;
			View view = tabHost.getTabWidget().getChildAt(i);
			view.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.white));// 选中后的背景
			view.getLayoutParams().height = 80;
			tv = (TextView) tabWidget.getChildAt(i).findViewById(
					android.R.id.title);
			tv.setTextColor(this.getResources().getColorStateList(
					android.R.color.white));
			tabWidget.getChildAt(i).setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					tabHost.setCurrentTab(index);
					viewPager.setCurrentItem(index);
					for (int i = 0; i != count; i++) {
						tv = (TextView) tabWidget.getChildAt(i).findViewById(
								android.R.id.title);
						tv.setTextColor(Color.rgb(255, 255, 255));
						tv.setTextSize(10);
						if (i == index) {
							tv.setTextSize(18);
						}
					}
				}
			});
		}
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				Log.i("TAG", "@--> onPageSelected: " + arg0);
				// tabHost.setCurrentTab(arg0);
				for (int i = 0; i != 3; i++) {
					tv = (TextView) tabWidget.getChildAt(i).findViewById(
							android.R.id.title);
					tv.setTextColor(Color.rgb(255, 255, 255));
					tv.setTextSize(10);
					if (i == arg0) {
						tv.setTextSize(18);
					}
				}
				tabHost.setCurrentTab(arg0);
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {

			}
		});
		tabHost.setCurrentTab(1);//
		viewPager.setCurrentItem(1);//
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		notification = new Notification(R.drawable.ic_launcher, "", System.currentTimeMillis());
		Intent intent = new Intent(MainActivity.this, MainActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
				intent, PendingIntent.FLAG_CANCEL_CURRENT);
		RemoteViews remoteViews=new RemoteViews(getPackageName(), R.layout.notificationview);
		remoteViews.setImageViewResource(R.id.image, R.drawable.login1);
		remoteViews.setTextViewText(R.id.title, "轻触回到软件");
		notification.contentView=remoteViews;
		notification.contentIntent=pendingIntent;
		manager.notify(1, notification);
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		manager.cancel(1);
	}

}
