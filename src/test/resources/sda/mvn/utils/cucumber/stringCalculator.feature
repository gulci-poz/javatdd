Feature:

  Scenario: I can calculate single number
    Given I initialize stringCalculator
    And I pass single number value
    When I trigger calculate function
    Then I get 5 as a result

  Scenario: I can calculate null number
    Given I initialize stringCalculator
    And I pass null value
    When I trigger calculate function

  Scenario:
    Given I initialize stringCalculator
    And I pass an empty value
    When I trigger calculate function
    Then I get 0 as a result

  Scenario:
    Given I initialize stringCalculator
    And I pass multiple values
    When I trigger calculate function
    Then I get 12 as a result

  Scenario:
    Given I initialize stringCalculator
    And I pass multiple values containing multiple spaces between them
    When I trigger calculate function
    Then I get 12 as a result

  Scenario:
    Given I initialize stringCalculator
    And I pass multiple values containing multiple delimiters side-by-side
    When I trigger calculate function
    Then I get 12 as a result

  Scenario:
    Given I initialize stringCalculator
    And I pass multiple values containing multiple delimiters side-by-side with multiple whitespaces
    When I trigger calculate function
    Then I get 12 as a result
