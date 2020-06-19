package com.weather.ui;

import com.weather.Weather;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Integer.*;


public class WeatherWebsite {
	WebDriver driver;
	public WeatherWebsite(WebDriver driver){
		this.driver = driver;
	}

	public Weather getCityWeather(String cityName){
		WeatherWebsiteModel websiteModel = new WeatherWebsiteModel(driver);
		websiteModel.gotoHomePage();
		delay(500);
		websiteModel.pinCity(cityName);
		Weather weather = new Weather();
		weather.setTemperature(273.15f + Float.parseFloat(websiteModel.getCityTemperature(cityName)));
		weather.setHumidity(Integer.parseInt(websiteModel.getCityHumidity(cityName)));
		return weather;
	}

	void delay(int millis){
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
