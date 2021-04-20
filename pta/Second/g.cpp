#include <iostream>
#include <bits/stdc++.h>
using namespace std;
const int N = 55;
const int MOD = 1000000007;
int dp[N][N][15][15];
int w[N][N];
int n, m, k;
class Solution
{
public:
    int collectArtifacts()
    {
        dp[1][1][0][0] = 1;
        dp[1][1][1][w[1][1]] = 1;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                for (int cnt = 0; cnt <= k; cnt++)
                    for (int v = 0; v <= 13; v++)
                    {
                        dp[i][j][cnt][v] = (dp[i][j][cnt][v] + dp[i - 1][j][cnt][v]) % MOD;
                        dp[i][j][cnt][v] = (dp[i][j][cnt][v] + dp[i][j - 1][cnt][v]) % MOD;
                        if (cnt > 0 && w[i][j] == v)
                        {
                            for (int s = 0; s < v; s++)
                            {
                                dp[i][j][cnt][v] = (dp[i][j][cnt][v] + dp[i - 1][j][cnt - 1][s]) % MOD;
                                dp[i][j][cnt][v] = (dp[i][j][cnt][v] + dp[i][j - 1][cnt - 1][s]) % MOD;
                            }
                        }
                    }

        int res = 0;
        for (int i = 0; i <= 13; i++)
        {
            res = (res + dp[n][m][k][i]) % MOD;
        }

        cout << res << endl;
    }
};



int main()
{
    cin >> n >> m >> k;
    for (int i = 1; i <= n; i++)
        for (int j = 1; j <= m; j++)
        {
            cin >> w[i][j];
            w[i][j]++;
        }

    Solution *s = new Solution();
    s->collectArtifacts();
    return 0;
}