/**
 * @author Ryan Capron
 */

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class prog2processor {
    public static void main(String[] args) {
        ArrayList<String> html = readHTML();
        getters get = new getters(html);

        if (args[0].equalsIgnoreCase("name")) {
            System.out.println(get.getName());
        }
        else if (args[0].equalsIgnoreCase("party")) {
            System.out.println(get.getParty());
        }
        else if (args[0].equalsIgnoreCase("region")) {
            System.out.println(get.getRegion("36"));
        }
        else if (args[0].equalsIgnoreCase("home address")) {
            System.out.println(get.getHAddress());
        }
        else if (args[0].equalsIgnoreCase("business address")) {
            System.out.println(get.getBAdress());
        }
        else if (args[0].equalsIgnoreCase("home phone")) {
            System.out.println(get.getPhone("Home"));
        }
        else if (args[0].equalsIgnoreCase("business phone")) {
            System.out.println(get.getPhone("Business"));
        }
        else if (args[0].equalsIgnoreCase("Personal Information")) {
            System.out.println(get.getPInformation());
        }
        else if (args[0].equalsIgnoreCase("Committee Assignments")) {
            System.out.println(get.getCAssignments());
        }
        else if (args[0].equalsIgnoreCase("Service in Public Office")) {
            System.out.println(get.getSIPO());
        }
        else {
            System.out.println("I'm sorry I do not currently support that argument.  Please check test_output.txt in the test folder for supported arguments.");
        }
    }

    public static ArrayList<String> readHTML() {
        //then convert getters to regex then Javadoc and clean up then done 
        ArrayList<String> ret = new ArrayList<String>();
        try {
            String currLine;
            BufferedReader html = new BufferedReader(new FileReader("../data/html.txt"));
            while ((currLine = html.readLine()) != null) {
                ret.add(currLine);
            }
            html.close();        
        } catch (Exception e) {
            System.out.println(e);
        }
        return ret;
    }
}