Feature: Book Flight for an Adult

  @Run
  Scenario Outline: Process automates the steps to book a flight till the payment page displayed
    Given Launch the website on browser "<BrowserName"> and verify search Flight page is displayed
    When Following details are submitted for trip to search flight: "<tripType>", "<departFrom>", "<ArrivalTo>", "<departDate>", "<returnOn>"
    Then Verify result page is displayed for flights
    And Click on book button to book the flight
    Then Verify Review Itinerary page is displayed and click on continue button
    And Fill the contact details: "<mobNo>", "<email>" and traveller details: "<firstName>", "<lastName>", "<gender>", "<nationality>", "<dob>" and click on continue payment button

    Examples: 
      | BrowserName | tripType | departFrom | ArrivalTo | departDate        | returnOn          | mobNo      | email                      | firstName | lastName | gender | nationality | dob        |
      | chrome      | round    | BLR        | IXR       | Sat, 28 Nov, 2020 | Thu, 24 Dec, 2020 | 8093239980 | subodh.kumar9251@gmail.com | subodh    | kumar    | Male   | India       | 19/07/1992 |
