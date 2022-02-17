/**
 * @file Triangle.cpp
 * @author Ryan Capron
 * @date 2022-02-09
 * 
 */

#include "../headers/Triangle.h"

Triangle::Triangle() {
    area = 0;
    perimeter = 0;
}
Triangle::Triangle(int base, int height) {
    area = (base * height) / 2;
}
Triangle::Triangle(int a, int b, int c) {
    perimeter = a + b + c;
}