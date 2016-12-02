package com.exple.food.View;

import java.util.ArrayList;
import java.util.List;

import com.exple.food.R;
import com.exple.food.MyUtil.CustomDialog;
import com.exple.food.MyUtil.HttpUtil;
import com.exple.food.MyUtil.JsonUtil;
import com.exple.food.MyUtil.MyApplication;
import com.exple.food.MyUtil.getDataFromInternet;
import com.exple.food.R.drawable;
import com.exple.food.R.id;
import com.exple.food.R.layout;
import com.exple.food.View.MainActivity.receiveDataBroadCast;
import com.exple.food.data.MyAdapter;

import android.R.integer;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class main_foodSelectMenu extends Fragment implements OnClickListener {

	private ListView listView;
	private Button sendHttpbtn;
	private Button timeBtn;
	private CustomDialog.Builder builder;
	private Button priceSumBtn;
	private priceChangeBrodcast brodcast;
	private String Url_Path="http://www.baidu.com/";
	private List<Integer> listdata;
	private List<Integer> receivelistdata;
	private receiveDataBroadCast broadCast;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.main_food, container, false);

		listView = (ListView) view.findViewById(R.id.listView1);
		listdata=new ArrayList<Integer>();
		receivelistdata=new ArrayList<Integer>();
		listdata.add(25);
		listdata.add(30);
		listView.setAdapter(new MyAdapter(getActivity(),listdata));
		
		timeBtn=(Button)view.findViewById(R.id.timeBtn);
		priceSumBtn=(Button)view.findViewById(R.id.priceBtn);
		
		sendHttpbtn = (Button) view.findViewById(R.id.senthttpBTN);
		sendHttpbtn.setOnClickListener(this);
		
        builder = new CustomDialog.Builder(getActivity());  
        builder.setMessage("可以催服务员上菜了");  
        builder.setTitle("提示");  
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {  
            public void onClick(DialogInterface dialog, int which) {  
                dialog.dismiss();  
                //设置你的操作事项  
            }  
        });   
  
		
		IntentFilter pricefilter=new IntentFilter();
		pricefilter.addAction("com.exple.BroadCast.priceChange");
		brodcast=new priceChangeBrodcast();
		
		broadCast = new receiveDataBroadCast();
		IntentFilter dataChangefilter = new IntentFilter();
		dataChangefilter.addAction("com.com.receive.main");
		getActivity().registerReceiver(broadCast, dataChangefilter);
		getActivity().registerReceiver(brodcast, pricefilter);
		
		return view;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		new mytime().execute();
		Toast.makeText(getActivity(), "上餐倒计时开始，加单请呼叫服务员", 5).show();
		sendHttpbtn.setEnabled(false);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				HttpUtil.HttpConnect(Url_Path);
			}
		}).start();
	}

	private class mytime extends AsyncTask<Void, Integer, Void> {

		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			for(int i=30;i>0;i--){
				try {
					Thread.sleep(1000);
					publishProgress(i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			// TODO Auto-generated method stub
			timeBtn.setBackgroundResource(R.drawable.white);
			timeBtn.setText(""+values[0]);
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			timeBtn.setBackgroundResource(R.drawable.clock_72px_1157020_easyicon);
			timeBtn.setText("");
			sendHttpbtn.setEnabled(true);
			builder.create().show();
		}
	}
	
	private class priceChangeBrodcast extends BroadcastReceiver{

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			// TODO Auto-generated method stub
			int price=arg1.getIntExtra("priceSum", 0);
			priceSumBtn.setText("¥"+price);
//			Toast.makeText(getActivity(), "jieshou", 3).show();
		}
		
	}
	public class receiveDataBroadCast extends BroadcastReceiver {

		@Override
		public void onReceive(Context arg0, Intent arg1) {
			// TODO Auto-generated method stub
			Toast.makeText(MyApplication.getContext(), "00", 3).show();
			String receivemeassger=arg1.getStringExtra("receivemeassger");
			Log.i("receivemeassger", receivemeassger);
			receivelistdata=JsonUtil.parseJsonText(receivemeassger);
			listView.setAdapter(new MyAdapter(getActivity(),receivelistdata));
		}

	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		getActivity().unregisterReceiver(brodcast);
		getActivity().unregisterReceiver(broadCast);
	}
}
