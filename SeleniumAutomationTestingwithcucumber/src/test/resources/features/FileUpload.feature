Feature: File Upload Testing on W3Schools

  Scenario: Upload a file
    Given I am on the W3Schools file upload page
    When I upload a file "C:\Users\Dr. T.P. YOKESH\OneDrive\Desktop/render.png"
    Then I should see a success message indicating the file has been uploaded
