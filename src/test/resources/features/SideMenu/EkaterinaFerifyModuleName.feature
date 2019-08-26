
Feature: As a user, I should be able to see the correct titles when I navigate to corresponding modules.
  Background:
    Given user logs in as a help desk
    When user navigates to Task module

  @ScenarioOutlineEkaterina
  Scenario Outline: Verify that system display correct title when a user clicks on any module on the left menu bar of the page.
    When  user clicks on specific "<module>"
    Then  the title on the page should be equal to module name "<module>"

    Examples: helpdesk
   | module           |
   | Tasks            |
   | Chat and Calls   |
   | Work groups      |
   | Drive            |
   | Calendar         |
   | Mail             |
   | Contact Center   |
   | Time and Reports |
   | Employees        |
   | Services         |
   | Company          |

