package com.PomClass;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.BaseClass.BaseClass;
import com.utility.UtilityClass;

public class elementpagepom extends BaseClass{

	public elementpagepom() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath = "//div[text()='Elements']")
	private WebElement elementbutton;
	
	@FindBy (xpath = "//div[@class='element-list collapse show']//child::li")
	private List<WebElement> elementbuttons;
	
	@FindBy (xpath = "//div[contains(text(),'Book Store')]")
	private WebElement lastele;

	@FindBy (xpath = "//div[@class='element-list collapse show']//ul//li[1]")   //1st element in list of elements field....start xpath's
	private WebElement textbox;
	
	@FindBy (xpath = "//input[@id='userName']")   
	private WebElement fullname;
	
	@FindBy (xpath = "//input[@id='userEmail']")   
	private WebElement email;
	
	@FindBy (xpath = "//textarea[@id='currentAddress']")   
	private WebElement currentaddress;
	
	@FindBy (xpath = "//textarea[@id='permanentAddress']")   
	private WebElement permanentaddress;
	
	@FindBy (xpath = "//button[@id='submit']")
	private WebElement submittext;
	
	
	@FindBy (xpath = "//span[text()='Check Box']")      //2nd element in list of elements field....start xpath's       
	private WebElement checkbox;
	
	@FindBy(xpath = "//button[@title='Expand all']")
	private WebElement expandbutton;
	
	@FindBy(xpath = "//button[@title='Collapse all']")
	private WebElement collapsebutton;

	@FindBy(xpath = "(//span[@class='rct-checkbox'])[1]")
	private WebElement homecheckbox;
	
	@FindBy(xpath = "//div[@id='result']")
	private WebElement massage;
	
	@FindBy (xpath = "//span[text()='Radio Button']")         //3rd element in list of elements field....start xpath's      
	private WebElement radiobutton;
	
	@FindBy (xpath = "//span[text()='Web Tables']")
	private WebElement webtables;
	
	@FindBy (xpath = "//span[text()='Buttons']")
	private WebElement buttons;
	
	@FindBy (xpath = "//span[text()='Links']")
	private WebElement links;
	
	@FindBy (xpath = "//span[text()='Broken Links - Images']")
	private WebElement brokenlinks;
	
	@FindBy (xpath = "//span[text()='Upload and Download']")
	private WebElement uploadanddownload;
	
	@FindBy (xpath = "//span[text()='Dynamic Properties']")
	private WebElement dynamicproperties;
	
	
	
	public void textelement() throws IOException {
		UtilityClass.button(elementbutton);
		UtilityClass.button(textbox);
		
		String mainwindow=driver.getWindowHandle();
		Set<String> subwindow=driver.getWindowHandles();
		
		for(String elewindow:subwindow) {
			if(!elewindow.equalsIgnoreCase(mainwindow)) {
				System.out.println("window id is: "+elewindow.toString());
				driver.switchTo().window(elewindow);
			}
		}
	
		UtilityClass.setaction().scrollToElement(lastele).build().perform();
		UtilityClass.setelement(fullname, "Rohit");
		UtilityClass.setelement(email, "rohitsharma@gmail.com");
		UtilityClass.setelement(currentaddress, "Abc nagar,near mata temple,Mumbai");
		UtilityClass.setelement(permanentaddress, "Abc nagar,near mata temple,Mumbai");
		UtilityClass.setaction().scrollToElement(lastele).build().perform();
		UtilityClass.button(submittext);
		UtilityClass.takescreenshot("Succesful_text_field");
		
		
	}


	public void checkboxelement() throws IOException {
		UtilityClass.button(checkbox);
		
		String mainwindow=driver.getWindowHandle();
		Set<String> subwindow=driver.getWindowHandles();
		for(String elewindow:subwindow) {
			if(!elewindow.equalsIgnoreCase(mainwindow)) {
				driver.switchTo().window(elewindow);
			}
		}
		UtilityClass.setaction().scrollToElement(lastele).build().perform();
		UtilityClass.button(expandbutton);
		UtilityClass.button(homecheckbox);
		if(collapsebutton.isDisplayed()) {
			UtilityClass.button(collapsebutton);
			System.out.print("Message Display: "+massage.getText());
		}
		UtilityClass.takescreenshot("Successful_checkbox_field");
		
		
	}
}
