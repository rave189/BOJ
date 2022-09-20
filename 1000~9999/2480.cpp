#include <iostream>

using namespace std;

int max2(int a, int b) {
    return a > b ? a : b;
}

int max(int a, int b, int c) {
    return max2(max2(a, b), c);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int a, b, c;
    cin >> a >> b >> c;
    int result;
    if (a == b && b == c)
        result = a * 1000 + 10000;
    else if (a == b || a == c)
        result = a * 100 + 1000;
    else if (b == c)
        result = b * 100 + 1000;
    else
        result = max(a, b, c) * 100;
    cout << result;
}