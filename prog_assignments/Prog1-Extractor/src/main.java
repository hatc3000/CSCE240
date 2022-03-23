/**
 * @author Ryan Capron
 */

import java.util.Scanner;

public class main {

    /**
     * Constant static variable containing the desired district and URL code for district
     * In future iterations hoping to post a PHP query with district number to allow for any representative to be chatbotted with
     */
    public static String[] DISTRICT = {"36","0015909089"};

    public static void main(String[] args) {
        run();
    }
    
    public static void run() {
        greeting();
        extractor chatbot = new extractor(DISTRICT[1]);
        System.out.println(chatbot.getPInformation());
    }

    /**
     * Greets the user and allows for input of district.  Due to currently solely supporting district 36 this method will set DISTRICT to 36 if user does not input "36"
     */
    public static void greeting() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What district would you like to talk about? (Enter " + DISTRICT[0] + ")");
        String districtCheck = keyboard.nextLine();

        if (!districtCheck.equals(DISTRICT[0])) {
            System.out.println("This is the district 36 chatbot. Setting district to 36");
        }
        System.out.println("Welcome to the SC Congress District " + DISTRICT[0] + " Chatbot!");

        keyboard.close();
    }
}