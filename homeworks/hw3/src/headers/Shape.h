/**
 * @file Shape.h
 * @author Ryan Capron
 * @brief Information in readMe
 * @version 0.1
 * @date 2022-02-09
 * 
 */

#ifndef SHAPE_H_
#define SHAPE_H_

#include <string>

using namespace std;

class Shape {
    protected: 
        int area;
        int perimeter;
        string errorMessage;

    public:
        Shape();
        int getArea();
        int getPerimeter();
        string getErrorMessage();
};

#endif