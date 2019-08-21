
Feature: Login   As user I want to login under different roles
# So hook will take care of this action
#  Hook will open main page
#  Background:
#    Given user is on the landing page



  Scenario: Login as a help Desk and navigate to Activity Stream
    Given  User is on landing page
    When   user logs in as a help desk
    Then  "Activity Stream" page name is displayed







