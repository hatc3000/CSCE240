/**
 * @file Outlook.h
 * @author Ryan Capron
 * @brief HW4 for CSCE 240
 * @date 2022-03-01
 */

#ifndef OUTLOOK_H_
#define OUTLOOK_H_

#include "BaseEmail.h"
#include <string>

using namespace::std;

class Outlook: public BaseEmail {
public:
    Outlook(string);

    void getAuthR(),
        getCC(),
        getTTopic(),
        getTIndex(),
        getReferences(),
        getIRT(),
        getALanguage(),
        getCLanguage(),
        getHasAttach(),
        getSCL();
};


#endif