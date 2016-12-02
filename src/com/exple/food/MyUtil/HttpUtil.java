package com.exple.food.MyUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


public class HttpUtil {

	public static String HttpConnect(String Url_path/*,
			getDataFromInternet dataFromInternet*/) {
		
		HttpPost httpPost=new HttpPost(Url_path);
		
		List<NameValuePair> param=new ArrayList<NameValuePair>();
		param.add(new BasicNameValuePair("admin", "yang"));
		param.add(new BasicNameValuePair("password", "123"));
//		httpPost.setEntity(new UrlEncodedFormEntity(param,"utf-8"));
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(param,"utf-8"));
			
			HttpClient client=new DefaultHttpClient();
			
			try {
				HttpResponse httpResponse=client.execute(httpPost);
				
				if(httpResponse.getStatusLine().getStatusCode()==200){
					InputStream inputStream=httpResponse.getEntity().getContent();
//					dataFromInternet.getData(parseInputstream(inputStream));
					return parseInputstream(inputStream);
				}
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	private static String parseInputstream(InputStream inputStream) {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
		StringBuffer stringBuffer=new StringBuffer();
		String line;
		try {
			while((line=bufferedReader.readLine())!=null){
				stringBuffer.append(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringBuffer.toString();
	}

}
