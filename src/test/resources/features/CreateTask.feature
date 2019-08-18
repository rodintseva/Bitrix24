Feature:  As a user I should be able to create a task from activity stream.

  Scenario: Create new task by clicking on Tasks on Activity stream
    Given user logs in as a help desk
    And   user navigates to "Task" in "Activity Stream" page
    And user ckliks
    And user enters task name "dCoders"
    And user clicks on Send button
    Then system should display new task in Message


  Scenario: Verify that user can upload a file and image or link or add checklist regarding to new task
  Given user logs in as a help desk
    And user navigates to {string} in {string} page






  Scenario: Verify that user should be able to set up a deadline for new task
    Given user logs in as a help desk
