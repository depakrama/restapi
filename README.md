# restapi

The rest api's are developed using the Spring Boo and using maven to build the executable jar. Tha jar can be downloaded and using the below command the api's can be hit in Postman or using the curl commands. 

Search api:
This api is an POST call and used to number of occurrences of word in text file. The request will be JSON request like below. if the request is empty, then 400 bad request is returned.

URL: http://localhost:8080/counter/api/search

Sample Request :
{
"searchText":["Duis", "Sed", "Donec", "Augue", "Pellentesque", "123"]
}

Sample Response:
{
    "counts": {
        "123": 0,
        "sed": 11,
        "pellentesque": 6,
        "duis": 11,
        "donec": 8,
        "augue": 5
    }
}

Count Api:
This api is used to get the top n count words in a text file. This is a GET call with a url parameter. The response will be in csv format.

URL:http://localhost:8080/counter/api/top/10

Sample Response:

eget,15
vel,15
in,14
ut,12
et,12
sit,12
ac,11
sed,11
eu,11
duis,11

Both the Api's are secured using the spring security and when trying in postman, username and password should be added in header section.

username : test

password:test

download the jar file

go to the location where jar is downloaded.use the below command to start the application
java -jar spring-rest-0.0.1-SNAPSHOT.jar

or use the below command to start the application
mvn spring-boot:run
