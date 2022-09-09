#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int n, k;
    cin >> n >> k;
    int arr[n];
    for(int i=0; i<n; i++)
        cin >> arr[i];
    sort(arr, arr + n, greater<>());
    cout << arr[k-1];
}