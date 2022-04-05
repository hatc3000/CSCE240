The session logger chat performs two main functions of recording all chat's and calculating statistics from the chats.

ALl chats will be recorded in .txt format in the ./data/chat_sessions directory.  Within each text file will be the full chatbot recording followed by the number of user utterance, the number of system utterance and the full duration of the chat.  

The session logger is able to calculate the following statistics through private and public methods:
get total user queries, get total system queries, get total chatbot session uses, get total user queries from all sessions, get total system queries from all sessions, and get total duration from all sessions.
