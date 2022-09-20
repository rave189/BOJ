#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int total, length;
    cin >> total >> length;
    int compare = 0;
    for(int i=0; i<length; i++) {
        int price, count;
        cin >> price >> count;
        compare += price * count;
    }
    cout << (total == compare ? "Yes" : "No");
}