#include <iostream>
#include <cstdio>

using namespace std;
const int Max = 206;
int f1[Max][Max];
int f2[Max][Max];
int a[Max];
int sum[Max];
int cost[Max][Max];
int main()
{
    int n;
    cin >> n;
    for (register int i = 1; i <= n; ++i)
        cin >> a[i], a[i + n] = a[i];
    for (register int i = 1; i <= n * 2; ++i)
        sum[i] = sum[i - 1] + a[i];
    for (register int i = 1; i <= n * 2; ++i)
        for (register int j = i; j <= n * 2; ++j)
            cost[i][j] = sum[j] - sum[i - 1];
    for (register int len = 1; len <= n; ++len)
    {
        for (register int i = 1; i + len - 1 <= n * 2; ++i)
        {
            int j = i + len - 1;
            if (i != j)
                f2[i][j] = 999999999;
            for (register int k = i; k < j; ++k)
                f1[i][j] = max(f1[i][j], f1[i][k] + f1[k + 1][j] + cost[i][j]),
                f2[i][j] = min(f2[i][j], f2[i][k] + f2[k + 1][j] + cost[i][j]);
        }
    }
    int M = 0;
    int MM = 0x7fffffff;
    for (register int i = 1; i <= n; ++i)
        M = max(M, f1[i][i + n - 1]),
        MM = min(MM, f2[i][i + n - 1]);
    cout << MM << endl
         << M << endl;
    return 0;
}