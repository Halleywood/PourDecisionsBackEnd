![WINELOGO!](https://github.com/Halleywood/PourDecisionsBackEnd/assets/87944545/e50dcc11-3700-4356-a9f0-9091950406c1)
# Pour Decisions Backend
Here we embrace making pour decisions! This Java RESTful API powers the [Angular Front End](https://github.com/Halleywood/PourDecisionsFrontEnd), together they create an interactive wine tasting note application! This API provide a secure and reliable platform for wine enthusiasts to show their passion. With this application, you have the freedom to create your next pour decision and explore all of the pour decisions your friends are making. Discover the wines people are loving and the ones that didn't quite hit the mark, all in one convenient place.

By prioritizing user stories, my development process ensured that the end user's experience and needs remained at the forefront from testing to product implementation. Each user story became the driving force for creating thorough test cases, promoting robustness and code reliability.

To achieve an organized and scalable application, I implemented the MVC (Model-View-Controller) architectural pattern. It not only promotes efficient implementation of functionality but also secures future expansion and enhancements beyond this initial application. To guarantee reliable access and data control, I integrated Spring Security into the API. This powerful framework provides dual security through registration and login authentication, while JWT (JSON Web Token) authorization ensures secure data access.

Ultimately, my API empowers wine enthusiasts with a seamless and secure platform to share their pour decisions, explore new wines, and connect with like-minded individuals with a grape passion for vino! Cheers to making pour decisions together!

## Tools and Technologies
* Development Process
  * Agile Project Development 
  * User Stories 
  * Timeboxing and Visual Timeline 
* Testing
  * Cucumber with RestAssured 
* Implementation 
  * Spring and Spring Boot Frameworks
  * Java Persistence Api
  * H2 database 
  * Postman 
  * Spring Security
## Hurdles
* Time Constraints: 
  * When is this never a hurdle?? My goal for this project was to really think through my planning, setting equally ambitious and attainable goals, and following that plan. 
  * The first two days required quite a bit of setup, and in the nature of agile development, not having quick iterations and feedback made me very nervous. However, I was able to stick to my time constraints even if it did mean leaving features on my wishlist. 
* Implementation
  * This was our first time connecting our backend application to a frontend and I was trying to avoid decision paralysis trying to decide the best approach to developing this project. Driven by user stories and testing, I started on the backend and worked forward. However, by the time I got to the frontend and was handling to data there were quite a few features I wish I had modeled and queried differently. 
* Data Transfer Objects and ModelMapper 
  * I had originally designed this API with the intention of keeping the User's more private information like the email and password seperate from the User's profile data. 
  * I thought I would grab all of this information at once on the frontend registration form and store in a single Data Transfer Object, and then on the backend I would parse the information into their respective entities. 
  * However, I continued to run into errors trying to set the attributes and the relationships in the correct order.
## Project Management 
* Timeline: I prefer to use a Gantt chart because it has a time aspect
  ![TIMELINEpourdecisions2](https://github.com/Halleywood/PourDecisionsBackEnd/assets/87944545/f2bf786c-7196-4f7b-b606-4519675b18d6)
* User Stories:
  ![pourdecisionsuserstories](https://github.com/Halleywood/PourDecisionsBackEnd/assets/87944545/46ccd6b8-4ede-4f8e-b197-30ebfe0b1109)
* Wireframes:
  * Login/Registration
    ![WIREFRAMELANDINGPAGE](https://github.com/Halleywood/PourDecisionsBackEnd/assets/87944545/d18f53a0-05a0-4a49-9069-9fc7c75485ac)
  * Home Page: Profile and Menu stay throughout the application
    ![WIREFRAMEhomepage](https://github.com/Halleywood/PourDecisionsBackEnd/assets/87944545/662a8213-f97e-4d1e-bdf5-2254323ab00e)
  * Clickable prototype:
    * Getting a clickable prototype to ensure all data behaving as expected before styling!
      ![CLICKABLElogin](https://github.com/Halleywood/PourDecisionsBackEnd/assets/87944545/910b4a6d-0d17-4fb6-998d-7aa3b0f6ed3e)
      ![CLICKABLEhome](https://github.com/Halleywood/PourDecisionsBackEnd/assets/87944545/2d099bf9-f09c-4721-8bc9-89163c28e2f9)

## ERD Diagram
* Users to Posts: A User can have many posts, many posts belong to one user. 
* Wine to Posts: A wine can have many posts, manny posts belong to one wine.
* Gold feature: creating followers and following relationships between Users
  ![ERDPourDecisions](https://github.com/Halleywood/PourDecisionsBackEnd/assets/87944545/dc193337-a65e-45f6-9d91-ca1a6fe379eb)


## Features
Ultimately, these are the features and functionality of the application: 
* Login and Registration:
* Retrieving Profile
  ![ENDPOINTSuser](https://github.com/Halleywood/PourDecisionsBackEnd/assets/87944545/4bfb5d8e-3254-4b36-aace-0e3e994a7a93)
* Retrieving all wines, as well as a specific wine by ID to view details
  ![ENDPOINTSwine](https://github.com/Halleywood/PourDecisionsBackEnd/assets/87944545/31bc1eec-309d-44e7-978b-d39b3ea90c5f)
* Full CRUD functionality for "Wine Tasting" posts
  ![ENDPOINTSposts](https://github.com/Halleywood/PourDecisionsBackEnd/assets/87944545/bf5a07ec-b569-4cbf-914e-dcb97b7699b2)
## Instructions to install 
####  Want to try it for yourself? In order to run this application on you machine you will need the following dependencies installed before starting: 
######  Java Development Kit: The package you need for a running a Java application, includes the Java Runtime Environment and the Java Virtual Machine
*   You can visit the Oracle webite to learn more about it and view installation instructions:
[Install JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
######  Apache Maven: A special tool for Java applications, it will retrieve and manage all of the project's dependencies for you! 
* You can visit the Apache Maven official website to learn more about it and view installation instructions: [Install Maven](https://maven.apache.org/download.cgi)

