/**
 * @file Rectangle.cpp
 * @author Ryan Capron
 * @date 2022-02-09
 * 
 */

#include "../headers/Rectangle.h"

Rectangle::Rectangle(int a, int b) {
    perimeter = (2 * a) + (2 * b);
    area = a * b;
}
