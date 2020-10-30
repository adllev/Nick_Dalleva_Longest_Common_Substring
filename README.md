Nicholas D'Alleva

LCS Spring Boot Java App IntelliJ Instructions

1. Open IntelliJ IDEA
2. Click Open or Import
2. Open the NICK_DALLEVA_LONGEST_COMMON_SUBSTRING folder and select the "LongestCommonSubstring" folder within that. Press OK
3. Allow the project to import/load in
4. Try to run the project using play button at top right corner. Otherwise open src/main/java/com.example.LargestCommonSubstring and Right Click LCSApplication.Java and click run
5. If it fails go to     file >> project structure >> Project    and confirm Project SDK has openjdk-15 selected in the dropdown
6. running mvn clean install may also help
7.At this point server should be running and you should be able to send POST Requests to http://localhost:8080/lcs and recieve results from the python testScript.py provided

LCS Spring Boot App Eclipse Instructions

1. Open Eclipse
2. Open New Workspace
3. Go to File >> Import projects from fielsystem....
4. Click Directory
5. Open the NICK_DALLEVA_LONGEST_COMMON_SUBSTRING folder and select the "LongestCommonSubstring" folder within that.
6. Click Finish
7. Allow the project to import/load in
8. Open src/main/java com.example.LargestCommonSubstring
9. Right Click LCSApplication.Java and click run
10.At this point server should be running and you should be able to send POST Requests to http://localhost:8080/lcs and recieve results from the python testScript.py provided


Python Test Script Instructions

1. Have python installed on system
2. run "python -m pip install requests"  for requests HTTP/API libraries
3. cd to the script directory and run python testScript.py
4. Observe Test Output and HTTP Responses in Command Line

JSON Format Example:
{
  "setOfStrings": [
    {"value": "comcast"},
    {"value": "comcastic"},
    {"value": "broadcaster"}
  ]
}