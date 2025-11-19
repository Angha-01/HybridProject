package com.PomClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.BaseClass.BaseClass;
import com.utility.UtilityClass;

public class registerToBookStorepom extends BaseClass{
	
	public  registerToBookStorepom() {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//input[@id='firstname']")
	private WebElement firstname;
	
	@FindBy(xpath = "//input[@id='lastname']")
	private WebElement lastname;
	
	@FindBy(xpath = "//input[@id='userName']")
	private WebElement setusername;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement setpassword;
	
	@FindBy(xpath = "//iframe[@title='reCAPTCHA']")				//checkbox capcha in iframe so swich 1st then click on checkbox
	private WebElement checkboxiframe;
	
	@FindBy(xpath = "//span[@role='checkbox']")
	private WebElement checkbox;
	
	@FindBy(xpath = "//button[@id='register']")
	private WebElement registerbutton;
	
	@FindBy(xpath = "//div[@class='element-list collapse show']//li[4]")
	private WebElement lastele;
  
	
	public void registeruser() throws InterruptedException {
		UtilityClass.setaction().scrollToElement(lastele).build().perform();
		
		UtilityClass.setelement(firstname, "Rahul");
		UtilityClass.setelement(lastname, "Jain");
		UtilityClass.setelement(setusername, "RahulJain");
		UtilityClass.setelement(setpassword, "RahulJain@123");
		UtilityClass.setaction().scrollToElement(lastele).build().perform();
		
		//UtilityClass.setaction().scrollToElement(lastele).build().perform();
		
		driver.switchTo().frame(checkboxiframe);
		checkbox.click();
		driver.switchTo().defaultContent();
		registerbutton.click();
		
		
	}
	@FindBy(xpath = "//button[@id='gotologin']")
	private WebElement backtologin;
	
	@FindBy(xpath = "//input[@id='userName']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@id='login']")
	private WebElement loginbutton;
	
	@FindBy(xpath = "//span[text()='Book Store']")
	private WebElement bookstore;
	
	@FindBy(xpath = "//a[contains(text(),'Git Pocket')]")
	private WebElement firstbookname;
	
	
	public void backTologin(String empusername,String emppassword) {
		backtologin.click();
		UtilityClass.setelement(username, empusername);
		UtilityClass.setelement(password, emppassword);
	
		UtilityClass.setaction().scrollToElement(lastele).build().perform();
		
		loginbutton.click();
	}
	
}
