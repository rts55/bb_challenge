Feature: This feature details the update functionality of the application

  As a user
  I want to update computer details
  So that I can ensure the details are correct

  Information:
  * The user can edit the computer name, introduced date, discontinued date and company

  Background:
    Given I am a valid user

  Scenario: The user updates the computer name
    Given the user selects an existing record to edit
    When the user updates the company name
    Then the updated computer will be in the database