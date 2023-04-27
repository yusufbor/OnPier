@wip
Feature: Checking the related web page

  Scenario Outline:  Verify form structure changes based on private/company
    Given I am in personal information page
    When I fill out the form with "<Anrede>" "<Vorname>" "<Nachname>" "<E-Mail-Adresse>" "<Kontoinhaber>" "<IBAN>"
    And I click on "Weiter" button
    Then I verify personal information is correct

    Examples:

      | Anrede | Vorname | Nachname | E-Mail-Adresse           | Kontoinhaber | IBAN                          |
      | Herr   | Jhon    | Doe      | anything%s@email.company | Jhon Doe     | ZBDE 4578 9089 6556 4334 5400 |

  Scenario: Entering the information on form page
    Given I am in personal information page

      | Anrede         | Herr                          |
      | Vorname        | Jhon                          |
      | Nachname       | Doe                           |
      | E-Mail-Adresse | anything%s@email.company      |
      | Kontoinhaber   | Jhon Doe                      |
      | IBAN           | ZBDE 4578 9089 6556 4334 5400 |

  Scenario:  Account holder and the person name can be same
    When I get the Account holder name
    Then I verify Account holder name and person name can be same

  Scenario:  Verify user can not created with the same email
    When I try to create with the same email
    Then I verified the warning message

  Scenario: Verify account is created with the same IBAN
    Then I verify account is created with the same IBAN

  Scenario: Data Validations
