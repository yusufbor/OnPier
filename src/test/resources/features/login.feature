Feature: Checking the

 Scenario Outline:
  Verify form structure changes based on private/company


Examples:
    Given I am in personal information page
    When I fill out the form with below data
      | Anrede         | Herr                          |
      | Vorname        | Jhon                          |
      | Nachname       | Doe                           |
      | E-Mail-Adresse | anything%s@email.company      |
      | Kontoinhaber   | Jhon Doe                      |
      | IBAN           | ZBDE 4578 9089 6556 4334 5400 |
    And I click on "Weiter" button
    Then I verify personal information is correct


  Scenario 2: Account holder and the person name can be same

  Scenario 3: Verify user can not created with the same email

  Scenario 4: Verify account is created with the same IBAN

  Scenario 5: Data Validations