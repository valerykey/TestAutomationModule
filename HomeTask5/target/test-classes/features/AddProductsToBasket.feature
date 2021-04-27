Feature: Add products to basket

  Scenario: Add one product
    Given Customer is on page with url 'homepage.url'
    When Customer adds product to basket from search
    Then Product should be present on basket page