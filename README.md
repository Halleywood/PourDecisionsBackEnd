![](C:\Users\kelse\Desktop\WINELOGO!.jpg)
# Pour Decisions
Here we embrace making pour decisions! This Java RESTful API powers the [Angular Front End](https://github.com/Halleywood/PourDecisionsFrontEnd), providing a secure and reliable platform for wine enthusiasts to show their passion. With this application, you have the freedom to create your next pour decision and explore the pour decisions your friends are making. Discover the wines people are loving and the ones that didn't quite hit the mark, all in one convenient place.

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
  * **SCREENSHOT HERE**
## Project Management 
* Timeline: I prefer to use a Gantt chart because it has a time aspect
  ![](C:\Users\kelse\Desktop\TIMELINEpourdecisions2.jpg)
* User Stories:
![](C:\Users\kelse\Desktop\pourdecisionsuserstories.jpg)
* Wireframes:
  * Login/Registration 
![](C:\Users\kelse\Desktop\WIREFRAMELANDINGPAGE.jpg)
  * Home Page: Profile and Menu stay throughout the application 
![](C:\Users\kelse\Desktop\WIREFRAMEhomepage.jpg)
  * Clickable prototype:
    * Getting a clickable prototype to ensure all data behaving as expected before styling!
![](C:\Users\kelse\Desktop\CLICKABLElogin.jpg)
![](C:\Users\kelse\Desktop\CLICKABLEhome.jpg)

## ERD Diagram
* Users to Posts: A User can have many posts, many posts belong to one user. 
* Wine to Posts: A wine can have many posts, manny posts belong to one wine.
* Gold feature: creating followers and following relationships between Users
![](C:\Users\kelse\Desktop\ERDPourDecisions.jpg)


## Features
Ultimately, these are the features and functionality of the application: 
* Login and Registration:
* Retrieving Profile
![](C:\Users\kelse\Desktop\ENDPOINTSuser.jpg)
* Retrieving all wines, as well as a specific wine by ID to view details
![](C:\Users\kelse\Desktop\ENDPOINTSwine.jpg)
* Full CRUD functionality for "Wine Tasting" posts
![](C:\Users\kelse\Desktop\ENDPOINTSposts.jpg)
## Instructions to install 
####  Want to try it for yourself? In order to run this application on you machine you will need the following dependencies installed before starting: 
######  Java Development Kit: The package you need for a running a Java application, includes the Java Runtime Environment and the Java Virtual Machine
*   You can visit the Oracle webite to learn more about it and view installation instructions:
[Install JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
######  Apache Maven: A special tool for Java applications, it will retrieve and manage all of the project's dependencies for you! 
* You can visit the Apache Maven official website to learn more about it and view installation instructions: [Install Maven](https://maven.apache.org/download.cgi)

