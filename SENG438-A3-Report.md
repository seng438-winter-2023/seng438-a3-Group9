
**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#3 – Coverage-Based Test Generation**

| Group \#:      | 9    |
| -------------- | --- |
| Student Names | |
| Saman Pordanesh  | |
| Thevin Mahawatte | |
| Bryant Stevnes |                |
| Noureldin Amer |                    |



# 1 Introduction

The following lab report will be showing information on assignment 3. The assignment focuses on JUnit testing and how to improve the previous assignment with better tests that lead to more coverage of the code. Discussions about the complexity analysis are included. 

# 2 Manual data-flow coverage calculations the two mentioned methods
<img width="532" alt="Screen Shot 2023-03-03 at 7 16 59 PM" src="https://user-images.githubusercontent.com/84950398/222870598-e4d61cbe-5770-4651-bebf-b556b6a76807.png">
<img width="427" alt="Screen Shot 2023-03-03 at 7 17 07 PM" src="https://user-images.githubusercontent.com/84950398/222870609-172ff967-589a-4cad-8635-e8903ad25f16.png">

## calculateColumnTotal()
By counting the number of predicate nodes we can calcualte the cyclomatic complexity. We see that there are a total of 4 predicate nodes and using the equation of v(G) = 1 + d where "d" is the number of predicate nodes we get the overall cyclomatic complexity to be 5. For the DU paths there will be several possible paths that can be used. One example would be to use the following path: [1,2,3,5,2,4,6,8,4,7]

## getLowerBound() 
By counting the number of predicate nodes we can calcualte the cyclomatic complexity. We see that there are a total of 1 predicate node and using the equation of v(G) = 1 + d where "d" is the number of predicate nodes we get the overall cyclomatic complexity to be 2. One example of a path that could be used to visit each node would be: [1,2] and then [1,3] in order to cover all the nodes. 



# 3 A detailed description of the testing strategy for the new unit tests
The process in creating tests for coverage based testing required the group to follow a preformed pattern that would be predictable to all members. It all starts with understanding how the original code functions. By getting an understanding of the source code group members can exercise their coding techniques to get the best coverage of the source code. Next it was important 


# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage
1. Method : public boolean contains(double value) 
   Class : Range
    This method is utilized to check if the given value in the argument contains in the range. In the assignment 2, we only designed one test case for this method that we also used in the beginning of the third assignment as well. When checking the method       contains in the Rangle.java, we realized there are 6 branches with 2 if statements and else statements and one return staments with two conditions. For each test       branch, we designed test case that increased the coverage percentage.
    
2. Method : public static Range scale(Range base, double factor)
   Class : Range
    This method is utilized to change the range with the given scale, For this method, we identified that there are two branches to this method, one if and else statement. In the assignment we only designed one test case for this         method, but for the assignment three, we designed two test case that checks both true, false of the if statement.
    
3. Method : public static Range expandToInclude(Range range, double value)
   Class : Range
    This method is utilized to expand the range to include the given value, For this method, we identified that there are 6 branches with 3 if statements. One to check if the range is null, one to check if the given value is lower than the     lower boundary and one to check if the given value is higher than the higher boundary. In assignment two, we designed only one test case and for the assignment         three, we designed 6 test cases to check each if else statements.
    
4. Method : public static double calculateColumnTotal(Values2D data, int column)
   Class : DataUtilities
     This method is utilized to calculate the total of the given column. For the assignment two, we designed only one test case, but for this assignment, we created more test cases to check all the 8 branches in the method. There are two for loops and two if else statements that adds upto 8 branches.

5. Method : public static double calculateRowTotal(Values2D data, int row)
   Class : DataUtilities
	This method is utilized to calculate the total of the given row. For the assignment two, we designed only one test case, but for this assignment, we created more test cases to check all the 8 branches in the method. There are two for loops and two if else statements that adds upto 8 branches.

# 5 A detailed report of the coverage achieved of each class and method 

<img width="526" alt="DU1" src="https://user-images.githubusercontent.com/74850874/222872028-8dcf884d-16ec-477c-b504-15e8868020c3.png">
<img width="487" alt="DU2" src="https://user-images.githubusercontent.com/74850874/222872029-1e427808-4c00-4f4f-9011-3df747869f0f.png">
<img width="530" alt="DU3" src="https://user-images.githubusercontent.com/74850874/222872030-3a458d6a-0945-433c-9af1-3457f2d0f741.png">
<img width="536" alt="DU4" src="https://user-images.githubusercontent.com/74850874/222872031-481632b7-9106-44cd-b584-babce8fd90db.png">
<img width="525" alt="DUT1" src="https://user-images.githubusercontent.com/74850874/222872032-97704d54-9c93-4016-9264-0f1ab41b9255.png">
<img width="418" alt="DUT2" src="https://user-images.githubusercontent.com/74850874/222872033-7cfe383c-cba1-48a3-8a86-2c91995f7a3f.png">
<img width="596" alt="DUT3" src="https://user-images.githubusercontent.com/74850874/222872034-f4498fa3-d5b1-450d-b596-5400aecb0dda.png">
<img width="586" alt="DUT4" src="https://user-images.githubusercontent.com/74850874/222872036-ea3a396a-5fc7-4a0a-9efb-4d365ddcb499.png">
<img width="636" alt="DUT5" src="https://user-images.githubusercontent.com/74850874/222872038-5aa14756-699e-4a36-860e-4a38958efa82.png">
<img width="599" alt="DUT6" src="https://user-images.githubusercontent.com/74850874/222872039-9dfb6ec1-4e79-4915-95af-84add7c7dad6.png">
<img width="398" alt="DUT7" src="https://user-images.githubusercontent.com/74850874/222872040-2c0c4b1f-de30-4884-864c-6ea6bc34bfef.png">
<img width="564" alt="R1" src="https://user-images.githubusercontent.com/74850874/222872041-32efefaf-2742-43fa-898c-2f9a8b0ea1ae.png">
<img width="537" alt="R2" src="https://user-images.githubusercontent.com/74850874/222872042-1d6ff523-80d1-40b2-b49f-c24ffce73c45.png">
<img width="513" alt="R3" src="https://user-images.githubusercontent.com/74850874/222872043-40d50a5d-3460-4047-bc9e-50bfaec89a61.png">
<img width="574" alt="R4" src="https://user-images.githubusercontent.com/74850874/222872045-c6ea09cf-9b88-497e-b9a4-c66b723293fb.png">
<img width="590" alt="R5" src="https://user-images.githubusercontent.com/74850874/222872047-5d4bcaa6-c1c2-46e3-abc4-499268fd4314.png">
<img width="656" alt="R6" src="https://user-images.githubusercontent.com/74850874/222872048-3cd6d85b-4e0d-4e59-bf0e-dcf5bad3c537.png">
<img width="498" alt="R7" src="https://user-images.githubusercontent.com/74850874/222872049-b17e4e2a-0d64-4525-90cc-c14df311fe5b.png">
<img width="755" alt="RT1" src="https://user-images.githubusercontent.com/74850874/222872050-85665407-32ad-43b2-b490-c0a948915908.png">
<img width="973" alt="RT2" src="https://user-images.githubusercontent.com/74850874/222872051-d6ca9638-9ee1-4af5-99f7-e51853d30a96.png">
<img width="774" alt="RT3" src="https://user-images.githubusercontent.com/74850874/222872052-ba30abca-ab6d-4e14-9438-c4283a420067.png">
<img width="1363" alt="RT4" src="https://user-images.githubusercontent.com/74850874/222872053-90122141-dd6c-41de-8251-50123c38b6ff.png">
<img width="1098" alt="RT5" src="https://user-images.githubusercontent.com/74850874/222872054-6e94fd3a-64e5-4e49-b6ec-b75890754a90.png">
<img width="807" alt="RT6" src="https://user-images.githubusercontent.com/74850874/222872055-38abad15-9e3b-462b-bd66-c1bdab050ae7.png">
<img width="842" alt="RT7" src="https://user-images.githubusercontent.com/74850874/222872056-03ed1c3c-52d2-4722-8c05-ecf084ed6027.png">
<img width="1092" alt="RT8" src="https://user-images.githubusercontent.com/74850874/222872057-0092358c-c2aa-44dd-b3f1-50f57f580821.png">
<img width="781" alt="RT9" src="https://user-images.githubusercontent.com/74850874/222872059-62a3fde2-c1bf-46da-87e6-a2e1a2e22a05.png">
<img width="862" alt="RT10" src="https://user-images.githubusercontent.com/74850874/222872061-dd071aea-6bf0-4a85-954f-1edb3287d330.png">

# 6 Pros and cons of the coverage tools tried by your group in this assignment, in terms of reported measures, integration with the IDE and other plug-ins, user friendliness, crashes, etc.

Originally all group members ended up trying to use Eclipse to create the coverage tests because that was suggested. After going through some it was later chosen to move to IntelliJ because of the number of tools available to use for the test coverage analysis. However one member was unable to access IntelliJ and kept working on the assignment by using Eclipse. This allowed for the group to understand the small differences between the two IDEs even though they operate similar to each other. 


# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Coverage based test generation and requirements-based test generation come with their own pros and cons. When discussing coverage based testing it is important to keep in mind that it is good in finding parts of the program that are not exercised by a set of test cases. Developers can get a good understanding of how much of the program is being tested whether it be the statement coverage or decision coverage. The drawbacks of control flow coverage is the "reachability" of the program. Some parts of the program may not be executed and therefore it will be impossible to get 100% coverage. control flow testing works better with testing in small batches and not large programs as it is hard to pinpoint exactly where it is executing without the use of tools. 

Requirements based testing also has its advantages and disadvantages. It is more intuitive while it relates to what the software is "supposed" to do and helps developers create tests against how the program should operate. Without a clear definition of the requirements and what is to be expected requirements based testing is essentially useless. It falls on the organization to create a clear and concise list of the requirements for developers to test against.  Requirements based testing does have advantages for example it is good at breaking the project down into smaller pieces that can be analyzed separately. When creating tests for a waterfall approach where the requirements are clear then requirements based testing is ideal. 

# 8 A discussion on how the team work/effort was divided and managed
Team members split the work evenly and worked together to create the new test cases.  All members provided their input to creating the lab report. First members were instructed to try and create tests on their own then the group would come together to decide what elements could be shared between tests and what needed to be removed due to redundancy or efficiency. 

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the assignment

While working on the lab one group member had issues while trying to use IntelliJ IDEA IDE. This was not able to be circumvented and a work around was to have the member use Eclipse IDE instead to work on the lab. Lessons learned were to use the course notes more effectively as they provide a good basis of what testing is and how to use it effectively. 

# 10 Comments/feedback on the assignment itself

Good lab in general one suggestion would be to cross referencing the slides. This would be a nice improvement to give students a good hint on where to look for answers. 
