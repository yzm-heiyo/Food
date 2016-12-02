package com.exple.food.service;

import java.util.ArrayList;
import java.util.List;

import com.exple.food.MyUtil.HttpUtil;
import com.exple.food.MyUtil.JsonUtil;
import com.exple.food.MyUtil.MyApplication;
import com.exple.food.data.foodType;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyIntentService extends IntentService {

	private String Url_Path = "http://192.168.155.4:8080/foodPrice.json";
	private List<foodType> list;
	private String data="";
	public MyIntentService() {
		super("MyIntentService");
		// TODO Auto-generated constructor stub
	}

	public MyIntentService(String name) {
		super("MyIntentService");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		list = new ArrayList<foodType>();
		Log.i("myintent", "ok");
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
		Log.i("myintent", "ok1");
		 String data=HttpUtil.HttpConnect(Url_Path);
		 Log.i("json", data);
		Intent intent = new Intent("com.com.receive.main");
		intent.putExtra("receivemeassger", data);
		getApplicationContext().sendBroadcast(intent);
	}

}
