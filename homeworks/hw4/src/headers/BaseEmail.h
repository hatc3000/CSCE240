/**
 * @file BaseEmail.h
 * @author Ryan Capron
 * @brief HW4 for CSCE 240
 * @date 2022-03-01
 */

#ifndef BASEEMAIL_H_
#define BASEEMAIL_H_

#include <string>

using namespace std;

class BaseEmail {
protected:
    string header;

public:
    BaseEmail();

    void setHeader(string),
        getFrom(), 
        getDate(),
        getTO(),
        getMessageID(),
        getCType(),
        getSubject(),
        getTEncoding(),
        getReceived();
};

#endif