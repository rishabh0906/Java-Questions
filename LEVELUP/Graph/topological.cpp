#include <bits/stdc++.h>
using namespace std;

int largestPathValue(string colors, vector<vector<int>> &edges)
{
    int n = colors.size();
    vector<int> node_to_color[n];
    vector<int> indegree(n);
    vector<int> adj[n];
    for (auto edge : edges)
    {

        adj[edge[0]].push_back(edge[1]);
        indegree[edge[1]];
    }

    for (int i = 0; i < n; i++)
    {
        node_to_color[i].assign(26, 0);
    }

    queue<int> q;

    for (int i = 0; i < n; i++)
    {
        if (indegree[i] == 0)
        {
            node_to_color[i][colors[i] - 'a']++;
            q.push(i);
        }
    }

    int node_count = 0;
    int ans = 0;
    while (q.size() > 0)
    {
        node_count++;
        int node = q.front();
        q.pop();

        for (int v : adj[node])
        {
            --indegree[v];

            if (indegree[v] == 0)
            {
                q.push(v);
            }
            int color_of_node = colors[v] - 'a';
            for (int color = 0; color < 26; color++)
            {
                node_to_color[v][color] = max(node_to_color[v][color], node_to_color[node][color] + (color == color_of_node));
            }
        }

        for (int i = 0; i < 26; i++)
        {
            ans = max(ans, node_to_color[node][i]);
        }
    }

    if (node_count != n)
        return -1;

    return ans;
}