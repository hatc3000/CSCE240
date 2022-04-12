PROGRAM INFORMATION
Program 4 of the chatbot allows the user and/or developer to see match statistics between the user query and keywords.  

Program 3 ran get methods from the prog2-processor based on which keywords were found in the user query.  For example if "where" and "live" were in the user query, then the chabot would assume the user wants the representative's home address and respectively would print the getHomeAddress method.  If a user query were very elaborate for example, "Where did the representative live five years ago?" then the chatbot would potentially return the wrong answer.  

The previous query, "Where did the representative live five years ago?" has a match percentage of 25% and ratio of keywords to query words of 2 : 6.  This percentage is much lower than a question such as "Where does she live?". When "Where does she live" is inputted then the percentage match and ratio would be 50% and 2 : 2 respectively.  

If data is recorded on chatbot's keyword match percentages and ratio then we can see as developers when to further the functionality of the chatbot to better answer user queries.  Alternatively, we can also see when the chatbot is accurately answering user requests.

RUN DIRECTIONS
The main method to run this program is the user interface class with the class path of /prog3-ui/src/userInterface.java
To run this program you need to make sure all src paths are configured in your classpath.  These src paths are as follows, "Prog1-Extractor/src", "Prog2-Processor/src", "prog3-ui/src", "prog4-userInterface/src".