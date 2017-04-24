Feature: This feature details the create functionality of the application

  As I user
  I want to add a new computer
  So that I can maintain the computer database

  Information:
  * Computer names are mandatory
  * Dates for Introduced and Discontinued have the format 'yyyy-MM-dd'
  * Companies are provided as a predefined selection list

  Background:
    Given I am a valid user

  Scenario: User is able to add a new computer to the database
    Given the user has valid details for a new computer
    When the user adds the new computer
    Then the computer will be added to the database

  Scenario: User attempts to enter a computer without a computer name
    Given the user does not provide a computer name
    When the user adds the new computer
    Then the user will be informed the computer name is required

  Scenario: User attempts to enter an Introduced date in an invalid format
    Given the user provides an invalid Introduced date
    When the user adds the new computer
    Then the user will be informed the date is invalid

  Scenario: User attempts to enter an invalid discontinued date
    Given the user provides an invalid discontinued date
    When the user adds the new computer
    Then the user will be informed the discontinued date is invalid