Feature: Verify Outlines (Data-Driven Testing)

  Scenario Outline: Click on menu items
    Given Start Application
    When Click <MenuItem> item
    Given The <Marker> is present
    Examples:
      | MenuItem | Marker     |
      | App      | Action Bar |
      | Content  | Assets1    |
      | Graphics | AlphaBitmap|