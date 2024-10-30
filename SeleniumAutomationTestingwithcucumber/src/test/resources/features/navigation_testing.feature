Feature: Website Navigation Testing
  Automate testing for website navigation links to ensure the correct page loads.

  Scenario: Navigate from Home to Learn HTML and back to Home
    Given I am on the W3Schools Home page
    When I click on the "Learn HTML" link
    Then I should be on the "Learn HTML" page
    When I navigate back to the Home page
    Then I should be back on the Home page

  Scenario: Navigate back and forward between pages
    Given I am on the W3Schools Home page
    When I click on the "Learn HTML" link
    And I navigate back to the Home page
    And I navigate forward to the "Learn HTML" page
    Then I should be on the "Learn HTML" page again
