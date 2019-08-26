Feature: As a user, I should be able to see the correct titles when I navigate to corresponding modules.
  @ScenarioOutlineAydin
  Scenario Outline: Verify that system display correct title when a user clicks on any module on the left menu bar of the page.
    Given user logs in as "<user>"
    When user clicks on specific "<module>"
    Then  the title on the page should be equal to module name "<module>"

    Examples: helpdesk
      | user     | module           |
      | helpdesk | Tasks            |
      | helpdesk | Chat and Calls   |
      | helpdesk | Workgroups       |
      | helpdesk | Drive            |
      | helpdesk | Calendar         |
      | helpdesk | Mail             |
      | helpdesk | Contact Center   |
      | helpdesk | Time and Reports |
      | helpdesk | Employees        |
      | helpdesk | Services         |
      | helpdesk | Company          |

    Examples: marketing
      | user      | module           |
      | marketing | Tasks            |
      | marketing | Chat and Calls   |
      | marketing | Workgroups       |
      | marketing | Drive            |
      | marketing | Calendar         |
      | marketing | Mail             |
      | marketing | Contact Center   |
      | marketing | Time and Reports |
      | marketing | Employees        |
      | marketing | Services         |
      | marketing | Company          |

    Examples: hr
      | user | module           |
      | hr   | Tasks            |
      | hr   | Chat and Calls   |
      | hr   | Workgroups       |
      | hr   | Drive            |
      | hr   | Calendar         |
      | hr   | Mail             |
      | hr   | Contact Center   |
      | hr   | Time and Reports |
      | hr   | Employees        |
      | hr   | Services         |
      | hr   | Company          |