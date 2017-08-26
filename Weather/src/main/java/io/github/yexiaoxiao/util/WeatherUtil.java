package io.github.yexiaoxiao.util;
/*
 * 获取天气数据类
 */

import java.net.URL;

import org.springframework.context.annotation.Primary;

public class WeatherUtil {

	private static String KEY = "ea0ab8e0892a445280d83bd207286977";
	
	public static String getResult(String cityname) {
		String result = "";
		String Url = "https://free-api.heweather.com/v5/weather?city="+cityname+"&key="+KEY;
		try {
			URL url = new URL(Url);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
}
