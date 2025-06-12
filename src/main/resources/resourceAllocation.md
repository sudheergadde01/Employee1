Employee1 microservices

Each endpoint url, request, response
Problem statement=?
url=?
Request payload=?
Response payload=?

1. registerEmployee Endpoint

Problem Statement: We need a RESTful endpoint to register the employee
Url: /employee/register-employee

Request Payload:
empId
name
dob
salary
line1
line2
state
country

Response payload:

Status :
Message:

2.getEmployeeById endpoint

Problem Statement: Need to develop a RESTful endpoint to get the employee from the database based on the empId given.

Url: /employee/get-employee/{id}



Response Payload:
Status:
message:
EmployeeDetails:{
empId:
name:
dob:
salary:
line1:
line2:
state:
country: }

3.UpdateEmployee endpoint
Url: /employee/update-employee
Problem Statement: Need to update employee details in the database, search by empId(shouldn’t change empId) and update the details in the database, with the provided details from the request payload.

Request Payload:
empId(mandatory)
name
dob
salary
line1
line2
state
country

Response Payload:

Status :
Message:

4.deleteEmployee endpoint
Url: /employee/delete-employee/{id}
Problem Statement: Need to delete employee record from the database based on the empId got from the request payload.



Response Payload:

Status :
Message:

