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
  Then User clicks on upload file button attaches file located at "C:\Users\rodin\OneDrive\Desktop\7_d5WY5jKS0.jpg"
  Then System should display attached file
    And User clicks on Link button and upload the link "https://flipgrid.com"
  Then System should upload link "https://flipgrid.com"
  And user clicks on Send button


@deadline
  Scenario: Verify that user should be able to set up a deadline for new task
    And user enters task name "dCodersCalendar"
    And Click on Calendar under Deadline
    And Click on a date and time
    And Click on Select button
    And user clicks on Send button
    Then System should display the selected date time
