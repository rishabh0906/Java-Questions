#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int minSwaps(vector<int> &nums)
{
    int n = nums.size();
    int ones = accumulate(nums.begin(), nums.end(), 0);
    vector<int> vec(2 * n);

    for (int i = 0; i < 2 * n; i++)
    {
        vec[i] = nums[i % n];
    }

    int i = 0;
    int j = 0;
    int res = INT_MAX;
    for (int i = 0, count = 0; i < n; i++)
    {

        while (j - i < ones)
        {
            count += nums[j];
            j++;
        }
        res = min(res, ones - count);
        count -= nums[i];
    }

    return res;
}
int main(int argc, char const *argv[])
{

    vector<int> nums = {1, 0, 1, 0, 1, 1, 0};
    cout << minSwaps(nums) << endl;

    return 0;
}
