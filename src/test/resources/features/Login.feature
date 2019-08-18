Feature:  As a user I should be able to create a task from activity stream.

  Background:
  Given: user is on the login page
    When: user logs in with valid credentials
    And: user navigates to Task in Activity Stream page


  Scenario: User can create new task by clicking on tasks on activity stream
     Then: user enters task name
    And: user clicks on Send button
    Then: system should display new task in Message




