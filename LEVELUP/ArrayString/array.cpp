#include <bits/stdc++.h>

using namespace std;
int kadane(vector<int> &arr)
{

    int maxSum = (int)-1e9;

    int currSum = 0;

    for (int i = 0; i < arr.size(); i++)
    {

        currSum = max(currSum + arr[i], arr[i]);

        if (maxSum < currSum)
        {
            maxSum = currSum;
        }
    }

    return maxSum;
}
int maximumSumRectangle(int R, int C, vector<vector<int>> M)
{

    int maxSum = (int)-1e9;
    for (int i = 0; i < R; i++)
    {

        vector<int> consider(C);
        for (int j = i; j < R; j++)
        {

            for (int k = 0; k < C; k++)
            {
                consider[k] += M[j][k];
            }

            int tempSum = kadane(consider);

            maxSum = max(maxSum, tempSum);
        }
    }
    return maxSum;
}