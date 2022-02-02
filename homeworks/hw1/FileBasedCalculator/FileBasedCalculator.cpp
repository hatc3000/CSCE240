/**
 * @file FileBasedCalculator.cpp
 * @author Ryan Capron
 * @brief 
 * @version 0.1
 * @date 2022-01-19
 * 
 * @copyright Copyright (c) 2022
 * 
 */

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main() {

    cout << "This is a simple C++ I/O program!\n";

    string operation = "";
    string filename = "input.txt";
    int result = 0;
    string xS;
    int x;
    string yS;
    int y;
    ifstream input (filename);

    if (!input) {
        cerr << "Unable to open file input.txt";
        exit(1);
    }
    getline(input, operation);
    getline(input, xS);
    x = stoi(xS);
    getline(input, yS);
    y = stoi(yS);

    input.close();

    // getline(input, operation);

    //     while (!input.eof()) {
    //         getline(input,operation);
    //         cout<<operation;
    //     }
    // }
    // input.close();
    // cout << "result = " << operation << endl; 

    /**
     * @brief 
     * Declaring of variables
     */
    // cout << "Type the operation - enter - first number - second number.\n";
    // cin >> operation;
    // cin >> x;
    // cin >> y;

    /**
     * @brief Construct a new if object
     * Calculator algorithm
     */
    if (operation == "add") {
        result = x + y;
        cout << result << "\n";
    }
    else if (operation == "subtract") {
        result = x - y;
        cout << result << "\n";
    }
    else if (operation == "divide") {
        result = x / y;
        cout << result << "\n";
    }
    else if (operation == "multiply") {
        result = x * y;
        cout << result << "\n";
    }        
    return 0;
}



/**
 * @brief 
 * reads three lines from input.txt
 * performs operation on first line
 * using first number and then second number
 */