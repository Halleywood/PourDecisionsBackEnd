Feature: User can update/Delete their profile
  Scenario: A registered user can update their UserProfile
    Given an authenticated user
    When a user updates their UserProfile
    Then their UserProfile is updated