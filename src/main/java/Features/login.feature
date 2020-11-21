Feature: Free CRM Login Feature

	#without examples keyword
  Scenario: Free CRM Test Scenario without Examples Keyword
    Given User is already on Login Page
    When Title of Login Page is Free CRM
    Then User clicks on LoginButton
    Then User enters "shubhamupadhyay2111@gmail.com" and "Shubham123"
    Then User clicks on Login
    And User is on Home Page

  #with examples keyword 
  Scenario Outline: Free CRM Test Scenario
    Given User is already on Login Page
    When Title of Login Page is Free CRM
    Then User clicks on LoginButton
    Then User enters "<username>" and "<password>"
    Then User clicks on Login
    And User is on Home Page
  
  Examples: 
  	| username | password |
  	| shubhamupadhyay2111@gmail.com | Shubham123 |
  	| naveenk | test@123 |