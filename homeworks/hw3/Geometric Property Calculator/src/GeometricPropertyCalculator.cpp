/**
 * @file GeometricPropertyCalculator.cpp
 * @author Ryan Capron
 * @brief 
 * @version 0.1
 * @date 2022-01-26
 * 
 * @copyright Copyright (c) 2022
 * 
 */

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {

    //declare file names and User desired operation
    string inputFile = "./data/input.txt";
    string outputFile = "./data/output.txt";
    string operation;
    string shapeType;

    //take in user operation
    cout << "Enter \"area\" or \"perimeter\"" << endl;
    cin >> operation;

    //Opening file if valid filename
    ifstream input (inputFile);
    ofstream output (outputFile);
    if (!input) {
        cerr << "Unable to open file input.txt";
        return 0;
    }

    //getting shape type to determine math operations
    getline(input, shapeType);

    //if chain determining what operations based on shapeType
    if (shapeType == "RECTANGLE") {
        
        //declaring and populating variables
        string sLength;
        string sBreadth;
        getline(input, sLength);
        getline(input, sBreadth);

        if (sLength.empty() || sBreadth.empty()) {
            output << "Not enough information to calculate" << endl;
        }
        else {
            //converts string to integers
            int length = stoi(sLength);
            int breadth = stoi(sBreadth);

            if(operation == "area") {
            output << "area of the rectangle is " << length * breadth << endl;
            }
            else if (operation == "perimeter") {
                output << "Perimeter of the rectangle is " << (length * 2) + (breadth * 2) << endl;
            }
            else {
                output << "User inputted operation is invalid" << endl;
            }
        }
    }
    else if (shapeType == "CIRCLE") {
        
        //declaring and populating variable
        string sRadius;
        getline(input, sRadius);

        if (sRadius.empty()) {
            output << "Not enough information to calculate" << endl;
        }
        else {
            //converting string to integer
            int radius = stoi(sRadius);

            if (operation == "area") {
                output << "Area of the circle is " << (radius * radius) * 3.14159 << endl;
            }
            else if (operation == "perimeter") {
                output << "Perimeter of the circle is " << (radius * 2) * 3.14159 << endl;
            }
            else {
                output << "User inputted operation is invalid" << endl;
            }
        }
    }
    else if(shapeType == "TRIANGLE") {

        //declare triangle variables
        string sSideA;
        string sSideB;
        string sSideC;

        //populate triangle variables
        getline(input, sSideA);
        getline(input, sSideB);
        getline(input, sSideC);

        //check if enough information then perform user desired calculation
        if (sSideA.empty() || sSideB.empty() || sSideC.empty()) {
            output << "Not enough information to calculate" << endl;
        }
        else {
            //convert strings into integers for calculations
            int sideA = stoi(sSideA);
            int sideB = stoi(sSideB);
            int sideC = stoi(sSideC);

            if (operation == "area") {
                output << "Not enough information to calculate - need height of triangle" << endl;
            }
            else if (operation == "perimeter") {
                output << "Perimeter of the triangle is " << sideA + sideB + sideC << endl;
            }
            else {
                output << "User inputted operation is invalid" << endl;    
            }
        }
    }
    else {
        output << "Invalid shapetype inputted in input file" << endl;
    }

    input.close();
    output.close();
    return 0;
}
