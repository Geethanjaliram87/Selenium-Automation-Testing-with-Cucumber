# src/test/resources/features/login.feature

Feature: Login Page Testing
  As a user, I want to log in to the website and receive feedback on success or failure.

  Scenario: Valid login
    Given I open the login page
    When I enter valid credentials
    And I click the login button
    Then I should be redirected to the secure area

  Scenario: Invalid login
    Given I open the login page
    When I enter invalid credentials
    And I click the login button
    Then I should see an error message
