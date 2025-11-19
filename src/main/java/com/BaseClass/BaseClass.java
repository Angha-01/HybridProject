package com.BaseClass;

import java.time.Duration;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

public class BaseClass {
	
		public static WebDriver driver;
		public static String projectpath=System.getProperty("user.dir");
		
		public WebDriver launchweb() {
			
			driver=new ChromeDriver();
			driver.get("https://demoqa.com/login");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			return driver;
			
			
			
		}
	
	}


