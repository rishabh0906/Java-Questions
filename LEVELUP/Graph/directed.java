
import java.util.*;

public class directed {

    public static class Edge {

        Integer v;
        Integer w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public void dfs(ArrayList<Edge> graph[], boolean[] vis, int src, ArrayList<Integer> order) {

        vis[src] = true;

        for (Edge e : graph[src]) {

            if (!vis[e.v]) {
                dfs(graph, vis, e.v, order);
            }
        }

        order.add(src);

    }

    public void TopologicalOrder(ArrayList<Edge> graph[]) {

        int V = graph.length;
        ArrayList<Integer> order = new ArrayList<>();
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {

            if (!vis[i]) {
                dfs(graph, vis, i, order);
            }
        }

        for (int i = order.size(); i >= 0; i--) {
            System.out.println(order.get(i));
        }

    }

    // Topological Sort using BFS (Kahn's Algorithm)
    public void TopologicalOrder_02(ArrayList<Edge> graph[]) {

        int V = graph.length;
        int[] indegree = new int[V];
        ArrayList<Integer> order = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (Edge e : graph[i]) {
                indegree[e.v]++;
            }
        }

        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0)
                q.addLast(i);
        }

        while (q.size() > 0) {

            int top = q.removeFirst();

            order.add(top);

            for (Edge e : graph[top]) {

                indegree[e.v]--;
                if (indegree[e.v] == 0) {
                    q.addLast(e.v);
                }
            }
        }

    }

    public int longestIncreasingPath(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] indegree = new int[n][m];
        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                for (int[] dir : dirs) {

                    int x = i + dir[0];
                    int y = j + dir[1];

                    if (x >= 0 && y >= 0 && x < n && y < m && matrix[x][y] > matrix[i][j]) {
                        indegree[x][y]++;
                    }

                }

            }
        }

        LinkedList<Integer[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (indegree[i][j] == 0) {
                    q.addLast(new Integer[] { i, j });
                }
            }
        }

        int level = 0;
        while (q.size() > 0) {

            int size = q.size();

            while (size-- > 0) {
                Integer[] top = q.removeFirst();
                for (int[] dir : dirs) {

                    int x = top[0] + dir[0];
                    int y = top[1] + dir[1];

                    if (x >= 0 && y >= 0 && x < n && y < m && matrix[x][y] > matrix[top[0]][top[1]]) {
                        indegree[x][y]--;
                        if (indegree[x][y] == 0) {
                            q.addLast(new Integer[] { x, y });
                        }
                    }
                }
            }

            level++;
        }

        return level;

    }

    public int GetCycleLength(boolean[] vis, int[] favorite, int node) {

        int count = 0;
        while (!vis[node]) {
            count++;
            vis[node] = true;
            node = favorite[node];
        }

        return count;
    }

    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        ArrayList<Integer>[] adj = new ArrayList[n];
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < favorite.length; i++) {
            adj[i].add(favorite[i]);
            indegree[favorite[i]]++;
        }

        int[] LongestAcyclicChain = new int[n];
        boolean[] vis = new boolean[n];
        LinkedList<Integer[]> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.addLast(new Integer[] { i, 0 });
                vis[i] = true;
            }
        }
        int nodeCount = 0;
        while (queue.size() > 0) {
            Integer[] top = queue.removeFirst();

            nodeCount++;
            for (int v : adj[top[0]]) {

                indegree[v]--;
                if (indegree[v] == 0) {
                    vis[v] = true;
                    queue.addLast(new Integer[] { v, top[1] + 1 });
                }
                LongestAcyclicChain[v] = Math.max(LongestAcyclicChain[v], top[1] + 1);
            }
        }

        if (nodeCount == n) // 1. whole acyclic chain will be my ans
            return nodeCount; // 2. A cycle length > 2 will be my ans
                              // 3. sum of cycle length ==2 will be my ans
        int ans = 0;

        ArrayList<Integer> TwoLengthCycle = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int len = GetCycleLength(vis, favorite, i);
                if (len > 2) {
                    ans = Math.max(ans, len);

                } else if (len == 2) {

                    TwoLengthCycle.add(i);
                }
            }
        }
        int ansForCycleLength2 = 0;
        for (int node : TwoLengthCycle) {
            ansForCycleLength2 += LongestAcyclicChain[node] + LongestAcyclicChain[favorite[node]] + 2;
        }

        return Math.max(ans, ansForCycleLength2);

    }

    public int CountSemester(ArrayList<Integer>[] adj, int[] indegree, int k, int n) {

        int required = 0;
        int Candidate = 0;

        for (int i = 0; i < indegree.length; i++) {

            if (indegree[i] == 0) {
                required++;
                Candidate |= (1 << i);
            }
        }

        if (required <= k) {
            for (int i = 0; i < n; i++) {

                if (((1 << i) & Candidate) != 0) {
                    for (int e : adj[i]) {

                        indegree[e]--;
                    }
                }
            }
        } else {

        }

    }

    public int minNumberOfSemesters(int n, int[][] relations, int k) {

        int[] indegree = new int[n];
        ArrayList<Integer> adj[] = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] edge : relations) {
            edge[0]--;
            edge[1]--;
            adj[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }

        int mask = (1 << (n)) - 1;

        return CountSemester(adj, indegree, k, n);

    }

    public void Kosaraju(ArrayList<Edge>[] graph, int V) {

    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        ArrayList<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            u--;
            v--;
            adj[u].add(v);
            adj[v].add(u);
        }
        boolean[] vis = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        int[] nodes = new int[n];
        int level = 0;
        boolean isGood = false;
        queue.addLast(0);
        vis[0] = true;
        while (queue.size() > 0) {

            int size = queue.size();

            while (size-- > 0) {

                int top = queue.removeFirst();
                nodes[level]++;

                if (level == t && top == target) {
                    isGood = true;
                }

                for (int v : adj[top]) {
                    if (!vis[v]) {
                        vis[v] = true;
                        queue.addLast(v);

                    }
                }

            }

            level++;

        }
        for (int i = 0; i <= t; i++) {
            System.out.println(nodes[i]);
        }
        return 0.0;

    }

}