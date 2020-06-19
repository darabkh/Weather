package com.weather.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
	WebDriver driver;
	@BeforeClass
	public void testSetUp() {
		System.setProperty("webdriver.chrome.driver", "BrowserDrivers/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void cleanUp() {
		delay(2000); // it is not required, just added to slow down for human visuals
		driver.close();
	}

	void delay(int millis){
		// it is not required, just added to slow down for human visuals
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
