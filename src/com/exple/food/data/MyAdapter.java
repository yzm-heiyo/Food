package com.exple.food.data;

import java.util.ArrayList;
import java.util.List;

import com.exple.food.R;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	
	String[] data={"omg","wer","dsf","zcx","fvg","bgn","vbv","nbn"};
	List<Integer> price=new ArrayList<Integer>();
	Context context;
	int sum=0;
	int[] list_value=new int[data.length];
	ViewHolder holder;
	
	public MyAdapter(Activity activity,List<Integer> price){
		context=activity;
		this.price=price;
		initdata();
	}
	
	public MyAdapter(FragmentActivity activity,List<Integer> price) {
		// TODO Auto-generated constructor stub
		context=activity;
		this.price=price;
		initdata();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return price.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(final int arg0, final View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		final View view;
		if(arg1==null){
		view=LayoutInflater.from(context).inflate(R.layout.xml_list, null);
		
		holder=new ViewHolder();
		
		holder.button_add=(Button)view.findViewById(R.id.button2);
		holder.button_reduce=(Button)view.findViewById(R.id.button1);
		holder.tv1=(TextView)view.findViewById(R.id.textView1);
		holder.tv2=(TextView)view.findViewById(R.id.textView2);
		view.setTag(holder);
		}else{
			view=arg1;
			holder=(ViewHolder) view.getTag();
		}
		holder.tv1.setText("¥"+price.get(arg0));

		
		Log.i("enter", "enter");
//		Toast.makeText(context, sum, 3).show();
		holder.button_add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg) {
				// TODO Auto-generated method stub
				list_value[arg0]++;
				TextView tv2=(TextView)view.findViewById(R.id.textView2);
				tv2.setText(""+list_value[arg0]);
				System.out.println(getsum());
//				food_select.handler.sendEmptyMessage(getsum());
				Intent intent=new Intent("com.exple.BroadCast.priceChange");
				intent.putExtra("priceSum", getsum());
				context.sendBroadcast(intent);
			}
		});
		
		holder.button_reduce.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg) {
				// TODO Auto-generated method stub
				if(list_value[arg0]!=0){
					list_value[arg0]--;
					TextView tv2=(TextView)view.findViewById(R.id.textView2);
					tv2.setText(""+list_value[arg0]);
					System.out.println(getsum());
					Intent intent=new Intent("com.exple.BroadCast.priceChange");
					intent.putExtra("priceSum", getsum());
					context.sendBroadcast(intent);
				}
			}
		});
		
		return view;
	}

	private int getsum() {
		// TODO Auto-generated method stub
		sum=0;
		for(int i=0;i<price.size();i++){
			sum=sum+list_value[i]*(int)price.get(i);
		}
		return sum;
	}

	private void initdata() {
		// TODO Auto-generated method stub
		for(int i=0;i<price.size();i++){
			list_value[i]=0;
		}
	}
	
	class ViewHolder{
		Button button_add;
		Button button_reduce;
		TextView tv1;
		TextView tv2;
	}

}
