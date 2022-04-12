import java.io.FileDescriptor;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.io.FileOutputStream;
import java.util.regex.*;

public class logDriver {

    public static sessionLogger SessionLogger = new sessionLogger();

    public static String logTest(String question) {
        ByteArrayOutputStream systemOut = new ByteArrayOutputStream();   

        System.setOut(new PrintStream(systemOut)); 
        routeQuestion(question);
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        
        return systemOut.toString();
    }

    public static void routeQuestion(String question) {
        String lcQuestion = question.toLowerCase();
        List<String> splitQuestion = Arrays.asList(lcQuestion.split(" "));
        int chats = SessionLogger.getTotalChats();
        int chatNum = 0;
        int temp;
        Pattern digit = Pattern.compile("([0-9]{1,})");
        Matcher finder = digit.matcher(question);

        while (finder.find()) {
            if ((temp = Integer.parseInt(finder.group(0))) < chats) {
                chatNum = temp;
            }
        }

        if (splitQuestion.contains("summary")) {
            SessionLogger.printChatSummary(chatNum);
        }
        else if (splitQuestion.contains("show") && splitQuestion.contains("chat")
                    && splitQuestion.contains("summary")) {
            SessionLogger.printChat(chatNum);
            SessionLogger.printChatSummary(chatNum);
        }
        else if (splitQuestion.contains("show") && splitQuestion.contains("chat")) {
            SessionLogger.printChat(chatNum);
        }
        else {
            System.out.println("I'm sorry I do not know how to answer that.");
        }
    }

    public static void routeQuestion(String question, int chatNum) {
        String lcQuestion = question.toLowerCase();
        List<String> splitQuestion = Arrays.asList(lcQuestion.split(" "));

        if (chatNum > SessionLogger.getTotalChats()) {
            System.out.println("There are only " + SessionLogger.getTotalChats() + " chat sessions. Please choose a valid number.");
        }
        else if (splitQuestion.contains("summary")) {
            SessionLogger.printChatSummary(chatNum);
        }
        else if (splitQuestion.contains("show") && splitQuestion.contains("chat")
                    && splitQuestion.contains("summary")) {
            SessionLogger.printChat(chatNum);
            SessionLogger.printChatSummary(chatNum);
        }
        else if (splitQuestion.contains("show") && splitQuestion.contains("chat")) {
            SessionLogger.printChat(chatNum);
        }
        else {
            System.out.println("I'm sorry I do not know how to answer that.");
        }
    }
}
