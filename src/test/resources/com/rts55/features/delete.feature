@regression
Feature: This feature details the delete functionality of the application

  As a user
  I want to remove a computer record
  So that it is no longer recorded in the database

  Background:
    Given the user is valid

  Scenario:
    Given the user selects the record for company "ARRA"
    When the user deletes the record from the database
    Then the computer will no longer be in the database