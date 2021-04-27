Feature: Product search

  Scenario: Search of a product by customer
    Given Customer is on page with url 'homepage.url'
    When Customer enters product to search form
    Then Customer redirected to a search page