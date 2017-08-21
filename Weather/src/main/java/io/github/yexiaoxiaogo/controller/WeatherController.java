package io.github.yexiaoxiaogo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.github.yexiaoxiaogo.Modle.WeatherDataModle;
import io.github.yexiaoxiaogo.Modle.WeatherModle;
import io.github.yexiaoxiaogo.service.WeatherService;

@RestController
@RequestMapping("/v1/weather")
public class WeatherController {
	
	Logger log = LoggerFactory.getLogger(WeatherController.class);
	
	@Autowired
	private WeatherService weatherService;

	@RequestMapping(value="/fetchWeather/{id}", method=RequestMethod.GET)
	public WeatherModle getWeather(@PathVariable(value="id") int id){
		log.info("Invoking Weather Service to Get City::{}",id);
		return weatherService.getWeather(id);
	}

	
	@RequestMapping(value="/insertWeather", method= RequestMethod.POST)
	public WeatherModle insertWeather(@RequestBody WeatherModle weather){
		log.info("Invoking Weather Service to Save City::{}",weather.getCityName());
		
		Set<WeatherDataModle> dataModel = new HashSet<WeatherDataModle>();
		for(WeatherDataModle w : weather.getWeatherData()){
			w.setWeatherModel(weather);
			dataModel.add(w);
		}
		
		//weather.setWeatherData(dataModel);
		
		return weatherService.insertWeather(weather);	
	}

	
	@RequestMapping(value="/updateWeather", method= RequestMethod.PUT)
	public WeatherModle updateWeather(@RequestBody WeatherModle weather){
		log.info("Invoking Weather Service to Update City::{}",weather.getCityName());
		
		Set<WeatherDataModle> dataModel = new HashSet<WeatherDataModle>();
		for(WeatherDataModle w : weather.getWeatherData()){
			w.setWeatherModel(weather);
			dataModel.add(w);
		}
		
	//	weather.setWeatherData(dataModel);
		
		return weatherService.updateWeather(weather);
		
	}


	@RequestMapping(value="/getAllWeather", method= RequestMethod.GET)
	public List<WeatherModle> getAllWeather(){
		return weatherService.getAllWeather();
		
		
	}

}
