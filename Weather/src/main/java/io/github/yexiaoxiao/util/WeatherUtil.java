package io.github.yexiaoxiao.util;
/*
 * 获取天气数据类
 */

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.context.annotation.Primary;

public class WeatherUtil {

	private static String KEY = "ea0ab8e0892a445280d83bd207286977";
	
	public static String getResult(String cityname) {
		String result = "";
		String Url = "https://free-api.heweather.com/v5/weather?city="+cityname+"&key="+KEY;
		try {
			//创建URL对象
			URL url = new URL(Url);
			//打开网络链接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			InputStream inputStream = connection.getInputStream();
			InputStreamReader iStreamReader = new InputStreamReader(inputStream,"UTF-8");
			BufferedReader bufferedReader = new BufferedReader(iStreamReader);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
}
