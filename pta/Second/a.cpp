#include <stdio.h>

#define MAXN 10
#define MAXS 1000

int need_time(const int time[], const int score[], int happy_score, int n);

int main()
{
    int n, i, happy_score;
    int time[MAXN], score[MAXN];
    scanf("%d %d", &n, &happy_score);
    for (i = 0; i < n; ++i)
        scanf("%d", &time[i]);
    for (i = 0; i < n; ++i)
        scanf("%d", &score[i]);
    printf("%d\n", need_time(time, score, happy_score, n));
    return 0;
}

/* Your function will be put here */
int max(int a, int b)
{
    return a > b ? a : b;
}
int need_time(const int time[], const int score[], int happy_score, int n)
{
    int i;
    int sum = 0;
    int sum_time = 0;
    int min_score = MAXS;
    for (i = 0; i < n; i++)
    {
        sum += score[i];
        sum_time += time[i];
        min_score = score[i] < min_score ? score[i] : min_score;
    }
    if (sum < happy_score)
        return -1; //所有题目都做也不能达到开心值

    int dp[sum - happy_score + 1][n + 1]; //dp[x][y]：在剩余x空间的背包放入前y件物品所能获得的最大价值

    for (int i = 0; i <= sum - happy_score; i++)
        for (int j = 0; j <= n; j++)
            dp[i][j] = 0;

    for (int j = min_score; j <= sum - happy_score; j++)
    {
        for (int i = 1; i <= n; i++)
        {
            if (j >= score[i - 1])
                //剩余背包空间足够放下第i件物品,则在放与不放中选择价值最大的情况
                dp[j][i] = max(dp[j][i - 1], time[i - 1] + dp[j - score[i - 1]][i - 1]);
            else
                //剩余背包空间不足放下第i件物品
                dp[j][i] = dp[j][i - 1];
        }
    }

    if (sum_time == dp[sum - happy_score][n])
        return -1;
    else
        return sum_time - dp[sum - happy_score][n];
}
