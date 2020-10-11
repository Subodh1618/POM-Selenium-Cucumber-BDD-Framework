package com.demo.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.base.Baseclass;

public class SearchFlightPage extends Baseclass{
	
	//Page Objects
	@FindBy(id="RoundTrip")
	WebElement roundTripRadioButton;
	
	@FindBy(xpath="//form[contains(text(),'Search flights')]")
	WebElement searchFlightText;
	
	@FindBy(xpath="//input[@id='FromTag']")
	WebElement fromTextBox;
	
	@FindBy(xpath="//input[@id='ToTag']")
	WebElement toTextBox;
	
	@FindBy(xpath="//input[@id='DepartDate']")
	WebElement departDate;
	
	@FindBy(xpath="//input[@id='ReturnDate']")
	WebElement returnDate;
	
	@FindBy(xpath="//input[@id='SearchBtn']")
	WebElement searchBtn;
	
	
	
	//Initializing Page Objects
	public SearchFlightPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Actions
	
	public boolean verifySearchFlightPageDisplayed() {
		
		return searchFlightText.isDisplayed();		
	}
	
	
	public SearchFlightResultPage searchFlights(String tripType, String departFrom, String ArriveTo, String departureDate, String returnOnDate) {
		if(tripType.equalsIgnoreCase("roundtrip")) {
			roundTripRadioButton.click();
		}
		fromTextBox.sendKeys(departFrom);
		toTextBox.sendKeys(ArriveTo);
		departDate.sendKeys(departureDate);
		returnDate.sendKeys(returnOnDate);
		searchBtn.click();
		
		return new SearchFlightResultPage();
	}
		

}
