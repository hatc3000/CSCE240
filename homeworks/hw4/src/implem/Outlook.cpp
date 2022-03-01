/**
 * @file Outlook.cpp
 * @author Ryan Capron
 * @brief HW4 for CSCE 240
 * @date 2022-03-01 due
 */

#include <iostream>
#include <regex>
#include <string>
#include "../headers/Outlook.h"

Outlook::Outlook(std::string email) {
    header = email;
}

void Outlook::getAuthR() {
    string locHeader = header;
    regex regexp("Auth.*Results.*");
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
void Outlook::getCC() {
    string locHeader = header;
    regex regexp("CC:.*");
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
void Outlook::getTTopic() {
    string locHeader = header;
    regex regexp("Thread-Topic:.*");
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
void Outlook::getTIndex() {
    string locHeader = header;
    regex regexp("Thread-Index:.*");
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
void Outlook::getReferences() {
    string locHeader = header;
    regex regexp("References:.*");
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
void Outlook::getIRT() {
    string locHeader = header;
    regex regexp("In-Reply-To:.*");
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
void Outlook::getALanguage() {
    string locHeader = header;
    regex regexp("Accept-Langu.*");
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
void Outlook::getCLanguage() {
    string locHeader = header;
    regex regexp("Content-Langu.*");
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
void Outlook::getHasAttach() {
    string locHeader = header;
    regex regexp("Has-Attach:.*");
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
void Outlook::getSCL() {
    string locHeader = header;
    regex regexp("SCL:.*");
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