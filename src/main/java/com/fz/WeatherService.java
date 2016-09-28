package com.fz;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriTemplate;

@Component
public class WeatherService {

	private static final Logger logger = LoggerFactory.getLogger(WeatherService.class);
	
	private static final String WEATHER_URL =
			"http://api.openweathermap.org/data/2.5/weather?q={city},{country}&APPID={key}";
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@Value("${weather.api.key}")
	private String apiKey;
	
	@Cacheable("weather")
	public Weather getWeather(String country, String city) {
		logger.info("{}/{} için hava durumu bilgisi isteniyor.", country, city);
		URI url = new UriTemplate(WEATHER_URL).expand(city, country, this.apiKey);
		RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
		ResponseEntity<Weather> exchange = this.restTemplateBuilder.build().exchange(request, Weather.class);
		return exchange.getBody();
	}
}
