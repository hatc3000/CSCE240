/**
 * @file EmailInformationExtractor.cpp
 * @author Ryan Capron
 * @brief HW4 for CSCE 240
 * @date 2022-02-28
 */

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

// Parent and child classes
#include "./headers/BaseEmail.h"
#include "./headers/Gmail.h"
#include "./headers/Outlook.h"

// Method to read in header files
string readTXT(string filePath) {
    string ret;
    ifstream inFile (filePath);

    //Error handling if file not found
    if (!inFile) {
        cerr << "Unable to open file" << filePath;
        exit(1);   // call system to stop
    }

    string currLine;
    while (!inFile.eof()) {
        getline(inFile, currLine);
        ret += currLine + "\n";
    }
    inFile.close();
    return ret;
}
int main() {
    /**
     * Declare gmail and outlook file paths in a string
     * Initialize a gmail and outlook class with respective txt file
     */
    string gmailTXT = readTXT("../data/gmailHeader.txt");
    string outlookTXT = readTXT("../data/outlookHeader.txt");
    Gmail ge = Gmail(gmailTXT);
    Outlook oe = Outlook(outlookTXT);
    BaseEmail be = BaseEmail();
    
    //Type in command here
    

    oe.getAuthR();


    // string uInput;
    // cout << "Would you like to parse a (gmail) or (outlook) header?" << endl;
    // cin >> uInput;
    
    // if (uInput == "gmail") {
    //     be.setHeader(gmailTXT);
    // }
    // else if (uInput == "outlook") {
    //     be.setHeader(outlookTXT);
    // }
    // else {
    //     cerr << "Invalid input inputted";
    //     exit(1);
    // }

    // ge.getCType();
    // oe.getCType();
    // be.getCType();

    return 0;
}