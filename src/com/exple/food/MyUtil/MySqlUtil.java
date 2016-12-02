package com.exple.food.MyUtil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MySqlUtil extends SQLiteOpenHelper {

	static String dataBase="FoodDataBase.db";
	public MySqlUtil(Context context) {
		super(context, dataBase, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		String sql="create table mytable(id varchar(10) primary key,name varchar(50) null)";
		arg0.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}
	
	public void onSelect(SQLiteDatabase arg0,String sqlString){
		arg0.execSQL(sqlString);
	}

	
}
