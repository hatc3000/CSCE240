/**
 * @author Ryan Capron
 */

/**
 * IO library for writing to txt and csv files.
 * Time library to calculate duration of conversations
 * Time.format library for formatting time
 * ArrayList used to hold user and system utterance
 */
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class sessionLogger {
    /** Declaring all private variables 
     * Initializing date time formatters and the CSV_PATH
     */
    private String startTime;
    private String duration;
    private String startDate;
    private ArrayList<String> userUtterance;
    private ArrayList<String> systemUtterance;
    private ArrayList<String[]> CSVStrings;
    private DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private DateTimeFormatter timePattern = DateTimeFormatter.ofPattern("HH:mm:ss");
    private String CSV_PATH = "./prog5-sessionlogger/data/chat_statistics.csv";
    
    /** Public constructor of sessionLogger 
     * Constructs ArrayLists
     *  Starts the timer to calculate end statistics
     */
    public sessionLogger() {
        userUtterance = new ArrayList<String>();
        systemUtterance = new ArrayList<String>();

        setDateTime();
        setCSV();
    }

    // Write session statistics to new CSV line
    public void writeToCSV() {
        try (FileWriter fw = new FileWriter(CSV_PATH, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);) {
            
            StringBuilder chatSession = new StringBuilder();
            
            chatSession.append(getChatNumber());
            chatSession.append(',');
            chatSession.append(getChatFile());
            chatSession.append(',');
            chatSession.append(getUQueryNum());
            chatSession.append(',');
            chatSession.append(getSQueryNum());
            chatSession.append(',');
            chatSession.append(duration);

            pw.println(chatSession.toString());
        } catch(IOException i) {
            i.printStackTrace();
        }
    }

    // Write session statistics to new TXT file
    public void writeToTxt() {
        File file = new File("./prog5-sessionlogger/data/chat_sessions/chatSession" + getChatFile());

        try (FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);) {
            StringBuilder chatSession = new StringBuilder();

            if (userUtterance.size() == systemUtterance.size()) {
                for (int i = 0; i < userUtterance.size();i++) {
                    chatSession.append("User: " + userUtterance.get(i) + "\n");
                    chatSession.append("System: " + systemUtterance.get(i) + "\n");
                }
                chatSession.append("\n#user_utterance: " + userUtterance.size());
                chatSession.append("\n#system_utterance: " + systemUtterance.size() + "\n");
                chatSession.append("Chat duration: " + duration);
            }

            pw.println(chatSession.toString());

        } catch(IOException i) {
            i.printStackTrace();
        }
    }

    // Return chat file name
    private String getChatFile() {
        return getChatNumber() + "_" + getDateTime() + ".txt";
    }

    /**
     * @return index where chat session will be recorded
     */
    private int getChatNumber() {
        File folder = new File("./prog5-sessionLogger/data/chat_sessions");
        File[] chatFiles = folder.listFiles();
        int lastChat = 0;

        for (int i = 0;i < chatFiles.length;i++) {
            if (chatFiles[i].isFile()) {
                int chatNum = (Integer.parseInt(String.valueOf(chatFiles[i].toString().charAt(52))));
                if (chatNum > lastChat) {
                    lastChat = chatNum;
                }
            };
        }
        return lastChat + 1;
    }

    // Sets the local date and time to now
    private void setDateTime() {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        startDate = date.format(datePattern);
        startTime = time.format(timePattern);
    }
    private String getDateTime() {
         return startDate + '_' + startTime;
    }
    
    public int getUQueryNum() {
        return userUtterance.size();
    }
    public int getSQueryNum() {
        return systemUtterance.size();
    }
    private String getEndTime() {
        LocalTime localTime = LocalTime.now();
        return timePattern.format(localTime);
    }

    /**
     * Calculates the duration between start time and end time sets local variable duration
     */
    public void setDuration() {
        String[] splitStartTime = startTime.split(":");
        String[] splitEndTime = getEndTime().split(":");

        int sSeconds = (Integer.parseInt(splitStartTime[0]) * 360) + (Integer.parseInt(splitStartTime[1]) * 60) + Integer.parseInt(splitStartTime[2]);
        int eSeconds = (Integer.parseInt(splitEndTime[0]) * 360) + (Integer.parseInt(splitEndTime[1]) * 60) + Integer.parseInt(splitEndTime[2]);

        int sDuration = eSeconds - sSeconds;
        int hours = sDuration / 60;
        int minutes = sDuration / 360;
        int seconds = sDuration % 360;

        duration = String.valueOf(hours) + ":" + String.valueOf(minutes) + ":" + String.valueOf(seconds);
    }

    /**
     * Prints the chat session to user console
     * @param chatNumber is number of the chat session to print
     */
    public void printChat(int chatNumber) {
        String chatPath = "./prog5-sessionLogger/data/chat_sessions/chatSession" + CSVStrings.get(chatNumber)[1];
        File chatFile = new File(chatPath);

        try (FileReader txtReader = new FileReader(chatFile);
        BufferedReader bufferedReader = new BufferedReader(txtReader);) {
            String line = "";
            while (!(line = bufferedReader.readLine()).equals("")) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints the chat summary to the user's console
     * @param chatNumber is the number of the chat session to print
     */
    public void printChatSummary(int chatNumber) {
        String chatPath = "./prog5-sessionLogger/data/chat_sessions/chatSession" + CSVStrings.get(chatNumber)[1];
        File chatFile = new File(chatPath);
        ArrayList<String> chat = new ArrayList<String>();

        try (FileReader txtReader = new FileReader(chatFile);
        BufferedReader bufferedReader = new BufferedReader(txtReader);) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                chat.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = chat.size() - 3;i < chat.size();i++) {
            System.out.println(chat.get(i));
        }
    }

    /** Initializes the local ArrayList CSVStrings with all lines of the CSV File */
    public void setCSV() {
        File CSVFile = new File(CSV_PATH);
        CSVStrings = new ArrayList<String[]>();
        try (FileReader CSVreader = new FileReader(CSVFile);
                BufferedReader bufferedReader = new BufferedReader(CSVreader);) {    
            
            String line = "";
            String[] splitLine;

            while ((line = bufferedReader.readLine()) != null) {
                splitLine = line.split(",");
                CSVStrings.add(splitLine);
            }

        } catch(IOException i) {
            i.printStackTrace();
        }
    }
    public int getTotalChats() {
        return getChatNumber() - 1;
    }
    public int getTotalUQueries() {
        int totalQueries = 0;

        for (int i = 1;i < CSVStrings.size();i++) {
            totalQueries += Integer.parseInt(CSVStrings.get(i)[2]);
        }

        return totalQueries;
    }
    public int getTotalSQueries() {
        int totalQueries = 0;

        for (int i = 1;i < CSVStrings.size();i++) {
            totalQueries += Integer.parseInt(CSVStrings.get(i)[3]);
        }

        return totalQueries;
    }

    /**
     * Parses the duration into integers to calculate total duration of all chat sessions
     * @return total duration of all chat sessions in String type
     */
    public String getTotalDuration() {
        int hours = 0;
        int minutes = 0;
        int seconds = 0;

        for (int i = 1;i < CSVStrings.size();i++) {
            String[] splitTime = CSVStrings.get(i)[4].split(":");
            hours += Integer.parseInt(splitTime[0]);
            minutes += Integer.parseInt(splitTime[1]);
            seconds += Integer.parseInt(splitTime[2]);
        }

        if (minutes >= 60) {
            hours += (minutes / 60);
            minutes = minutes % 60;
        }
        if (seconds >= 60) {
            minutes += (seconds / 60);
            seconds = seconds % 60;
        }
        return String.valueOf(hours) + ":" + 
                    String.valueOf(minutes) + ":" +
                    String.valueOf(seconds);
    }

    /**
     * Adds user query to local ArrayList
     * @param query is user utterance
     */
    public void addUQuery(String query) {
        userUtterance.add(query);
    }

    /**
     * Adds system query to local ArrayList
     * @param query is system utterance
     */
    public void addSQuery(String query) {
        systemUtterance.add(query);
    }

    /**
     * Calculates the total duration and sets local variable
     * Writes statistics to CSV File
     * Writes chat session to TXT File
     * Provides successful recording message
     */
    public void close() {
        setDuration();
        writeToCSV();
        writeToTxt();
        System.out.println("Session logger successfully closed and record was written");
    }
}
