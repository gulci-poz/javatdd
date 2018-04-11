Feature:

  Scenario Outline: I can create BankUser with specific name and pesel
    Given I instantiate Bank
    And I create BankUser with <name> and <pesel>
    When I add BankUser to Bank
    Then BankUser is present in Bank
    Examples:
      | name         | pesel       |
      | Jan Kowalski | 84022801784 |
