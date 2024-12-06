@smoke @regression
Feature: API Tests
  @validLogin
  Scenario: Get user by ID
    Given I set the API endpoint to "https://jsonplaceholder.typicode.com/users/1"
    When I send a GET request
    Then the response status code should be 200
    And the user name should be "Leanne Graham"