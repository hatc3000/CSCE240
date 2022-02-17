/**
 * @file Circle.cpp
 * @author Ryan Capron
 * @date 2022-02-09
 * 
 */

#include "../headers/Circle.h"

Circle::Circle(int radius) {
    perimeter = 3.14 * radius * 2;
    area = radius * radius * 3.14;
}