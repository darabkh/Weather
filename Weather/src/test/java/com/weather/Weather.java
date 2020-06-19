package com.weather;

import java.util.Objects;

public class Weather {

	float temperature;
	int humidity;

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Weather weather = (Weather) o;
		return Objects.equals(temperature, weather.temperature) &&
				Objects.equals(humidity, weather.humidity);
	}

	public boolean equalsVariance(Object o, float tempVariance, int humidityVariance) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Weather weather = (Weather) o;
		return (Math.abs(temperature-weather.temperature) <= tempVariance) &&
				(Math.abs(humidity - weather.humidity)<= humidityVariance);
	}

	@Override
	public int hashCode() {
		return Objects.hash(temperature, humidity);
	}
}
