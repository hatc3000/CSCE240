/**
 * @file Gmail.cpp
 * @author Ryan Capron
 * @brief HW4 for CSCE 240
 * @date 2022-03-01 due
 */

#include "../headers/Gmail.h"
#include <iostream>
#include <regex>
#include <string>

using namespace std;

Gmail::Gmail(string email) {
    header = email;
}

void Gmail::getMIME() {
    string locHeader = header;
    regex regexp("MIME-Version: [0-9]*\.[0-9]*");
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
void Gmail::getSMTP() {
    string locHeader = header;
    regex regexp("Smtp-Source:.*");
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

