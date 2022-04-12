public class commandQueries {
    public static void print(String[] args) {
        sessionLogger SessionLogger = new sessionLogger();
        if (args.length == 1 && args[0].equalsIgnoreCase("-summary")) {
            System.out.print("There are " + SessionLogger.getTotalChats() + " chats to date with ");
            System.out.print("users asking "+ SessionLogger.getTotalUQueries() + " times and ");
            System.out.print("system responding " + SessionLogger.getTotalSQueries() + " times.  Total Duration is " + SessionLogger.getTotalDuration() + " HH:MM:SS.");
        }
        else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("-summary")) {
                SessionLogger.printChatSummary(Integer.parseInt(args[1]));
            }
            else if (args[0].equalsIgnoreCase("-showChat-Summary")) {
                SessionLogger.printChat(Integer.parseInt(args[1]));
                SessionLogger.printChatSummary(Integer.parseInt(args[1]));
            }
            else if (args[0].equalsIgnoreCase("-showChat")) {
                SessionLogger.printChat(Integer.parseInt(args[1]));
            }
        }
        else {
            System.out.print("The required arguments are <request> <chatNumber>");
        }
    }
}