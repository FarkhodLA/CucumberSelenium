Feature: Datatables with multiple data

Background: Launch the browser
Given user launches browser
And user is in main page

@data
Scenario Outline: Enter mutiple data for multiple users
When user clicks new button
 Then new form opened
 And  user enters firstname "<firstname>"
 And  user enters lastname "<lastname>"
 And  user enters position "<position>"
 And  user enters office "<office>"
 And  user enters extension "<extension>"
 And  user enters startdate "<startdate>"
 And  user enters salary "<salary>"
 And  user clicks create button
 Then user validates fullname "<firstname>" "<lastname>"
Examples: DataTable for user creation
|firstname|lastname|position|office      |extension|startdate |salary|
|John     |Doe     |sdet    |santa monica|111      |2021-03-15|133000|
|Qozivoy  |Sattarov|sdet    |LADT        |414      |2021-05-01|103000|
|Talat    |Dadaev  |devoloper|St.Louis   |1        |2021-08-15|100000|
|Britney  |Spears  |janitor  |New York|0      |2021-03-15|53000|
|Joseph     |Biden   |president    |Washington DC|919      |2021-01-20|420000|
|Donald     |Trump     |inmate   |Philadelphia|01      |2021-03-15|0|


