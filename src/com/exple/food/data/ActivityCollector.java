package com.exple.food.data;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

public class ActivityCollector {
	
	public static List<Activity> activities=new ArrayList<Activity>();
	
	public static void addActovoty(Activity activity){
		activities.add(activity);
	}
	
	public static void removeActivity(Activity activity) {
		activities.remove(activity);
	}
	
	public static void finishAll(){
		for(Activity activity:activities){
			activity.finish();
		}
		activities.clear();
	}
}
