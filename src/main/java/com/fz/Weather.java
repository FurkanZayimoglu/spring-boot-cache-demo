package com.fz;

import java.util.List;
import java.util.Map;


public class Weather {

	private Map<String, String> coord;
	private List<Map<String, String>> weather;
	private Map<String, String> main;
	private Long id;
	private String name;
	public Map<String, String> getCoord() {
		return coord;
	}
	public void setCoord(Map<String, String> coord) {
		this.coord = coord;
	}
	public List<Map<String, String>> getWeather() {
		return weather;
	}
	public void setWeather(List<Map<String, String>> weather) {
		this.weather = weather;
	}
	public Map<String, String> getMain() {
		return main;
	}
	public void setMain(Map<String, String> main) {
		this.main = main;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coord == null) ? 0 : coord.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((main == null) ? 0 : main.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((weather == null) ? 0 : weather.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		if (coord == null) {
			if (other.coord != null)
				return false;
		} else if (!coord.equals(other.coord))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (main == null) {
			if (other.main != null)
				return false;
		} else if (!main.equals(other.main))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (weather == null) {
			if (other.weather != null)
				return false;
		} else if (!weather.equals(other.weather))
			return false;
		return true;
	}
	
	
}
