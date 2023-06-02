Feature: CRUD API calls
  Scenario: a logged in user can see all wines and individual wine details
    Given an authenticated user
    When user searches for all wines
    Then they should see a list of wines
    When a user searches for a single wine
    Then they should see details about that wine