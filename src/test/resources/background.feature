# new feature
# Tags: optional
    
Feature: Create new draft mail
    
    Background: login
        Given email and password
        When click login button
        Then login gmail successfully

    Scenario: new draft mail
        Given click Compose button
        And set to and subject and body
        When click save button
        Then the mail will be added to draft list
