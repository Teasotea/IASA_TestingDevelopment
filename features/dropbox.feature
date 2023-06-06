Feature: Dropbox test

  Scenario: Upload a file
    Given I am on the Dropbox upload page
    When I upload a file with name "<file_name>"
    Then the file "<file_name>" should be successfully uploaded
  Scenario: Retrieve file metadata
    Given I am on the Dropbox files page
    When I retrieve the metadata of file "<file_name>"
    Then the file metadata for "<file_name>" should be displayed
  Scenario: Delete a file
    Given I am on the Dropbox files page
    When I delete file "<file_name>"
    Then the file "<file_name>" should be successfully deleted
