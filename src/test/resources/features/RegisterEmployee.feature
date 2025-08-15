Feature: The user wishes to register a new employee on the orange page
  As a user,
  I want to log in to the Orange app
  so I can register an employee

  @Orange
  Scenario Outline: *Scenario-01 -> register a new employee
    Given access to the application --> <application>
    When access to the option --> <option>
    And We registered a new employee
      | firtName | middleName | lastName | password  |
      | Rodolfo  |  Alberto   |  Espinoza| @1Wmoorrre|
    And we are looking for the registered employee
    Then we validate the successful registration
    Examples:
    | application | option |
    |  orangeHrm  |   PIM  |