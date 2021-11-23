#include <iostream>
#include <bits/stdc++.h>

using namespace std;

int visiblePoints(vector<vector<int>> &points, int angle, vector<int> &location)
{

    int locx = location[0];
    int locy = location[1];
    vector<double> angles;
    int co_points = 0;

    for (auto point : points)
    {

        if (locx == point[0] && locy == point[1])
        {
            co_points++;
            continue;
        }

        double ang = calcAngle(locx, locy, point[0], point[1]);
        angles.push_back(ang);
    }

    sort(begin(angles), end(angles));
    int ans = 0;
    for (int i = 0; i < angles.size(); i++)
    {

        double start = angles[i];
        double end = angles[i] + (double)angle * 1.0;
        int num = findPoints(angles, start, min(end, 360.0));

        if (end >= 360.0)
        {

            num += findPoints(angles, 0, end - 360);
        }
        ans = max(ans, num);
    }

    return ans + co_points;
}

int findPoints(vector<double> &angles, double lower, double upper)
{

    auto start = lower_bound(angles.begin(), angles.end(), lower);
    auto end = upper_bound(angles.begin(), angles.end(), upper + 1e-5);

    return distance(start, end);
}

double calcAngle(int x1, int y1, int x2, int y2)
{

    double slope = (double)(y1 - y2) / ((x1 - x2) * 1.0);

    double angle = (atan(slope) * 180) / M_PI;

    if (angle < 0)
    {

        angle += 360;
    }

    return angle;
}

int main(int argc, char const *argv[])
{

    return 0;
}
