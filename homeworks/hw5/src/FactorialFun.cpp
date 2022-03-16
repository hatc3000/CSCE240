/**
 * @file FactorialFun.cpp
 * @author Ryan Capron
 * @date 2022-03-16
 */

//allows for user to input operation type and integers
#include <iostream>

//is used for messages and operation type
#include <string>

//is used to measure operation length
#include <chrono>

using namespace std;

//Recrusive method to calculate recursion
long factorial(int n) {
    if (n == 0) {
        return 1;
    }
    return n * factorial(n - 1);
}
//method to calculate combination also calling recursive method
long combination(int n, int r) {
    return (factorial(n)/(factorial(r)*factorial(n-r)));
}

int main() {
    /**
     * factType allows us to tell the operation type
     * a is equivalent to n in combination and/or default number in factorials
     * b is equivalent to r in combination operations
     */
    string factType;
    int a;
    int b;

    // taking in operation type from user
    cout << "Would you like to do a combination or factorial?" << endl;
    cin >> factType;

    // taking in integer a from user
    cout << "please enter the first number followed by enter" << endl;
    cin >> a;

    // if branch choosing combination mathematics 
    if (factType == "combination") {
        // Taking in second integer from user
        cout << "please enter the second number followed by enter" << endl;
        cin >> b;

        // Calculating combination and time taken for operation
        auto start = chrono::steady_clock::now();
        long result = combination(a,b);
        auto end = chrono::steady_clock::now();
        chrono::duration<double> duration = end - start;
        
        // Return to user combination answer and duration (seconds)
        cout << "The combination of " << a << " and " << b << " is " << result << endl;
        cout << "The operation took " << duration.count() << "seconds" << endl;

        return 0;
    }
    
    // Calculating factorial and time taken for operation
    auto start = chrono::steady_clock::now();
    long answer = factorial(a);
    auto end = chrono::steady_clock::now();
    chrono::duration<double> duration = end - start;

    // Return to user factorial answer and duration (seconds)
    cout << "The factorial of " << a << " is " << answer << endl;
    cout << "The operation took " << duration.count() << "seconds" << endl;

    return 0;
}

