/**
 * @file OOGeometricPropertyCalculator.cpp
 * @author Ryan Capron
 * @date 2022-02-09
 * 
 */

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

#include "./headers/Circle.h"
#include "./headers/Rectangle.h"
#include "./headers/Triangle.h"
#include "./headers/Shape.h"

int main() {
    
    //declare file names and User desired operation
    string inputFile = "../data/input.txt";
    string outputFile = "../data/output.txt";
    string operation;
    string shapeType;

    //take in user operation
    cout << "Enter \"1\" for area or \"2\" for perimeter" << endl;
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

            Rectangle rectangle(length, breadth);    

            if(operation == "1") {
            output << "area of the rectangle is " << rectangle.getArea() << endl;
            }
            else if (operation == "2") {
                output << "Perimeter of the rectangle is " << rectangle.getPerimeter() << endl;
            }
            else {
                output << rectangle.getErrorMessage() << endl;
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
            Circle circle(radius);

            if (operation == "1") {
                output << "Area of the circle is " << circle.getArea() << endl;
            }
            else if (operation == "2") {
                output << "Perimeter of the circle is " << circle.getPerimeter() << endl;
            }
            else {
                output << "Circle.getErrorMessage" << endl;
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
        if (sSideA.empty() || sSideB.empty()) {
            output << "Not enough information to calculate" << endl;
        }
        else {
            //convert strings into integers for calculations
            int sideA = stoi(sSideA);
            int sideB = stoi(sSideB);
            int sideC = stoi(sSideC);

            Triangle triangle;

            if (sSideC.empty()) {
                triangle = Triangle(sideA, sideB);
            }
            else {
                int sideC = stoi(sSideC);
                triangle = Triangle(sideA, sideB, sideC);
            }

            if (operation == "1") {
                output << "Area of the triangle is " << triangle.getArea() << endl;
            }
            else if (operation == "2") {
                output << "Perimeter of the triangle is " << triangle.getPerimeter() << endl;
            }
            else {
                output << "triangle.getErrorMessage()" << endl;    
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

