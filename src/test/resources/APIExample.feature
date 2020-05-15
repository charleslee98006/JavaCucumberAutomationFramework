@test
Feature: APIExample
  This page contains examples for API test case scenarios

  #Note that the https url may need to change
  Scenario: when non logged in users lands on the twitter front page, data should already be loaded.
    Given I have an url "/hashflag/config-2020-05-15-19.json" and header "host:''"
    When I make "GET" REST call
    Then I expect to see "200" status code
