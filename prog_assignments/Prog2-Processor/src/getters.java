/**
 * @author Ryan Capron
 */

 /**
  * ArrayList imported as data type to hold HTML lines
  */
import java.util.ArrayList;

public class getters {

    /**
     * Declaring private variables
     */
    private ArrayList<String> webdoc;

    /**
     * Public Constructor of getters
     * @param webdoc takes in ArrayList of HTML lines from Prog1-Extractor
     */
    public getters(ArrayList<String> webdoc) {
        this.webdoc = webdoc;
    }

    /**
     * All get methods pulling certain information from the local Arraylist webdoc
     *
     * General algorithm is as follows: 
     * Use ArrayList.contains() method to find which line has relative information
     * Parse unnecessary html syntax
     * return parsed line if found
     * 
     * Regex library imported for future use of regex for Sponsored Bills and Voting Record. 
     * 
     * get name of district representative
     */
    public String getName() {
        String[] name;
        for (String i : webdoc) {
            if (i.contains("Representative")) {
                name = i.split("</a> &gt; ");
                name[2] = name[2].replace("&quot;Rita&quot;", "\"Rita\"");
                name[2] = name[2].replaceAll("</span>", "");
                return name[2];
            }
        }
        return "I do not know the name of the representative";
    }

    // get representative's political party
    public String getParty() {
        for(String i : webdoc) {
            if (i.contains("Republican")) {
                return getName() + "is a Republican";
            }
        }
        return getName() + "is a Democrat";
    }

    /**
     * String is used for parameter as ArrayList.contains takes in String variable
     * @param distNum is number of applicable district
     * @return Counties that representative is responsible for
     */
    public String getRegion(String distNum) {
        String[] line;
        for(String i : webdoc) {
            if (i.contains("District " + distNum)) {
                // Split was used to account for the multiple counties wihtin region
                line = i.split("13px;\">");
                line = line[1].split(" Counties");
                line[0] = line[0].replaceAll("&amp; ", "and ");
                return line[0];
            }
        }
        return "I do not know the counties she is responsible for.";
    }
    
    // get Business Address
    public String getBAdress() {
        String[] line;
        for (int i = 0;i < webdoc.size();i++) {
            if(webdoc.get(i).contains("Columbia Address")) {
                line = webdoc.get(i + 1).split("0;\">");

                line[1] = line[1].replaceAll("<br>", " ");
                line[1] = line[1].replaceAll("</p>", "");

                return line[1];
            }
        }
        return "I do not know the business address";
    }

    // get home address
    public String getHAddress() {
        String[] line;
        for (int i = 0;i < webdoc.size();i++) {
            if(webdoc.get(i).contains("Home Address")) {
                line = webdoc.get(i + 1).split("0;\">");

                line[1] = line[1].replaceAll("<br>", "\n");
                line[1] = line[1].replaceAll("</p>", "");

                return line[1];
            }
        }
        return "I do not know the home address";
    }
    /**
     * get phone numbers of representative's home or business address
     * @param location is used to determine which set of phone numbers to return.
     * @return is representative's phone number for the specified location.
     */
    public String getPhone(String location) {
        String[] line;
        // If branch for finding home phone numbers
        if(location.equalsIgnoreCase("Home")) {
            for (int i = 0;i < webdoc.size();i++) {
                // String array used since there are two home phone numbers
                String[] numbers = new String[2];
                if(webdoc.get(i).contains("Home Phone")) {
                    line = webdoc.get(i).split(location + " Phone</span> ");
                    line[1] = line[1].replaceAll("</p>", "");
                    numbers[0] = line[1];
                    
                    line = webdoc.get(i + 1).split("Business Phone</span> ");
                    line[1] = line[1].replaceAll("</p>", "");
                    numbers[1] = line[1];

                    return getName() + "'s Home Phone numbers are as follows: \nHome Phone: " + numbers[0] + "\nBusiness Phone: " + numbers[1];
                }
            }
            return "I do not know the " + location + " phone";
        }
        // If branch for finding business location phone numbers
        else if(location.equalsIgnoreCase("Business")) {
            for (int i = 0;i < webdoc.size();i++) {
                if(webdoc.get(i).contains("Business Phone")) {
                    line = webdoc.get(i).split("Business Phone</span> ");
                    line[1] = line[1].replaceAll("</p>", "");
                    return getName() + "'s Columbia Phone number is " + line[1];
                }
            }
            return "I do not know the " + location + " phone";
        }
        // Return if invalid input is given
        return "The two available locatoins are \"Home\" and \"Business\" (Not case-sensitive)";
    }

    // get personal information of representative
    public String getPInformation() {
        String pInformation = "";
        for (int i = 0;i < webdoc.size();i++) {
            if(webdoc.get(i).contains("Personal Information")) {
                //pInformation starts two lines after "Personal Information" header
                pInformation = webdoc.get(i + 2);

                pInformation = pInformation.replaceAll("</li><li style=\"margin: 5px 0 0 0; list-style-type:square;\" >", "\n");
                pInformation = pInformation.replaceAll("<li style=\"margin: 5px 0 0 0; list-style-type:square;\" >", "");
                pInformation = pInformation.replaceAll("<i>", "");
                pInformation = pInformation.replaceAll("</i>", "");
                pInformation = pInformation.replaceAll("</li></ul>", "");

                return getName() + "'s personal information is as follows: \n" + pInformation;
            }
        }
        return "fail";
    }

    // get committee assignments of representative
    public String getCAssignments() {
        for (int i = 0; i < webdoc.size();i++) {
            if(webdoc.get(i).contains("Committee Assignments")) {
                String line = webdoc.get(i + 2);
                
                line = line.replaceAll("(<li style=\"margin: 5px 0 0 0; list-style-type:square;\" ><a HREF=\"/committee[.]php[?]chamber=H#...\">)", "\n");
                line = line.replaceAll("(</a></li></ul>)|(</a></li>)", "");
                line = line.replaceAll("</span>|<span.*\">", "");
                
                return getName() + "\'s Committee Assignments are: " + line;
            }
        }
        return "I do not know the Committee Assignments";
    }
    //get Service In PUblic Office
    public String getSIPO() {
        for (int i = 0;i < webdoc.size();i++) {
            if (webdoc.get(i).contains("Service In Public Office")) {
                String ret = webdoc.get(i + 2);

                ret = ret.replaceAll("<li style=\"margin: 5px 0 0 0; list-style-type:square;\" >", "-");
                ret = ret.replace("</li></ul>","");
                ret = ret.replace("</li>", "\n");

                return ret;
            }
        }
        return "I do not know the Service In Public Office";
    }

}
