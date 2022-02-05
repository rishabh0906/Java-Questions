#include <bits/stdc++.h>

using namespace std;

long long findCombinations(string &num, int start, int length, int mod)
{

    long long res = 0LL;
    for (int end = start + length; end < num.length(); end++)
    {
    }
}

int numberOfCombinations(string num)
{
    int mod = (int)1e9 + 7;
    findCombinations(num, 0, 0, mod);
}

int findMinimumDifference(vector<int> &nums, int idx, int count, int sum, int TotalSum)
{
    if (count == nums.size() / 2)
    {
        return abs(TotalSum - 2 * sum);
    }

    if (idx >= nums.size())
    {
        return (int)1e9;
    }

    int ans1 = findMinimumDifference(nums, idx + 1, count, sum, TotalSum);

    int ans2 = findMinimumDifference(nums, idx + 1, count + 1, sum + nums[idx], TotalSum);

    return min({ans1, ans2});
}

int minimumDifference(vector<int> &nums)
{

    int n = nums.size();

    int mask = (1 << (n / 2)) - 1;
    int TotalSum = accumulate(nums.begin(), nums.end(), 0);
    int ans = findMinimumDifference(nums, 0, 0, 0, TotalSum);
}

int main(int argc, char const *argv[])
{

    return 0;
}
