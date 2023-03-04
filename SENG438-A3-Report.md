
**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#3 – Coverage-Based Test Generation**

| Group \#:      | 9    |
| -------------- | --- |
| Student Names | |
| Sina Pordanesh  | |
| Thevin Mahawatte | |
| Bryant Stevnes |                |
| Noureldin Amer |                    |



# 1 Introduction

The following lab report will be showing information on assignment 3. The assignment focuses on JUnit testing and how to improve the previous assignment with better tests that lead to more coverage of the code. Discussions about the complexity analysis are included. 

# 2 Manual data-flow coverage calculations the two mentioned methods
<img width="532" alt="Screen Shot 2023-03-03 at 7 16 59 PM" src="https://user-images.githubusercontent.com/84950398/222870598-e4d61cbe-5770-4651-bebf-b556b6a76807.png">
<img width="427" alt="Screen Shot 2023-03-03 at 7 17 07 PM" src="https://user-images.githubusercontent.com/84950398/222870609-172ff967-589a-4cad-8635-e8903ad25f16.png">

## calculateColumnTotal()
By counting the number of predicate nodes we can calcualte the cyclomatic complexity. We see that there are a total of 4 predicate nodes and using the equation of v(G) = 1 + d where "d" is the number of predicate nodes we get the overall cyclomatic complexity to be 5. 

## getLowerBound() 
By counting the number of predicate nodes we can calcualte the cyclomatic complexity. We see that there are a total of 1 predicate node and using the equation of v(G) = 1 + d where "d" is the number of predicate nodes we get the overall cyclomatic complexity to be 2. 



# 3 A detailed description of the testing strategy for the new unit tests
The process in creating tests for coverage based testing required the group to follow a preformed pattern that would be predictable to all members. It all starts with understanding how the original code functions. By getting an understanding of the source code group members can exercise their coding techniques to get the best coverage of the source code. Next it was important 


# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage


# 5 A detailed report of the coverage achieved of each class and method 

(a screen shot from the code cover results in green and red color would suffice)


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
