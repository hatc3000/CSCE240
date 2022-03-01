/**
 * @file BaseEmail.cpp
 * @author Ryan Capron
 * @brief HW4 for CSCE 240
 * @date 2022-03-01
 */

#include <iostream>
#include <regex>
#include <string>
#include "../headers/BaseEmail.h"

using namespace std;

BaseEmail::BaseEmail() {
    header = "empty";
}

void BaseEmail::setHeader(string filePath) {
    header = filePath;
}
void BaseEmail::getReceived() {
    string ret;
    string locHeader = header;
    regex regexp("Received: (by|from) .*");
    smatch flag;
    regex_search(locHeader, flag, regexp);

    while (regex_search (locHeader,flag,regexp)) {
        for (auto x:flag) {
            cout << x << " ";
        }
        cout << endl;
        locHeader = flag.suffix().str();
    }
}
void BaseEmail::getFrom() {
    string locHeader = header;
    regex regexp("From:.*");
    smatch flag;
    regex_search(locHeader, flag, regexp);

    while (regex_search (locHeader,flag,regexp)) {
        for (auto x:flag) {
            cout << x << " ";
        }
        cout << endl;
        locHeader = flag.suffix().str();
    }
}
void BaseEmail::getDate() {
    string locHeader = header;
    regex regexp("Date: .*");
    smatch flag;
    regex_search(locHeader, flag, regexp);

    while (regex_search (locHeader,flag,regexp)) {
        for (auto x:flag) {
            cout << x << " ";
        }
        cout << endl;
        locHeader = flag.suffix().str();
    }
}
void BaseEmail::getTO() {
    string locHeader = header;
    regex regexp("Date: .*");
    smatch flag;
    regex_search(locHeader, flag, regexp);

    while (regex_search (locHeader,flag,regexp)) {
        for (auto x:flag) {
            cout << x << " ";
        }
        cout << endl;
        locHeader = flag.suffix().str();
    } 
}
void BaseEmail::getMessageID() {
    string locHeader = header;
    regex regexp("Content-Type:.*");
    smatch flag;
    regex_search(locHeader, flag, regexp);

    while (regex_search (locHeader,flag,regexp)) {
        for (auto x:flag) {
            cout << x << " ";
        }
        cout << endl;
        locHeader = flag.suffix().str();
    }
}
void BaseEmail::getCType() {
    string locHeader = header;
    regex regexp("^To: .*");
    smatch flag;
    regex_search(locHeader, flag, regexp);

    while (regex_search (locHeader,flag,regexp)) {
        for (auto x:flag) {
            cout << x << " ";
        }
        cout << endl;
        locHeader = flag.suffix().str();
    }
}
void BaseEmail::getSubject() {
    string locHeader = header;
    regex regexp("Subject.*");
    smatch flag;
    regex_search(locHeader, flag, regexp);

    while (regex_search (locHeader,flag,regexp)) {
        for (auto x:flag) {
            cout << x << " ";
        }
        cout << endl;
        locHeader = flag.suffix().str();
    }
}
void BaseEmail::getTEncoding() {
    string locHeader = header;
    regex regexp("^To: .*");
    smatch flag;
    regex_search(locHeader, flag, regexp);

    while (regex_search (locHeader,flag,regexp)) {
        for (auto x:flag) {
            cout << x << " ";
        }
        cout << endl;
        locHeader = flag.suffix().str();
    }
}