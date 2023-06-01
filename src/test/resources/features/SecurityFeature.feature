Feature: Rest API Security Functionalities

  Scenario: An unregistered user is able to become a registered user and then login
    Given a unique email address
    When a user submits their email address and password
    Then the user is added
    When the registered user logs in with their email address and password
    Then the user can see the homepage