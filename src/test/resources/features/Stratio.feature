Feature: Testing Stratio page

  Scenario: Open Stratio Page and get Governance use case tittle
    Given browser initiated
    And google cookies accepted
    When user types Stratio in search bar and press enter
    Then shows all results of Stratio

  Scenario: Open Stratio Home page
    Given browser initiated
    And google cookies accepted
    And user types Stratio in search bar and press enter
    And shows all results of Stratio
    When user click first link
    And accept stratio cookies
    Then show Stratio Home page

  Scenario: Test Stratio Page
    Given browser initiated
    And google cookies accepted
    And user types Stratio in search bar and press enter
    And shows all results of Stratio
    And user click first link
    And accept stratio cookies
    And show Stratio Home page
    When user click the dropdown Solutions
    And user select Governance from the dropdown
    Then Governance page loads
    And print first case title
