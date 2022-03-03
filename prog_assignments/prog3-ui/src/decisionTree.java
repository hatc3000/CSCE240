/**
 * @author Ryan Capron
 */

import java.util.ArrayList;

public class decisionTree {
    /** Declaring private instance of Prog2 getters class */
    private getters get;

    /** public parameterized constructor */
    public decisionTree(ArrayList<String> webdoc) {
        get = new getters(webdoc);
    }

    public String answers(String input) {
        /** 
         *  Convert input to all lowercase 
         * In a try catch block in case input is not characters
         */
        try {
            input = input.toLowerCase();   
        } catch (Exception e) {
            System.out.println(e);
            return "Please enter valid input";
        }

        /**
         * if else branches to return correct information
         * information is returned based on substrings contained in input
         * in try catch in case of invalid input
         */
        try {    
            if (input.contains("tell me about") || input.contains("personal") || input.contains("whats she like")) {
                return get.getPInformation();
            }
            else if ((input.contains("where") && input.contains("live"))) {
                return get.getHAddress();
            }
            else if (input.contains("where")) {
                return get.getBAdress();
            }
            else if (input.contains("contact") || input.contains("phone")) {
                if (input.contains("home")) {
                    return get.getPhone("Home") + "\n" + get.getHAddress();
                }
                else {
                    return get.getPhone("Business") + "\n" + get.getBAdress();
                }
            }
            else if (input.contains("address")) {
                if (input.contains("home")) {
                    return get.getHAddress();
                }
                else {
                    return get.getBAdress();
                }
            }
            else if (input.contains("committees")) {
                return get.getCAssignments();
            }
            else if (input.contains("party")) {
                return get.getParty();
            }
            else if (input.contains("sponsored") && input.contains("bills")) {
                return get.getSBills();
            }
            else if (input.contains("vote") && input.contains("history")) {
                return get.getVHistory();
            }
            else if (input.contains("region") || input.contains("counties")) {
                return get.getRegion("36");
            }
            else if (input.contains("service") || input.contains("public office") 
                        || input.contains("public")) {
                            return get.getSIPO();
                        }
            else if (input.contains("everything")) {
                String retA = get.getName() + "\n" + 
                        get.getParty() + "\n" +   
                        get.getRegion("36") + "\n" + 
                        get.getBAdress() + "\n" + 
                        get.getPhone("business") + "\n" + 
                        get.getCAssignments() + "\n";
                
                System.out.println(retA);
                return "test";
            }
            else if (input.contains("hi") || input.contains("hello")) {
                return "Hi, thank you for using this chatbot!";
            }
            else {
                return "I'm sorry I do not know how to answer that.";
            }
        } catch (Exception e) {
            System.out.println(e);
            return "ERROR";
        }
    }
    //getName is used for Main class's greeting locally
    public String getName() {
        return get.getName();
    }
}

