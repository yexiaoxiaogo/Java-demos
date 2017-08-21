package io.github.yexiaoxiaogo.WeatherTimer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class WeatherTimer {
	private Logger logger = LoggerFactory.getLogger(this.getClass()); // 日志输出

	/**
	 * @Description: 通过url获取天气json
	 * @param url
	 *            接口地址
	 * @return:天气json串
	 */
	private String getWeatherJson(String url) {
		try {
			URLConnection uc = new URL(url).openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream(), "utf-8"));
			StringBuffer jsonBuffer = new StringBuffer();
			String line = null;
			while (null != (line = reader.readLine())) {
				jsonBuffer.append(line);
			}
			return jsonBuffer.toString();
		} catch (IOException e) {
			// TODO: handle exception
			this.logger.error("通过" + url + "获取天气信息失败，原因如下：>>>>>>>>>>" + e.getMessage());
			return null;
		}
	}
	 /**  
	    * @Description: 尝试连接URL指定网站 
	    * @return:连接成功/失败 
	    * @date: 2017年5月27日 上午10:57:05 
	    */  
	    public boolean tryConnection() {  
	        boolean flag = false;  
	        try {  
	            URL url = new URL("https://free-api.heweather.com/v5/weather?city=杭州");  
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();  
	            connection.setRequestMethod("GET");  
	            connection.setReadTimeout(1000);  
	            connection.setConnectTimeout(1000);  
	            if (HttpStatus.SC_OK == connection.getResponseCode()) {  
	                flag = true;  
	            }  
	        } catch (IOException e) {  
	            this.logger.error("天气信息接口https://free-api.heweather.com/v5/weather?city=杭州连接失败,原因如下：>>>>>>>>>>"+ e.getMessage());  
	        }  
	        return flag;  
	    }  
	      
	    /**  
	    * @Description: 获取当前天气 
	    * @date: 2017年5月27日 上午11:00:05 
	    */  
	    private void getCurrentData() {  
	        String url = "https://free-api.heweather.com/v5/weather?city=杭州"  
	                + "&key=ea0ab8e0892a445280d83bd207286977";  
	        String jsonStr = getWeatherJson(url);  
	        if (StringUtils.isNotBlank(jsonStr)) {  
	            JSONObject jsonObj = new JSONObject(jsonStr);  
	            String success = jsonObj.getString("success");  
	            if ("1".equals(success)) {  
	                JSONObject result = jsonObj.getJSONObject("result");  
	                SimpleDateFormat myFmt = new SimpleDateFormat("yyyy-MM-dd");  
	                String todayStr = myFmt.format(new Date());  
	                WeatherInfo tempWeather = this.weatherService.getWeatherInfoByDays(todayStr);  
	                if (null == tempWeather) {  
	                    WeatherInfo weatherInfo = new WeatherInfo();  
	                    setCurrData(result, weatherInfo);  
	                } else {  
	                    setCurrData(result, tempWeather);  
	                }  
	            }  
	        }  
	    }  
}
