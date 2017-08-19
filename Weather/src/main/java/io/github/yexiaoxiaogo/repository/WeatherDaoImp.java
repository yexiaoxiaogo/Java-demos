package io.github.yexiaoxiaogo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.github.yexiaoxiaogo.Modle.WeatherModle;

@Repository("weatherDao")
@Transactional(propagation = Propagation.REQUIRED)
public class WeatherDaoImp implements WeatherDao{

	Logger log = LoggerFactory.getLogger(WeatherDaoImp.class);

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public WeatherModle fetchWeather(int id) {
		log.info("weather data fetch using Entity manager with id {}",id);
		return entityManager.find(WeatherModle.class, id);
	}

	@Override
	public WeatherModle insertWeather(WeatherModle weather) {
		log.info("weather data persisted using entity for {}",weather.getCityName());
		entityManager.persist(weather);
		entityManager.flush();
		return weather;
	}

	@Override
	public WeatherModle updateWeather(WeatherModle weather) {
		log.info("weather data updated using entity for {}",weather.getCityName());
		WeatherModle weatherResult = entityManager.find(WeatherModle.class, weather.getId());
		weatherResult.setCityName(weather.getCityName());
		weatherResult.setState(weather.getState());
		weatherResult.setZipcode(weather.getZipcode());
		weatherResult.setWeatherData(weather.getWeatherData());
		entityManager.merge(weatherResult);
		entityManager.flush();
		return weatherResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WeatherModle> fetchAll() {
		List<WeatherModle> weatherList = entityManager.createQuery("from WeatherModel").getResultList();
		return weatherList;
	}

}
