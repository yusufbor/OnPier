@wip
Feature: Checking the related web page

  Background: For the scenarios in the feature file, user should be on the second page of the form
    Given user is on Persönliche Daten eingeben page
    When user selects vehicle class
    And user selects flexPramieBentragen package
    And user uploads images of vehicle registration
    And user clicks on "Weiter " button
    Then I verify title as "THG Prämie"


  @happyPath
  Scenario Outline: Form submission
    When user selects title "<title>"
    And user fills "Vorname" as "<firstName>"
    And user fills "Nachname" as "<lastName>"
    And user fills "E-Mail-Adresse" as "<email>"
    And user fills "Kontoinhaber" as "<accountHolder>"
    And user fills "IBAN" as "<IBAN>"
    And user clicks on Weiter button
    Then form is created with given personal information

    Examples:
      | title | firstName | lastName | email                    | accountHolder | IBAN                          |
      | Herr  | John      | Doe      | anything%s@email.company | John Doe      | ZBDE 4578 9089 6556 4334 5400 |

  Scenario: user can not enter invalid name
    When user enters a letter as a name
    Then error message appears under the Vorname field


  Scenario: user can not enter invalid surname
    When user enters a letter as a surname
    Then error message appears under the Nachname field


  Scenario: Kontoinhaber(account holder) and the person name can be different
    When user enters a different account holder name
    Then user verifies account holder name and person name can be different


  Scenario: Kontoinhaber(account holder) and the person name can be same
    When user enters the Account holder name
    Then user verifies Account holder name and person name can be same

  Scenario: User fills the form with invalid email
    When user enters invalid email
    And user clicks on Weiter button
    Then the form is created with invalid email


  Scenario:  user can create another account with the same email
    When user enters  the same email
    And user clicks on Weiter button
    Then new user is created with the same email


  Scenario Outline: Account is created with valid IBAN
    When user enters the "<IBAN>" number in the IBAN box
    And user clicks on Weiter button
    Then account is created

    Examples:
      | IBAN                                                |
      | 1234 1234 1234 1                                    |
      | 1234 1234 1234 12                                   |
      | 1234 1234 1234 1234 1234                            |
      | 1234 1234 1234 1234 1234 1234 1234 1234 1234 1234   |
      | 1234 1234 1234 1234 1234 1234 1234 1234 1234 1234 1 |


  Scenario Outline: Account is not created with invalid IBAN
    When user enters the invalid "<IBAN>" number in the IBAN box
    Then warning message is on screen, under the IBAN box

    Examples:
      | IBAN           |
      | 1234 1234 1234 |
      | 1234 1234 12   |
      | 1234 1234      |
      | 1234 1         |


  Scenario: User cancels form

