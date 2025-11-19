package com.utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.BaseClass.BaseClass;

public class UtilityClass extends BaseClass{
	public static void setelement(WebElement ele,String text) {
		 ele.sendKeys(text);
		
		}
	
	public static  String getelement(WebElement ele) {
		return ele.getText();
		
		
	}
	public static void button(WebElement ele) {
		ele.click();
	}
	public static void setimplicitwait(int Sec) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Sec));
	}
	public static Actions setaction() {
		return new Actions(driver);
	}
	
	public static String takescreenshot(String textname) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String time=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_DD_hh_mm_ss"));
		String dec= projectpath +"\\Screenshots\\"+ textname + time +".png";
		File destination=new File(dec);
		
		FileUtils.copyFile(src,destination);
		return dec;
	}
	
	
}
