Feature: Login

  @Login
  Scenario: Login to the sauce demo application
    Given I navigate to the sauce demo web application
    When I enter valid credentials
    And I click the login button
    Then I should be logged in