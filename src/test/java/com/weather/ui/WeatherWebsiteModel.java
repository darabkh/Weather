package com.weather.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class WeatherWebsiteModel {
	WebDriver driver;
	public WeatherWebsiteModel(WebDriver driver){
		this.driver = driver;
	}

	public void gotoHomePage(){
		driver.get("https://social.ndtv.com/static/Weather/report/");
	}

	public void pinCity(String cityName){
		driver.findElement(By.id("searchBox")).sendKeys(cityName);
		WebElement checkbox = driver.findElement(By.id(cityName));
		if(!checkbox.isSelected()) checkbox.click();
	}

	public String getCityTemperature(String cityName) {
		String cityPath = "//div[@title='" + cityName + "']";
		String cityTemp = "//div[@title='" + cityName + "']//span[@class='tempRedText']";
		driver.findElement(By.xpath(cityPath)).click();
		String temp = driver.findElement(By.xpath(cityTemp)).getText();
		temp = temp.replaceAll("[^0-9.]", "");
		return  temp;
	}

	public String getCityHumidity(String cityName) {
		String cityHumidity = "//span/b[contains(text(), 'Humidity')]";
		String humidity = driver.findElement(By.xpath(cityHumidity)).getText();
		humidity = humidity.replaceAll("[^0-9.]", "");
		return  humidity;
	}

}
