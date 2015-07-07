Feature: Page Object Pattern Is Usable

  #Background: Prepare Appium Driver

  Scenario: Open Accessibility Screen
    Given Start Application
    When Click Accessibility
    Then Accessibility Screen Is Displayed

  Scenario: Open Animation Screen
    Given Start Application
    When Click Animation
    Then Animation Screen Is Displayed
