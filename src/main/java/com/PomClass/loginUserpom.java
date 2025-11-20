package com.PomClass;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.BaseClass;
import com.utility.UtilityClass;

public class loginUserpom extends BaseClass {
	
	  public loginUserpom() {
		  PageFactory.initElements(driver, this);
	  }
		@FindBy(xpath = "//div[@class='element-list collapse show']//li[4]")
		private WebElement lastele;
	  
		@FindBy(xpath = "//span[text()='Login']")
		private WebElement loginelement;
		
		@FindBy(xpath = "//button[@id='newUser']")
		private WebElement newuserbutton;
		
		@FindBy(xpath = "//div[text()='Elements']")
		private WebElement webelements;
		
		
		@FindBy(xpath = "//input[@id='firstname']")
		private WebElement firstname;
		
		@FindBy(xpath = "//input[@id='lastname']")
		private WebElement lastname;
		
		@FindBy(xpath = "//input[@id='userName']")
		private WebElement username;
		
		@FindBy(xpath = "//input[@id='password']")
		private WebElement password;
		
		@FindBy(xpath = "//span[@id='recaptcha-anchor']")
		private WebElement captcha;
		
		@FindBy(xpath = "//button[@id='register']")
		private WebElement register;
		
		
		
		public registerToBookStorepom scrollpage() throws IOException {
			Actions act=new Actions(driver);
			act.scrollToElement(lastele).build().perform();
			
			newuserbutton.click();
			
			String mainwindow=driver.getWindowHandle();
			Set<String> subwindow=driver.getWindowHandles();
			
			for(String subid:subwindow) {
				if(!subid.equalsIgnoreCase(mainwindow)){
					driver.switchTo().window(subid);
				}
				
			}
			UtilityClass.takescreenshot("loginUser");
			
			return new registerToBookStorepom();
			
		}
		
	}



