#include <iostream>
#include <set>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    set<string> s;
    string str;
    cin >> str;
    for (int i = 0; i < str.size(); ++i)
        for (int j = 1; j <= str.size(); ++j)
            s.insert(str.substr(i, j));
    cout << s.size();
}