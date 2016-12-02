package com.exple.food.MyUtil;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.exple.food.data.foodType;

public class JsonUtil {
	
	
	public static List<Integer>  parseJsonText(String jsonText){
		List<Integer> list=new ArrayList<Integer>();
		try {
//			JSONObject json=new JSONObject(jsonText);
//			JSONObject object=json.getJSONObject("data");
			JSONArray jsonArray=new JSONArray(jsonText);
			for(int i=0;i<jsonArray.length();i++){
				JSONObject jsonObject=jsonArray.getJSONObject(i);
//				String name=jsonObject.getString("name");
				int price=jsonObject.getInt("price");
//				foodType type=new foodType(name, price);
				list.add(price);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public static String createJsonText(String jsontKey,Object value){
		JSONObject jsonObject=new JSONObject();
		
		try {
			jsonObject.put(jsontKey, value);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
}
