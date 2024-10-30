Feature: Open a browser and visit a website

  Scenario: User navigates to Google homepage
    Given I open the browser
    When I go to "https://www.google.com"
    Then I should see the Google homepage
