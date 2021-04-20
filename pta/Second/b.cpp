#include <stdio.h>
#include <iostream>
#include <string.h>
#define MAXN 20

using namespace std;
int dp[MAXN * MAXN / 2][MAXN * MAXN / 2];
int split(int n);

int main()
{
    int n;
    cin >> n;
    cout << split(n);
    return 0;
}

/* 请在这里填写答案 */
int f(int i, int sum);
int split(int n)
{
    int sum, i, k;
    sum = n * (n + 1) / 4;
    // for (k = 0; k <= sum; k++)
    // {
    //     dp[0][k] = k ;
    // }
   
    // cout<<endl;
    // for (i = 0; i <= n; i++)
    // {
    //     for (k = 0; k <= sum; k++)
    //     {
    //         if (i > k)
    //         {
    //             dp[i][k] = dp[i - 1][k];
    //         }
    //         else
    //         {
    //             dp[i][k] = dp[i - 1][k] + dp[i - 1][k - i];
    //         }
    //     }
    // }
    return f(n,sum)/ 2;
}

int f(int i,int sum){
    
    if (i == 0)
    {
        if (sum == 0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
    else
    {
        if (i > sum)
        {
            return f(i - 1,sum);
        }else
        {
            return f(i - 1, sum) + f(i - 1, sum - i);
        }
        
        
    }
    
}