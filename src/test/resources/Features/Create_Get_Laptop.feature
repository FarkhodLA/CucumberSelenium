Feature: Post and Get Request for Laptop 
@api
Scenario: Creating and Getting the Laptop objects
Given Content type and Accept type is JSON
When  user posts new Laptop with "random" id
Then  user gets the Status Code 201
When  user send GET request with "random" id
Then  user gets 200 status code
And   laptop data should match while created
