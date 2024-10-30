Feature: Automate Form Validation Messages

  Scenario Outline: Validate registration form with invalid data
    Given the user is on the registration page
    When the user enters invalid "<email>" and "<password>"
    And clicks on the register button
    Then the system should display "<expectedMessage>" validation message

    Examples:
      | email              | password | expectedMessage                               |
      |                    |          | Error: Please provide a valid email address.  |
      | user23@example.com |          | Error: Please enter an account password.      |
      | user423@example.com|          | Error: Please enter an account password.      |
