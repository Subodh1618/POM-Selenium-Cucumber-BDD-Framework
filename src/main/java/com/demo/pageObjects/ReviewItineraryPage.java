package com.demo.pageObjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.demo.base.Baseclass;

public class ReviewItineraryPage extends Baseclass{

	//Page Objects	
	@FindBy(xpath="//div[contains(text(),'Review your itinerary')]")
	WebElement reviewItineraryText;
	
	@FindBy(xpath="//button[contains(text(), 'Continue']")
	WebElement continueBookingBtn;
	
	@FindBy(xpath="//div[contains(text(),'Add contact details')]")
	WebElement addContactDetailsText;
	
	@FindBy(xpath="//div[contains(text(),'Add traveller details')]")
	WebElement addTravellerDetailsText;
	
	@FindBy(xpath="//input[@placeholder='Mobile number']")
	WebElement mobileNoTextBox;
	
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement emailAddressTextBox;
	
	@FindBy(xpath="//input[@placeholder='First name']")
	WebElement firstNameTextBox;
	
	@FindBy(xpath="//input[@placeholder='Last name']")
	WebElement lastNameTextBox;
	
	@FindBy(xpath="//button[contains(text(), 'Gender']")
	WebElement genderDropDown;
	
	@FindBy(xpath="//input[@placeholder='Nationality (e.g. India)']")
	WebElement nationalityTextBox;
	
	@FindBy(xpath="//input[@placeholder='DD / MM / YYYY']")
	WebElement dobTextBox;
	
	@FindBy(xpath="//button[contains(text(), 'Continue to payment']")
	WebElement continueToPaymentBtn;
	
	
	//Initializing Page Objects
	public ReviewItineraryPage() {
		PageFactory.initElements(driver, this);
	}
		
		
		
	//Actions
	
	public boolean verifyReviewItineraryPageDisplayed() {
		
		return reviewItineraryText.isDisplayed();
	}
	
	public boolean verifyContactDetailsSectionDisplayed() {
			
			return addContactDetailsText.isDisplayed();
	}
	
	public boolean verifyTravellerDetailsSectionDeisplayed() {
		
		return addTravellerDetailsText.isDisplayed();
	}
	
	public void selectGender(String text) {
		
	}
	
	public void confirmItinerary() {
		continueBookingBtn.click();
	}
	
	public void fillContactDetails(String mobNo, String email) {
		mobileNoTextBox.sendKeys(mobNo);
		emailAddressTextBox.sendKeys(email);
		continueBookingBtn.click();
	}
	
	public void fillTravellerDetails(String firstname, String lastname, String genderVal, String nationality, String dob) {
		firstNameTextBox.sendKeys(firstname);
		lastNameTextBox.sendKeys(lastname);
		Select sel = new Select(genderDropDown);
		sel.selectByVisibleText(genderVal);
		if(dobTextBox.isDisplayed()) {
			dobTextBox.sendKeys(dob);
		}
		if(nationalityTextBox.isDisplayed()) {
			nationalityTextBox.sendKeys(nationality);
		}
		continueToPaymentBtn.click();
	}
		
	
}
