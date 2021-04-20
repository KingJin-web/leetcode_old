
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
class Solution
{
public:
    int longestCommonSubsequence(string text1, int m, string text2, int n)
    {
        //int m = text1.length(), n = text2.length();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1));
        for (int i = 1; i <= m; i++)
        {
            char c1 = text1.at(i - 1);
            for (int j = 1; j <= n; j++)
            {
                char c2 = text2.at(j - 1);
                if (c1 == c2)
                {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else
                {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
};
int longestCommonSubsequence(string text1, string text2)
{
    int len1 = text1.length();
    int len2 = text2.length();
    vector<vector<int>> dp(len1 + 1, vector<int>(len2 + 1, 0));
    for (int i = 1; i < len1 + 1; i++)
    {
        for (int j = 1; j < len2 + 1; j++)
        {
            if (text1[i - 1] == text2[j - 1])
                dp[i][j] = dp[i - 1][j - 1] + 1;
            else
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
        }
    }
    return dp[len1][len2];
}
int main(int argc, char const *argv[])
{
    Solution *s = new Solution();
    int n, m;
    string str1, str2;
    cin >> n >> m;
    cin >> str1 >> str2;

    int l = s->longestCommonSubsequence(str1, n, str2, m);
    cout << l;

    return 0;
}
