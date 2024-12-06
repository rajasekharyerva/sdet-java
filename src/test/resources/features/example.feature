Feature: User Login

  Background:
    Given the user is on the login page
    And the user has a valid account

  Scenario: User logs in with valid credentials
    When the user enters valid credentials
    Then the user should be redirected to the homepage

  Scenario: User logs in with invalid credentials
    When the user enters invalid credentials
    Then an error message should be displayed

  Scenario: Another scenario
    When the user tries to log in again
    Then the user should see a different message
