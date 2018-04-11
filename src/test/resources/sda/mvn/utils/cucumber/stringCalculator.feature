Feature:

  Scenario: I can calculate null number
    Given I initialize stringCalculator
    And I pass value null
    When I trigger calculate function

  Scenario Outline: I can calculate multiple values
    Given I initialize stringCalculator
    And I pass <value> value
    When I trigger calculate function
    Then I get <result> as a result
    Examples:
      | value         | result |
      | 3,;  4,;;   5 | 12     |
      | 3,;4;,5       | 12     |
      | 3, 4,   5     | 12     |
      | 3,4,5         | 12     |
      | 5             | 5      |
      |               | 0      |
