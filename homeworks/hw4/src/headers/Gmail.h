/**
 * @file Gmail.h
 * @author Ryan Capron
 * @brief HW4 for CSCE 240
 * @date 2022-03-01
 */

#ifndef GMAIL_H_
#define GMAIL_H_

#include "BaseEmail.h"
#include <string>

using namespace std;

class Gmail: public BaseEmail {
public:
    Gmail(string);

    void getSMTP(),
        getMIME();

};

#endif