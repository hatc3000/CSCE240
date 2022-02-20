This is the processing portion of the district chatbot.

This adopts a couple of methods from Program 1.  These methods are in relation to data processing and converting the html.txt to a String ArrayList for more efficient searching.

The class imports the html file into a String ArrayList line by line.  This allows each method to find information relavent to the query request.
Once the relavent information is found, the method parses the information through regex and the replaceAll method and returns the parsed string.

The prog2processor class contains the main method.  Within this main method is the if else statement calling the appropriate command for the given argument (argument can be found in test_output.txt in test folder.).

The html text is currently being read from Prog2-Processor/data/html.txt.  In future iterations when bringing all portion of the project together it will be read from Prog1-Extractor/data/html.txt after the extractor downloads a dynamic copy.  This is planning on being iterated in the MakeFile in the run folder (CSCE240/prog_assignments/Run/makefile).

