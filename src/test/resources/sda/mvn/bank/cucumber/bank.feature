Feature:

  Scenario Outline: I can create BankUser with specific name and pesel
    Given I instantiate Bank
    And I create BankUser with <name> and <pesel>
    When I add BankUser to Bank
    Then BankUser is present in Bank
    Examples:
      | name         | pesel       |
      | Jan Kowalski | 84022801784 |

  Scenario Outline: I cannot duplicate users in bank
    Given I instantiate Bank
    And I create BankUser with <name> and <pesel>
    When I add BankUser to Bank
    And I add BankUser to Bank
    Then User is not present in bank
    Examples:
      | name         | pesel       |
      | Jan Kowalski | 84022801784 |

  Scenario Outline: I can create account for existing bank user
    Given I instantiate Bank
    And I create BankUser with <name> and <pesel>
    When I add BankUser to Bank
    And I bind acount of type <account> to BankUser
    Then BankUser has BankAccount
    Examples:
      | name         | pesel       | account    |
      | Jan Kowalski | 84022801784 | Superkonto |

  Scenario Outline: I cannot crate BankAccount for non-existing BankUser
    Given I instantiate Bank
    And I create BankUser with <name> and <pesel>
    When I bind acount of type <account> to BankUser
    Then BankAccount is not created
    Examples:
      | name         | pesel       | account    |
      | Jan Kowalski | 84022801784 | Superkonto |

  Scenario Outline: I cannot create more than one account of specific type for a BankUser
    Given I instantiate Bank
    And I create BankUser with <name> and <pesel>
    When I add BankUser to Bank
    And I bind acount of type <account> to BankUser
    And I bind acount of type <account> to BankUser
    Then Second BankAccount of specific type is not created
    Examples:
      | name         | pesel       | account    |
      | Jan Kowalski | 84022801784 | Superkonto |

  Scenario Outline: I can deposit some money to existin account
    Given I mock BankDatabase for this case
    And I instantiate Bank
    And I create BankUser with <name> and <pesel>
    When I add BankUser to Bank
    And I bind acount of type <account> to BankUser
    And I deposit <ammount> to <account> type
    Then BankAccount of type <account> has <ammount> balance
    Examples:
      | name         | pesel       | account    | ammount |
      | Jan Kowalski | 84022801784 | Superkonto | 1000    |
