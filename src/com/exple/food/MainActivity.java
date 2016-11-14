package com.exple.food;

import com.exple.food.MyUtil.HttpUtil;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	private String parseData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        new Thread(){
        	public void run() {
                HttpUtil.HttpConnect("http://192.168.155.8:8080/jsonText.json", new getDataFromInternet() {
        			
        			@Override
        			public String getData(String data) {
        				// TODO Auto-generated method stub
        				parseData=data;
        				Log.i("localhost", data);
        				return data;
        			}
        		});
        	};
        }.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
