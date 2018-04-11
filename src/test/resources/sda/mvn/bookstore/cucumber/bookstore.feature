Feature:

  Scenario:
    Given I instantiate a Bookstore
    And I create a Book
    When I add the Book to the Bookstore
    Then Book is present in the Bookstore

  Scenario:
    Given I instantiate a Bookstore
    And I create a Book
    When I add the Book to the Bookstore
    Then Book author is JRR Tolkien
