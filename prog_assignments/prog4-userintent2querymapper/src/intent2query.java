/**
 * @author Ryan Capron
 */

public class intent2query {
    /**
     * Declaring private variables
     * uInput is the user query
     * wordMatches is the number of keywords in user query
     * queryLength is the number of words in user query
     */
    private String uInput;
    private int wordMatches;
    private int queryLength;
    
    /**
     * Constructor for class
     * Calls getMatches and countWords method
     * Calls printResults method to System print out match percentage and ratio
     * @param uInput is the user query
     */
    public intent2query(String uInput) {
        this.uInput = uInput;
        wordMatches = getMatches();
        queryLength = countWords(uInput);

        printResults();
    }

    // Prints the query match percentage and ratio
    private void printResults() {
        System.out.println(getMatchPercent());
        System.out.println(getRatio());
    }

    // Counts words in user query for use in percentage and ratio
    private int countWords(String string) {
        String[] wordArray = string.split(" ");

        return wordArray.length;
    }

    // returns match percent in user readable format
    public String getMatchPercent() {
        int matchPercent = wordMatches * 100 / queryLength;

        return matchPercent + "% of the user query contains keywords";
    }

    // returns match ratio in user readable format
    public String getRatio() {
        return "the ratio of keywords to query words is " + wordMatches + " : " + (queryLength - wordMatches);
    }

    // returns the number of keywords in user query
    private int getMatches() {
        String LCQuery = uInput.toLowerCase();
        if (LCQuery.contains("tell me about") || LCQuery.contains("personal") || LCQuery.contains("whats she like")) {
            if (LCQuery.contains("tell me about") || LCQuery.contains("whats she like")) {
                return 3;
            }
            else if (LCQuery.contains("personal")) {
                return 1;
            }
        }
        else if ((LCQuery.contains("where") && LCQuery.contains("live"))) {
            return 2;
        }
        else if (LCQuery.contains("where")) {
            return 1;
        }
        else if (LCQuery.contains("contact") && LCQuery.contains("phone")) {
            if (LCQuery.contains("home")) {
                return 3;
            }
            else {
                return 2;
            }
        }
        else if (LCQuery.contains("contact") || LCQuery.contains("phone")) {
            if (LCQuery.contains("home")) {
                return 2;
            }
            else {
                return 1;
            }
        }
        else if (LCQuery.contains("address")) {
            if (LCQuery.contains("home")) {
                return 2;
            }
            else {
                return 1;
            }
        }
        else if (LCQuery.contains("committees")) {
            return 1;
        }
        else if (LCQuery.contains("party")) {
            return 1;
        }
        else if (LCQuery.contains("sponsored") && LCQuery.contains("bills")) {
            return 2;
        }
        else if (LCQuery.contains("vote") && LCQuery.contains("history")) {
            return 2;
        }
        else if (LCQuery.contains("region") && LCQuery.contains("counties")) {
            return 2;
        }
        else if (LCQuery.contains("region") || LCQuery.contains("counties")) {
            return 1;
        }
        else if (LCQuery.contains("service") || LCQuery.contains("public")) {
            return 1;
        }
        else if (LCQuery.contains("public office")) {
            return 2;
        }
        else if (LCQuery.contains("everything")) {
            return 1;
        }
        else if (LCQuery.contains("hi") || LCQuery.contains("hello")) {
            return 1;
        }
        else if (LCQuery.contains("summary")) {
            return 1;
        }
        else if (LCQuery.contains("show") && LCQuery.contains("chat") && LCQuery.contains("summary")) {
            return 3;
        }
        else if (LCQuery.contains("show") && LCQuery.contains("chat")) {
            return 2;
        }
        else if (LCQuery.contains("region") || LCQuery.contains("counties") || LCQuery.contains("district")) {
            int ret = 0;
            if (LCQuery.contains("region")) {
                ret++;
            }
            if (LCQuery.contains("counties")) {
                ret++;
            }
            if (LCQuery.contains("district")) {
                ret++;
            }
            return ret;
        }
        else {
            // if no keywords found return 0
            return 0;
        } 
        return 0;
    }
}
