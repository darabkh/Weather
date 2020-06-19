package com.weather.test;

import com.weather.Weather;
import com.weather.api.WeatherApi;
import com.weather.ui.WeatherWebsite;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestWeather extends TestBase{

	@DataProvider(name="cityNames")
	public Object[][] getDataFromDataprovider(){
		return new Object[][]
				{
						{"1", "New Delhi"},
						{"2", "Bengaluru"}
				};

	}

	@Test(dataProvider="cityNames")
	public void testWeather(String testId, String cityName) {
		WeatherWebsite weatherWebsite = new WeatherWebsite(driver);
		WeatherApi weatherApi = new WeatherApi();

		Weather ui = weatherWebsite.getCityWeather(cityName);
		Weather api = weatherApi.getCityWeather(cityName);
		String message = "UI temp = " + ui.getTemperature() + "K and API temp = " + api.getTemperature() +
				"K, UI humidity = " + ui.getHumidity() + "% and API humidity = " + api.getHumidity() + "%";
		Assert.assertTrue(weatherVariance(ui, api), message);
	}

	boolean weatherVariance(Weather ui, Weather api){
		int tempVariance = 2;
		int humidityVariance = 10;

		return ui.equalsVariance(api, tempVariance, humidityVariance);
	}

}
