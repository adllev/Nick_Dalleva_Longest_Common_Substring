import requests

test1 = {"setOfStrings": [{"value": "comcast"},{"value": "communicate"},{"value": "commutation"}]}
test2 = {"setOfStrings": [{"value": "comcast"},{"value": "comcast"},{"value": "communicate"}]}
test3 = {}
test4 = ''
test5 = {"setOfStrings": []}
test6 = {"setOfStrings": [{"value": "racecar"},{"value": "race"},{"value": "racers"}]}
test7 = {"setOfStrings": [{"value": "tap"},{"value": "cuz"},{"value": "how"}]}
test8 = {"setOfStrings": [{"value": "apples"},{"value": "apply"},{"value": "applicable"}]}
test9 = {"setOfStrings": [{"value": "license"},{"value": "incense"},{"value": "century"}]}
test10 = {"setOfStrings": [{"value": "apptiszapnap"},{"value": "napzapapp"},{"value": "napappzap"}]}

print("\n")
print("Running Test Script.........")
print("Testing Provided JSON Request")
print("Request Body:")
print(test1)
response = requests.post('http://localhost:8080/lcs', json=test1)
print("Status code: ", response.status_code)
print("Response Body")
print(response.json())

print("\n")
print("Testing Response to Duplicate Strings...")
print("Request Body:")
print(test2)
response = requests.post('http://localhost:8080/lcs', json=test2)
print("Status code: ", response.status_code)
print("Response Body:")
print(response.json())
print("\n")

print("Testing Response to Empty Brackets")
print("Request Body:")
print(test3)
response = requests.post('http://localhost:8080/lcs', json=test3)
print("Status code: ", response.status_code)
print("Response Body:")
print(response.json())
print("\n")

print("Testing Response to Empty Body")
print("Request Body:")
print(test4)
response = requests.post('http://localhost:8080/lcs', json=test4)
print("Status code: ", response.status_code)
print("Response Body:")
print(response.json())
print("\n")

print("Testing Response to No Strings Provided")
print("Request Body:")
print(test5)
response = requests.post('http://localhost:8080/lcs', json=test5)
print("Status code: ", response.status_code)
print("Response Body:")
print(response.json())
print("\n")

print("Testing Valid JSON With Strings")
print("Request Body:")
print(test6)
response = requests.post('http://localhost:8080/lcs', json=test6)
print("Status code: ", response.status_code)
print("Response Body:")
print(response.json())
print("\n")

print("Testing With No Common Substrings")
print("Request Body:")
print(test7)
response = requests.post('http://localhost:8080/lcs', json=test7)
print("Status code: ", response.status_code)
print("Response Body:")
print(response.json())
print("\n")

print("Testing With Single LCS")
print("Request Body:")
print(test8)
response = requests.post('http://localhost:8080/lcs', json=test8)
print("Status code: ", response.status_code)
print("Response Body:")
print(response.json())
print("\n")

print("Testing With 6 character LCS")
print("Request Body:")
print(test9)
response = requests.post('http://localhost:8080/lcs', json=test9)
print("Status code: ", response.status_code)
print("Response Body:")
print(response.json())
print("\n")

print("Testing With Multiple LCS")
print("Request Body:")
print(test10)
response = requests.post('http://localhost:8080/lcs', json=test10)
print("Status code: ", response.status_code)
print("Response Body:")
print(response.json())
print("\n")
