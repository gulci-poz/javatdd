Feature:

  Scenario: I can add a Book to a Bookstore
    Given I instantiate a Bookstore
    And I create a Book
    When I add the Book to the Bookstore
    Then Book is present in the Bookstore

  Scenario: I can get author of the Book
    Given I instantiate a Bookstore
    And I create a Book
    When I add the Book to the Bookstore
    Then Book author is JRR Tolkien

  Scenario: I can edit title of the Book
    Given I instantiate a Bookstore
    And I create a Book
    When I add the Book to the Bookstore
    And I update title of the Book
    Then Title of the book has changed
