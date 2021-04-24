#include <bits/stdc++.h>
using namespace std;
int n;
int a[1555555];
int b[1555555];
void check(int l, int r)
{
    if (l == r)
        return;
    int n = 0;
    for (int i = l; i <= r; i += 2)
        b[++n] = a[i];
    for (int i = l + 1; i <= r; i += 2)
        b[++n] = a[i];
    for (int i = l; i <= r; i++)
    {
        a[i] = b[i - l + 1];
    }
    int mid = (l + r) >> 1;
    check(l, mid);
    check(mid + 1, r);
}
int main()
{
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        scanf("%d", &a[i]);
    }
    check(1, n);
    bool flag = false;
    for (int i = 1; i <= n; i++)
    {
        if (flag)
            printf(" ");
        flag = true;
        printf("%d", a[i]);
    }
    return 0;
}

