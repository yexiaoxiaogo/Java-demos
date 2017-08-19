package io.github.yexiaoxiaogo.Modle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="weatherData")
public class WeatherDataModle {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "WEATHERID")
	private int weatherId;
	
	@Column(name= "MINTEMP")
	private int minTemperature;
	
	@Column(name= "MAXTEMP")
	private int maxTemperature;
	
	@Column(name= "HUMIDITY")
	private String humidity;
	
	@Column(name= "WIND")
	private String wind;
	
	@ManyToOne
	@JoinColumn(name= "ID",nullable= false)
	@JsonIgnore
	private WeatherModle weatherModel;
	
	
	public int getWeatherId() {
		return weatherId;
	}
	public void setWeatherId(int weatherId) {
		this.weatherId = weatherId;
	}
	public int getMinTemperature() {
		return minTemperature;
	}
	public void setMinTemperature(int minTemperature) {
		this.minTemperature = minTemperature;
	}
	public int getMaxTemperature() {
		return maxTemperature;
	}
	public void setMaxTemperature(int maxTemperature) {
		this.maxTemperature = maxTemperature;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getWind() {
		return wind;
	}
	public void setWind(String wind) {
		this.wind = wind;
	}
	public WeatherModle getWeatherModel() {
		return weatherModel;
	}
	public void setWeatherModel(WeatherModle weatherModel) {
		this.weatherModel = weatherModel;
	}
	
}
