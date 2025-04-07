@PurchaseItems
Feature: As a user, I want to be able to purchase items

  Background: Login to the sauce demo application
    Given I navigate to the sauce demo web application
    When I enter valid credentials
    And I click the login button
    Then I should be logged in

  Scenario: Purchase item
    When I add the item "Sauce Labs Bike Light" to my shopping cart
    And I click the shopping cart icon