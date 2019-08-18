Feature:  As a user I should be able to create a task from activity stream.

  Background:
    Given user logs in as a help desk
    When user navigates to "Task" in "Activity Stream" page

  Scenario: Create new task by clicking on Tasks on Activity stream

    And user enters task name "dCoders"
    Then system should display new task


  Scenario: Verify that user can upload a file and image or link or add checklist regarding to new task

    And User clicks on "Upload Files" button
    And User click on "Upload files and images" and select a file
    Then System should upload the file or image


  Scenario: Verify that user should be able to set up a deadline for new task

    And Click on Calendar under Deadline
    And Click on a date and time
    And Click on "Select"
    Then System should display the selected date time