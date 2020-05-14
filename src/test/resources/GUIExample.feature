@test
Feature: GUIExample
  This page contains examples for GUI test case scenario

  Scenario: Going to an example website and making a search for common searches and expect results
    Given I land on "https://www.google.com" page
    When I type "hello" in the input field element "//input[contains(@title, 'Search')]"
    When I click on button element "//div[2]/div[2]/center/input[1]"
    Then I expect to see element "result-stats"
