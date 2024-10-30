Feature: Handling JavaScript Pop-ups and Alerts

  Scenario: Accepting a simple alert pop-up
    Given the user is on the JavaScript alerts page
    When the user triggers a simple alert pop-up
    Then the user accepts the alert
    And the page should show a success message for the alert

  Scenario: Dismissing a confirmation pop-up
    Given the user is on the JavaScript alerts page
    When the user triggers a confirmation pop-up
    Then the user dismisses the confirmation
    And the page should show a cancel message for the confirmation

Scenario: Entering text in a prompt pop-up
  Given the user is on the JavaScript alerts page
  When the user triggers a prompt pop-up
  Then the user enters "Test input" in the prompt
  And the page should display the entered text in the result message "Test input"
