# Flipkart-Overflow

Duration: 90 min

Description:
Flipkart is starting a new question answer platform for developers. In this social media platform, we will enable users to ask any tech related questions and get some awesome answers.

Features:
Signup for new users and create a profile having some user details like name, profession etc.


Users should be able to login/logout. (For simplicity you can assume only one user can be logged in at a time)


Users can subscribe/unsubscribe from topics (like ‘java’, python etc..).


Users should be able to filter their feeds on topics.


Users should be able to view details of a single question and their responses. Questions should have basic information such as user / topics / timestamp.


Users can ask questions which must be attached to at least one topic. They can attach any number of topics to the questions. Users can answer questions only if they have subscribed to that topic to which the question belongs.

Only logged in users can ask and answer questions / but any user can view questions

Bonus:

Users can upvote questions/answers only if they have subscribed to that topic to which the question belongs.

Responses to the questions are sorted based on number of votes

Other Notes:
Do not use any database or NoSQL store, use in-memory data-structure for now. 
Do not create any UI for the application.
Write a driver class for demo purposes. Which will execute all the commands at one place in the code and have test cases to test multiple users.
Please prioritize code compilation, execution and completion. 
Work on the expected output first and then add good-to-have features of your own.

Expectations:
Make sure that you have working and demonstrable code.
Make sure that code is functionally correct.
Make sure concurrent requests are handled appropriately.
Code should be modular and readable.
Separation of concern should be addressed.
Code should easily accommodate new requirements with minimal changes.
Code should be easily testable.
Code should have proper error handling


Test cases: 
(Test-cases are defined for understanding feature requirements only. Please model it appropriately based on your service implementation)
user_signup(‘Sachin’, ‘Developer’);  // name, Developer
subscribe(‘java’, ‘hadoop’, ‘jdk’); // list of topics to subscribe
add_questions(“What are new open source jdks?”, topic=[”java”, “jdk”])
add_questions(“Does Hadoop work on JDK 11?”, topic=[”hadoop”, ‘jdk’])
show_feed();
show_feed(filter=[’java’]) // only shows 1st question
show_feed(filter=[‘jdk’]) // shows both questions
show_feed(answered=true) //shows no question as no one has answer
logout();
