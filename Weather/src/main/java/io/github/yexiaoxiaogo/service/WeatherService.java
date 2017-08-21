package io.github.yexiaoxiaogo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.yexiaoxiaogo.Modle.WeatherModle;
import io.github.yexiaoxiaogo.repository.WeatherDao;

@Service
public class WeatherService {

	Logger log = LoggerFactory.getLogger(WeatherService.class);
	
	@Autowired
	private WeatherDao weatherDao;
	

	public WeatherModle getWeather(int id){
		log.info("Invoking Dao fetch method ");
		return weatherDao.fetchWeather(id);
		
	}
	

	public WeatherModle insertWeather(WeatherModle weather){
		log.info("Invoking Dao insert method for city {} ", weather.getCityName());
		return weatherDao.insertWeather(weather);
		
	}
	

	public WeatherModle updateWeather(WeatherModle weather){
		log.info("Invoking Dao update method for city {} ", weather.getCityName());
		return weatherDao.updateWeather(weather);
		
	}
	

	public List<WeatherModle> getAllWeather(){
		List<WeatherModle> weatherList = new ArrayList<WeatherModle>();
		weatherList = weatherDao.fetchAll();
		return weatherList;
	}
}
