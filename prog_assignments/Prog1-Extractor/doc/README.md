@author Ryan Capron


Information Chatbot for a South Carolina District Governor
This chatbot will answer any questions with up to date information about a South Carolina member of State Legislature.

This bot must answer all questions even if answer is I don't know.
For each answer have array of strings in which if matched will run method
run each answer in method format
greeting in method format
pull html and use regex to pull certain information


Main methods and variables
+Main
+Greeting
+Run


BEChatBot methods and variables
-ArrayList webdoc to hold HTML information
-String WEBSITE containing website url without the district code
-URLConnection url to connect to district url for dynamic data pull
+Public constructor taking in URLCode to determine full district URL.
    Takes in all HTML information and puts it into webdoc
    Runs cleanData which removes all irrelavent chatbot information
-outputFile outputs all webdoc information into html.txt in data folder
-cleanData removes all irrelavent chatbot information
+get methods find desired information line and then filters out HTML syntax returning easy to read lines
    These could be classified as part of Program Two


Information about project reqs from class slides follows,

Goal: extract data from the district of choice
• Language of choice: Any from the three (C++, Java, Python) - Program is going to be written in Java
• Program should do the following:
    • Take district name as input
    • Read content from the district’s URL or a local text version of the district page 
    • Report statistics of content: lines, words, chars
        Can implement this very easily with current implemented logic
    • Write content out in an output file formatted with indentation
• Code organization
• Create a folder in your GitHub called “prog1-extractor”
• Have sub-folders: src (or code), data, doc, test
    Also have .vscode and bin to satisfy the VSCode environment
• Write a 1-page report in ./doc sub-folder
• Send a confirmation that code is done to instructor and TA, and update Google sheet
Programming assignment programs will: (1) extract data from the district, (2) process it, (3) make content available in a command-line interface, (4) handle any user query and (5) report on interaction statistics.

Once you select a district, the elected legislator is fixed. • Some simplifications
• Download local copy v/s web query
    Did a web query and
• Read static content first
• Handle a subset of content
• Have default handling for questions the chatbot does not understand
    This is included in get methods but in the future may implement private DoNotKnow method
• Do project in a language you are most comfortable with
• Use all advanced programming concepts to simplify coding

Input: from user (called utterance) - Not relavent for program 1
• Problem specific query (i.e., about district chosen) 
• Chitchat
• Unrelated
• Output: from system (response) • Handle unrelated
• Handle chitchat
• Answer to query
• Do it until user say over!
Handling different data types
Show formatted content!
 