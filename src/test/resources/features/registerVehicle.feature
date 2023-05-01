@wip
Feature: Checking the related web page

  Background: For the scenarios in the feature file, user should be on the second page of the form
    Given user is on Persönliche Daten eingeben page
    When user selects vehicle class
    And user selects flexPramieBentragen package
    And user uploads images of vehicle registration
    And user clicks on "Weiter " button
    Then user verifies title as "THG Prämie"

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
      | Herr  | John      | Doe      | anything%s@email.company | Elif Basbug   | ZBDE 4578 9089 6556 4334 5400 |

  Scenario:  Field data validations
    Then user validates the validation messages
      | label          | value                         | expectedMessage                                      |
      | Vorname        | a                             | Der Vorname muss mindestens zwei Zeichen lang sein.  |
      | Vorname        | Jhon                          | none                                                 |
      | Vorname        | .                             | Bitte geben Sie Ihren Vornamen ein.                  |
      | Vorname        |                               | Bitte geben Sie Ihren Vornamen ein.                  |
      | Nachname       | a                             | Der Nachname muss mindestens zwei Zeichen lang sein. |
      | Nachname       | .                             | Bitte geben Sie Ihren Nachnamen ein.                 |
      | Nachname       |                               | Bitte geben Sie Ihren Nachnamen ein.                 |
      | Nachname       | Doe                           | none                                                 |
      | E-Mail-Adresse |                               | Bitte geben Sie Ihre E-Mail-Adresse ein.             |
      | E-Mail-Adresse | #@%^%#$@#$@#.com              | Bitte geben Sie eine gültige E-Mail-Adresse ein.     |
      | E-Mail-Adresse | @example.com                  | Bitte geben Sie eine gültige E-Mail-Adresse ein.     |
      | E-Mail-Adresse | Joe Smith <email@example.com> | Bitte geben Sie eine gültige E-Mail-Adresse ein.     |
      | E-Mail-Adresse | email.example.com             | Bitte geben Sie eine gültige E-Mail-Adresse ein.     |
      | E-Mail-Adresse | email@example@example.com     | Bitte geben Sie eine gültige E-Mail-Adresse ein.     |
      | E-Mail-Adresse | email@example.com (Joe Smith) | Bitte geben Sie eine gültige E-Mail-Adresse ein.     |
      | E-Mail-Adresse | email@example.com             | none                                                 |


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

