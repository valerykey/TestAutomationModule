Feature: Customer sign in

  Scenario: Customer sign in with right credentials
    Given Customer is on page with url 'homepage.url'
    When Customer sign in with right credentials
    Then Home page contains message 'welcome.message'

  Scenario: Customer sign in with wrong credentials
    Given Customer is on page with url 'homepage.url'
    When Customer sign in with wrong credentials
    Then Field contains message 'Password was incorrect'