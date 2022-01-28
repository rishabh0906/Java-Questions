
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

}