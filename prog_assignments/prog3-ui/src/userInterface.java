/**
 * @author Ryan Capron
 */

 /**
  * Scanner is used to take in user inputs.
  */
import java.util.Scanner;

public class userInterface {
    // HardCoded District and corresponding URLCode for District 36.
    public static String[] DISTRICT = {"36","0015909089"};
    public static void main(String[] args) throws Exception {
        userInterface.run();
    }

    public static void run() {
        /**
         * Declare and initialize Program 1 class to import information into decisionTree
         * Declare and initialize decision tree class 
         * Initialize keyboard scanner for input
         */ 
        extractor Extractor = new extractor(DISTRICT[1]);
        decisionTree DecisionTree = new decisionTree(Extractor.getHTMLArray());
        intent2query intent2Query;
        sessionLogger SessionLogger;
        SessionLogger = new sessionLogger();
        String response;
        Scanner keyboard = new Scanner(System.in);

        /** While loop to allow for multiple commands */
        greeting();
        boolean repeat = true;
        while (repeat) {
            System.out.println("What would you like to know about the " + Extractor.getName() + "?\nYou can also type quit or q to quit!");
            String question = keyboard.nextLine();

            if (question.length() == 0 || question == null) {
                System.out.println("I'm sorry type out your question or (q) to quit");
            }
            else if (question.equalsIgnoreCase("quit") || question.equalsIgnoreCase("q")) {
                System.out.println("Have a great day!");
                repeat = false;
            }
            else {
                response = DecisionTree.answers(question);
                SessionLogger.addUQuery(question);
                SessionLogger.addSQuery(response);
                intent2Query = new intent2query(question);
                System.out.println(response);
            }
        }
        SessionLogger.close();
        keyboard.close();
    }

    /**
     * Greets the user and allows for input of district.  Due to currently solely supporting district 36 this method will set DISTRICT to 36 if user does not input "36"
     */
    public static void greeting() {
        System.out.println("Welcome to the SC Congress District " + DISTRICT[0] + " Chatbot!");
    }
}
