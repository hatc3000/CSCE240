public class testDriver {
    public static void main(String[] args) {
        sessionLogger SessionLogger = new sessionLogger();
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("summary")) {
                SessionLogger.printChatSummary(Integer.parseInt(args[1]));
            }
            else if (args[0].equalsIgnoreCase("showChat-Summary")) {
                SessionLogger.printChat(Integer.parseInt(args[1]));
                SessionLogger.printChatSummary(Integer.parseInt(args[1]));
            }
            else if (args[0].equalsIgnoreCase("showChat")) {
                SessionLogger.printChat(Integer.parseInt(args[1]));
            }
        }
        else {
            System.out.print("The required arguments are <request> <chatNumber>");
        }
    }
}
