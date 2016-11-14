package com.exple.food.MyUtil;

import java.security.PublicKey;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtil {
	
	
	public static void parseJsonText(String jsonText){
		try {
//			JSONObject json=new JSONObject(jsonText);
//			JSONObject object=json.getJSONObject("data");
			JSONArray jsonArray=new JSONArray(jsonText);
			for(int i=0;i<jsonArray.length();i++){
				JSONObject jsonObject=jsonArray.getJSONObject(i);
				String id=jsonObject.getString("id");
				int money=jsonObject.getInt("price");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
