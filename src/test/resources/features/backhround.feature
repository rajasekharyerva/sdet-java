@BG
Feature: Test Background
  Background: User is on the home page
    Given User is on the home page


    Scenario: This is a scenario
      When user logs abc
        Then user should see abc

  Scenario: This is a scenario2
    When user logs abc
    Then user should see abc