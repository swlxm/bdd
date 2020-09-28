# new feature
# Tags: optional
    
Feature: A description
    
    Scenario Outline: login
        Given email <Email> and password <Password>
        When click login button 2
        Then login gmail successfully 2
        Examples:
            |Email                  |Password       |
            |module7.epam@gmail.com  |Epam_886633!   |
