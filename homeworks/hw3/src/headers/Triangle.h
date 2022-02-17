/**
 * @file Triangle.h
 * @author Ryan Capron
 * @date 2022-02-09
 */

#ifndef TRIANGLE_H_
#define TRIANGLE_H_

#include "Shape.h"

class Triangle: public Shape {
    public:
        Triangle();
        Triangle(int base, int height);
        Triangle(int a, int b, int c);
};

#endif