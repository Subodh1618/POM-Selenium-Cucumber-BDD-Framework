package com.demo.cucumber.stepDefinition;

import org.testng.Assert;

import com.demo.base.Baseclass;
import com.demo.pageObjects.ReviewItineraryPage;
import com.demo.pageObjects.SearchFlightPage;
import com.demo.pageObjects.SearchFlightResultPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookFlight_StepDefinition extends Baseclass{
	
	SearchFlightPage searchFlightPage;
	SearchFlightResultPage flightResultPage;
	ReviewItineraryPage reviewItineraryPage;	
	
	@Given("^Launch the website on browser \"([^\"]*)\"> and verify search Flight page is displayed$")
	public void launch_the_website_on_browser_and_verify_search_Flight_page_is_displayed(String browserName) throws Throwable {
		Baseclass.initialize(browserName);
		searchFlightPage = new SearchFlightPage();
		Assert.assertEquals(searchFlightPage.verifySearchFlightPageDisplayed(), true);   
	}

	@When("^Following details are submitted for trip to search flight: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void following_details_are_submitted_for_trip_to_search_flight(String tripType, String departFrom, String arrivalTo, String departDate, String returnDate) throws Throwable {
		flightResultPage = searchFlightPage.searchFlights(tripType, departFrom, arrivalTo, departDate, returnDate);
	}

	@Then("^Verify result page is displayed for flights$")
	public void verify_result_page_is_displayed_for_flights() throws Throwable {
		boolean actual = flightResultPage.verifySearchFlightResultPageDisplayed();
		Assert.assertEquals(actual, true);
	}

	@Then("^Click on book button to book the flight$")
	public void click_on_book_button_to_book_the_flight() throws Throwable {
		reviewItineraryPage = flightResultPage.clickOnBookFlightBtn();
	}

	@Then("^Verify Review Itinerary page is displayed and click on continue button$")
	public void verify_Review_Itinerary_page_is_displayed() throws Throwable {
		boolean actual = reviewItineraryPage.verifyReviewItineraryPageDisplayed();
		Assert.assertEquals(actual, true);
		reviewItineraryPage.confirmItinerary();
	}

	@Then("^Fill the contact details: \"([^\"]*)\", \"([^\"]*)\" and traveller details: \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\" and click on continue payment button$")
	public void fill_the_contact_details_and_traveller_details_and_click_on_continue_payment_button(String mobNo, String emailId, String firstName, String lastName, String gender, String nationality, String dob) throws Throwable {
		boolean contactDetailFlag = reviewItineraryPage.verifyContactDetailsSectionDisplayed();
		Assert.assertEquals(contactDetailFlag, true);
		reviewItineraryPage.fillContactDetails(mobNo, emailId);
		boolean travellerDetailFlag = reviewItineraryPage.verifyTravellerDetailsSectionDeisplayed();
		Assert.assertEquals(travellerDetailFlag, true);
		reviewItineraryPage.fillTravellerDetails(firstName, lastName, gender, nationality, dob);		
	}

}
