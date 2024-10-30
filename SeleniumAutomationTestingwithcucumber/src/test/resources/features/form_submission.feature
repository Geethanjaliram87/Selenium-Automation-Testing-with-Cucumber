Feature: Form Submission with Different Data Sets

  Scenario Outline: Submitting the form with different datasets
    Given I open the form submission page
    When I fill in the form with username "<username>" and password "<password>"
    And I click the submit button
    Then I should see "<message>"

  Examples:
    | username          | password              | message                          |
    | tomsmith          | SuperSecretPassword!  | You have logged in!             |
    | invalidUsername    | invalidPassword       | Your username is invalid!       |
    | tomsmith          | wrongPassword         | Your password is invalid!       |
   