# Log-Parser
Log parser - Spring Boot Java Application


This Application basically exposes REST end points for parsing a log file and get the Json out of it to get some meaningful insights.

It is developed using the following tech stack :

  Java, Spring Boot, Docker , AWS .
  
The entire application is docker and deployed and is running on AWS EC2 as a docker container.
You can access the swagger docs at 

    http://13.233.206.172:8080/swagger-ui.html
    
 The app has two layers in the backend :
 
    1. Web(REST) layer
    2. Service(Business) layer
    
  The endpoint takes in a file in the request in the controller layer , send it to service layer and the service layer process   log file accorindgly as per the requirement and some rules.
  
    http://13.233.206.172:8080/api/v1/parser
       
   There is other point which can take multiple files in one request and process them concurrently.
   I have just left a place holder for multi file processing where it can accept multi files .
   
   Pending implementation is to include Thread executor service with some fixed thread pool of 10 or some number . 
   We can accept mutiple files and send them to thread pool and process the response accordingly. That way the response will      be very fast since the parsing is happening concurrently . We just need to induce this logic in controller layer.
   
   One thing we need to ensure is the machine on which we are running this should have enough cores on it so that concurrency    can happen without much context switching , else it might be same as serial processing.
   
    http://13.233.206.172:8080/api/v1/parser/multi
       
   ### Docker :
   
   I have a Dockerfile defined at rool level of the project . You can run this application locally on your machine if you have 
   docker installed locally . Please use the following commands to run :
   
     sudo docker pull registry.gitlab.com/pullah/log-parser/logparserv1
      
     sudo docker run --name logparsercontainer --rm -d -p 8080:8080 registry.gitlab.com/pullah/log-parser/logparserv1:latest
   
      
        
   
  
  
  
