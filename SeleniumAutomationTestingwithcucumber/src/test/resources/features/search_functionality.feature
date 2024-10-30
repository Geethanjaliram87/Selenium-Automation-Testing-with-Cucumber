Feature: Search Functionality Testing

  Scenario: Valid Search Input
    Given I am on the Amazon homepage
    When I enter "laptop" in the search bar
    And I click the search button
    Then I should see search results for "laptop"

  Scenario: Invalid Search Input
    Given I am on the Amazon homepage
    When I enter "asdjfhqwer" in the search bar
    And I click the search button
    Then I should see a message indicating no results found

  Scenario: Empty Search Input
    Given I am on the Amazon homepage
    When I enter "" in the search bar
    And I click the search button
    Then I should see a prompt to enter a search term

  Scenario: Special Characters Search Input
    Given I am on the Amazon homepage
    When I enter "@#$%" in the search bar
    And I click the search button
    Then I should see a message indicating no results found
