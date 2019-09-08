Feature:  As a user I should be able to create a task from activity stream.

  Background:
    Given user logs in as a help desk
    When user navigates to Task module

@CreateTask
  Scenario: Create new task by clicking on Tasks on Activity stream
  And user enters task name "dCoders"
  And user clicks on Send button
  Then System should display "Task has been created" message

@AttachFile
  Scenario: Verify that user can upload a file and image or link
    And user enters task name "dCodersFile"
    And user clicks on upload file button and attaches file "TestNG_Annotations.png"
    Then system should display the attached filename "TestNG_Annotations.png" or "TestNG_Annotations (#).png"

@deadline
  Scenario: Verify that user should be able to set up a deadline for new task
    And user enters task name "dCodersCalendar"
    And clicks on Calendar under Deadline
    And selects date "08/31/2019 07:00:00 pm"
    And clicks on Select button
    Then system should display date "08/31/2019 07:00:00 pm"
