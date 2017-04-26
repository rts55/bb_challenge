Feature: This feature details the search functionality of the application

  As a user
  I want to be able to search computers
  So that I can edit or delete the record

  Background:
    Given the user is valid

  Scenario: The user is able to search for a computer in the database
    Given the user provides the computer name "ACE"
    When the user searches for the computer
    Then the user will be able to select the computer and edit the details
    
  Scenario: The user searches for a company that is not in the database
    When the user provides the computer name "Mega Master"
    When the user searches for the computer
    Then the user will be informed there are no records to display