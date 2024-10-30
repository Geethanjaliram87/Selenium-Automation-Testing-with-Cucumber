Feature: Automate Browser Actions

  Scenario: Refresh the page
    Given I am on the W3Schools homepage
    When I refresh the page
    Then I should see the page reloaded successfully

  Scenario: Navigate back to the previous page
    Given I am on a different page
    When I navigate back
    Then I should see the W3Schools homepage

  Scenario: Manage browser window
    Given I am on the W3Schools homepage
    When I maximize the window
    Then the browser window should be maximized
    When I minimize the window
    Then the browser window should be minimized
