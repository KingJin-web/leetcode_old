//[7 - 2 乘法表(10 分)](d.cpp)
#include <iostream>
#include <bits/stdc++.h>
using namespace std;
const int maxn = 50;
int result[maxn][maxn][3] = {0};
class Solution
{
public:
    void aaa( string str)
    {
        int n = str.size();
        //int result[n+1][n+1][3];

        for (int i = 1; i <= n; ++i) //相当于是求边界的值
        //毕竟动态规划是从低向上的  所以先算边界
        {
            if (str[i - 1] == 'a')
                result[i][i][0] = 1;
            else
                result[i][i][0] = 0;
            if (str[i - 1] == 'b')
                result[i][i][1] = 1;
            else
                result[i][i][1] = 0;
            if (str[i - 1] == 'c')
                result[i][i][2] = 1;
            else
                result[i][i][2] = 0;
        }

        for (int r = 2; r <= n; ++r)             //区间长度
            for (int i = 1; i <= n - r + 1; ++i) //区间起始
            {
                int j = i + r - 1;
                for (int k = i; k < j; k++) //k表示分割的位置
                {                           //根据题目中的表，计算加括号法
                    result[i][j][0] += result[i][k][0] * result[k + 1][j][2] + result[i][k][1] * result[k + 1][j][2] + result[i][k][2] * result[k + 1][j][0];
                    result[i][j][1] += result[i][k][0] * result[k + 1][j][0] + result[i][k][0] * result[k + 1][j][1] + result[i][k][1] * result[k + 1][j][1];
                    result[i][j][2] += result[i][k][1] * result[k + 1][j][0] + result[i][k][2] * result[k + 1][j][1] + result[i][k][2] * result[k + 1][j][2];
                }
            }

        cout << result[1][n][0] << endl;
        
    }
};

int main()
{
    //multiplication table

    Solution *s = new Solution();
    string str;
    cin >> str;
    s->aaa(str);
    return 0;
}