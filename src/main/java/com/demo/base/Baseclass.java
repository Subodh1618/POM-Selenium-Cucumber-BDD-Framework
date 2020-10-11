package com.demo.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Baseclass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Baseclass() {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("src//main//resources//config.properties");
			prop.load(fis);			
		}catch(IOException e) {
			e.getMessage();
		}
	}
	
	
	public static void initialize(String browserName) {		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src//main//resources//drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FF")) {
			System.setProperty("webdriver.gecko.driver", "src//main//resources//drivers//geckodriver.exe");
			driver = new FirefoxDriver();		
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(prop.getProperty("websiteUrl"));
	}

}
