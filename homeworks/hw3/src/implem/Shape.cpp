/**
 * @author Ryan Capron
 * 
 */

#include <string>
#include "../headers/Shape.h"


Shape::Shape() {
    area = 0;
    perimeter = 0;
    errorMessage = "Oh geez, We got an error here";
}

int Shape::getArea() {
    return area;
}
int Shape::getPerimeter() {
    return perimeter;
}
string Shape::getErrorMessage() {
    return errorMessage;
}
