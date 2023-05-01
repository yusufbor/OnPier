
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
      | Anrede         |
      | Vorname        |
      | Nachname       |
      | E-Mail-Adresse |
      | Kontoinhaber   |
      | IBAN           |


    Examples:
      | title | firstName | lastName | email                    | accountHolder | IBAN                          |
      | Herr  | John      | Doe      | anything%s@email.company | John Doe      | ZBDE 4578 9089 6556 4334 5400 |

  @wip
  Scenario Outline: user can not enter invalid name
    When user enters a letter as a vorname "<vornameLetter>"
    And user clicks another field to fill and proceed
    Then error message appears under the Vorname field

    Examples:
      |vornameLetter|
      |    a        |

  @happyPath
  Scenario Outline: user can not enter invalid surname
    When user enters a letter as nachname "<nachnameLetter>"
    And user clicks another placeholder to fill and proceed
    Then error message appears under the Nachname field
    Examples:
      | nachnameLetter |
      | a              |

  @happyPath
  Scenario Outline: Kontoinhaber(account holder) and the person name can be different
    When user selects title "<title>"
    And user fills "Vorname" as "<firstName>"
    And user fills "Nachname" as "<lastName>"
    And user fills "E-Mail-Adresse" as "<email>"
    And user fills "Kontoinhaber" as "<accountHolder>"
    And user fills "IBAN" as "<IBAN>"
    And user clicks on Weiter button
    Then user verifies account holder name and person name can be different
    Examples:
      | title | firstName | lastName | email                    | accountHolder | IBAN                          |
      | Herr  | John      | Doe      | anything%s@email.company | Elif Basbug   | ZBDE 4578 9089 6556 4334 5400 |


  @happyPath
  Scenario Outline: User fills the form with invalid email
    When user selects title "<title>"
    And user fills "Vorname" as "<firstName>"
    And user fills "Nachname" as "<lastName>"
    And user fills "E-Mail-Adresse" as "<email>"
    And user fills "Kontoinhaber" as "<accountHolder>"
    And user fills "IBAN" as "<IBAN>"
    And user clicks on Weiter button
    Then the form is created with invalid email
    Examples:
      | title | firstName | lastName | email                     | accountHolder | IBAN                          |
      | Herr  | John      | Doe      | anything@..gmail...com....| John Doe      | ZBDE 4578 9089 6556 4334 5400 |
      | Herr  | John      | Doe      | anything@..anythingcom....| John Doe      | ZBDE 4578 9089 6556 4334 5400 |


  @happyPath
  Scenario: User cancels form
    And user clicks on Zurück button
    Then user lands on previous page









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

