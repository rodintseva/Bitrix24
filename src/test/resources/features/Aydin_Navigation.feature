Feature: As a user, I should be able to see the correct titles when I navigate to corresponding modules.

  Scenario Outline: Verify that system display correct title when a user clicks on any module on the left menu bar of the page.
    Given user logs in as "<user>"
    When user clicks on "<module>"
    Then the title should be "<title>"

    Examples: helpdesk
      | user     | module           | title                                       |
      | helpdesk | Tasks            | (2) My tasks                                |
      | helpdesk | Chat and Calls   | (2) Chat and Calls                          |
      | helpdesk | Workgroups       | (2) Workgroups and projects                 |
      | helpdesk | Drive            | (2) My Drive                                |
      | helpdesk | Calendar         | (2) helpdesk35@cybertekschool.com: Calendar |
      | helpdesk | Mail             | (2) Mailbox Integration                     |
      | helpdesk | Contact Center   | (2) Contact Center                          |
      | helpdesk | Time and Reports | (2) Absence Chart                           |
      | helpdesk | Employees        | (2) Company Structure                       |
      | helpdesk | Services         | (2) Meeting Rooms                           |
      | helpdesk | Company          | (2) Company                                 |

    Examples: marketing
      | user      | module           | title                                    |
      | marketing | Tasks            | My Tasks                                 |
      | marketing | Chat and Calls   | Chat and Calls                           |
      | marketing | Workgroups       | Workgroups and projects                  |
      | marketing | Drive            | My Drive                                 |
      | marketing | Calendar         | marketing35@cybertekschool.com: Calendar |
      | marketing | Mail             | Mailbox Integration                      |
      | marketing | Contact Center   | Contact Center                           |
      | marketing | Time and Reports | Absence Chart                            |
      | marketing | Employees        | Company Structure                        |
      | marketing | Services         | Meeting Rooms                            |
      | marketing | Company          | Company                                  |

    Examples: hr
      | user | module           | title                             |
      | hr   | Tasks            | My Tasks                          |
      | hr   | Chat and Calls   | Chat and Calls                    |
      | hr   | Workgroups       | Workgroups and projects           |
      | hr   | Drive            | My Drive                          |
      | hr   | Calendar         | hr35@cybertekschool.com: Calendar |
      | hr   | Mail             | Mailbox Integration               |
      | hr   | Contact Center   | Contact Center                    |
      | hr   | Time and Reports | Absence Chart                     |
      | hr   | Employees        | Company Structure                 |
      | hr   | Services         | Meeting Rooms                     |
      | hr   | Company          | Company                           |
