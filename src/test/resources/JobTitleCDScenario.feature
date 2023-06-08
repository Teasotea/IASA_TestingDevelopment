Feature: Job Title Management

  Scenario: Adding and Removing Job Titles

    Alicia, site user, navigates to the login page

    When Alicia logs in
    And Alicia gains access to the Admin page
    And Alicia selects the 'Job' dropdown from the menu
    And Alicia chooses the 'Job titles' option
    And Alicia clicks on the Add button
    And Alicia provides the necessary details, such as the title, description, and note, to create a new job title and saves the changes
    Then Alicia expects the newly added job title to be visible on the 'Job Titles' page

    When Alicia selects the previously added job title from the list
    And Alicia clicks on the 'Delete selected' button
    And Alicia confirms the deletion by dedicatedclicking 'Yes, Delete'
    Then Alicia confirms that the job title has been successfully removed and is no longer displayed on the 'Job Titles' page.