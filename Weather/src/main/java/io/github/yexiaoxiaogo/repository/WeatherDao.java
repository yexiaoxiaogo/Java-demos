package io.github.yexiaoxiaogo.repository;

import java.util.List;

import io.github.yexiaoxiaogo.Modle.WeatherModle;

public interface WeatherDao {

	public WeatherModle fetchWeather(int id);
	
	public WeatherModle insertWeather(WeatherModle weather);
	
	public WeatherModle updateWeather(WeatherModle weather);

	public List<WeatherModle> fetchAll();
}
