package com.demo.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.base.Baseclass;

public class SearchFlightResultPage extends Baseclass{
	
	
	//Page Objects	
	@FindBy(xpath="//button[contains(text(),'Book')]")
	WebElement bookFlightBtn;
	
	//Initializing Page Objects
	public SearchFlightResultPage() {
		PageFactory.initElements(driver, this);
	}
		
		
		
	//Actions
	
	public boolean verifySearchFlightResultPageDisplayed() {
		
		return bookFlightBtn.isDisplayed();
	}
	
	
	public ReviewItineraryPage clickOnBookFlightBtn() {
		
		bookFlightBtn.click();
		return new ReviewItineraryPage();
	}

}
