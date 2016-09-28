package com.fz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherClient {

	private static final Logger logger = LoggerFactory.getLogger(WeatherClient.class);
	
	@Autowired
	WeatherService service;
	
	@Scheduled(fixedRate = 10000, initialDelay = 10000)
	public void checkWeather() {
		Weather weather = service.getWeather("tr", "Istanbul");
		logger.info("Istanbul için hava durumu: {} - Sıcaklık: {}", weather.getWeather().get(0).get("description"), getCelsiusTemperature(weather.getMain().get("temp")));
	}
	
	public String getCelsiusTemperature(String kelvin) {
		double celsiusTemp = Double.parseDouble(kelvin) - 273.15;
		return String.format("%4.2f", celsiusTemp);
	}
}
