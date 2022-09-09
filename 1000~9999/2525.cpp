#include <iostream>

using namespace std;

int main() {
    int hour, minute;
    int cookTime;
    cin >> hour >> minute;
    cin >> cookTime;
    minute += cookTime;
    if(minute >= 60) {
        hour += minute/ 60;
        minute = minute % 60;
        if(hour >= 24) {
            hour = hour % 24;
        }
    }
    cout << hour << " " << minute;
}