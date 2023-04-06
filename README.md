●First extract the zip file in your preferred directory.
●Open Spring Tool Suit software(STS) and then extract your project.
●I have use MySQL data base for this project. So you have to create MySQL database in your system name as "sb_insurances".Then simply run our project STS.
●I created a project name as "InsuranceRestAPI". I download neseccary dependencies like Spring Web, MySQL Driver, Spring Data JPA, Lombok, Spring Boot DevTools, Validation.

1.Description of the project
●I created three main domains such as Client, Insurance Policy and Claim.
●I have define relationship between these three domains .
●I performed CRUD operation on the data of these three domains.

2.Structure of the project
●Project structure is divided in 4 parts.
1. com.restapi.model
   ●These package contains three domain Client, InsurancePolicy, Claim with their respective properties.These properties mapped with the database.
2. com.restapi.controller
   ●These package contains controllers of three domains like ClientController, InsurancePolicyController,ClaimController. These controllers are responsible to handle user request and return the appropriate response to user according to their respective domain.
3. com.reatapi.service
   ●These package contain java classes such as ClientService,InsuranvePolicy Service,ClaimService.
   ●These classes provides business functionality to their respective domains.
4. com.restapi.repository
   ●These package contains interfaces like ClientRepository, InsurancePolicyRepository, ClaimRepository.These repositories dealing with  CRUD operations or repository implementation that deals with database tables.
5. application.properties
   ●These file contains information about database.
   
3.Functionality
1. uses of validation
   ●Validation is mainly use to restrict the input provided by the user.
   ●Each and every field annotated with required annotation and it provide suitable message to user so he can understand the requirement of that field.
2.ExceptionHandling
   ●Exception Handling is the main functionality of any system. If we search for the perticular user. but the user of that perticular id is not present in the system.
    So we have an exception here. So in these system we handle that exception and dispaly the message to user that "client not fount" or "insurance policy not fount" or "claim not fount"
