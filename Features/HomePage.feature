Feature: HomePage

Background: common steps for all login test scenarios
Given user launches application
 And   user is in homepage

@correctCredentials
Scenario: test login feature with correct credentials

 When  user enters correct "Admin" and "admin123"
 And   click login button 
 Then  user is on  Account page
 
 @incorrectUsername
 Scenario: test login featur with incorrect username
 
 When user enters incorrect username 3.1415 and "admin123"
 And   click login button 
 Then user gets invalid error message "Invalid credentials"

@incorrectPassword @Smoke
 Scenario: test login feature with incorrect password
 
 When user enters incorrect password "Admin" and "wrongPassword"
 And   click login button 
 Then user gets invalid error message "Invalid credentials"