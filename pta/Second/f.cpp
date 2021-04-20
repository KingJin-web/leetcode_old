//7 - 4 Split(20 分)
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
int main(int argc, char const *argv[])
{
    int n;
    cin >> n;
    int arr[n];
    int arr2[n];
    for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
    }

    double a = n;
    for (int i = 1; i <= n; i *= 2)
    {
        /* code */
        int c = n / 2;
        for (int i = 0; i < n; i++)
        {
            if (i % 2 == 0)
            {
                arr2[i / 2] = arr[i];
            }
            else
            {
                arr2[c] = arr[i];
                c++;
            }
        }
        for (int i = 0; i < n; ++i)
        {
            arr[i] = arr2[i];
        }
        for (int i = 0; i < n; ++i)
        {
            cout << arr[i];
        }
        cout << endl;
        a = a / 2;
    }

    for (int i = 0; i < n; ++i)
    {
        cout << arr[i] << endl;
    }
    return 0;
}
