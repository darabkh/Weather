package com.weather.api;

import com.weather.Weather;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class WeatherApi {

	public Weather getCityWeather(String cityName) {
		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/";
		Map<String, String> paramMap = new HashMap();
		String appid = "7fe67bf08c80ded756e598d6f8fedaea";
		paramMap.put("q", cityName);
		paramMap.put("appid", appid);
		Response response =  given().params(paramMap).when().get("/weather");
		Map<String, Object> jsonResponse = response.jsonPath().getMap("main");
		Weather weather = new Weather();
		weather.setTemperature((Float)jsonResponse.get("temp"));
		int humidity = ((Integer)jsonResponse.get("humidity"));
		weather.setHumidity(humidity);
		return weather;
	}

}
