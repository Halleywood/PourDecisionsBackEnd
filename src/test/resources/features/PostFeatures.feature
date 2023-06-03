Feature: An authenticated user can see all posts for a wine, can see all of the posts written by a user, update and delete their posts.
  Scenario: Reading and Writing posts about wine functionality
    Given an authenticated user
    When user searches for posts about a wine
    Then user should see a list of posts about a wine
    When a user searches for posts written by a specific user
    Then a user should see a list of posts from one user
    When a user wants to create a post about a wine
    Then a post about a wine is created
    When a user wants to update their post
    Then the post is updated
    When a a user wants to delete their post
    Then the post is deleted