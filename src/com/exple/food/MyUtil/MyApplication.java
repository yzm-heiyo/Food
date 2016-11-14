package com.exple.food.MyUtil;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
	
	public static Context context;
	
	public MyApplication() {
		// TODO Auto-generated constructor stub
		context=getApplicationContext();
	}
	
	public static Context getContext(){
		return context;
	}
}
