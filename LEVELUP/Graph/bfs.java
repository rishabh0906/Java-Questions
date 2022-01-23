import java.util.*;

public class bfs {

    public static class Edge {

        Integer v;
        Integer w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    // Cycle Detection
    public void bfs_1(ArrayList<Edge>[] graph, int src) {
        LinkedList<Integer> q = new LinkedList<>();
        int n = graph.length;
        boolean[] vis = new boolean[n];

        q.addLast(src);
        boolean isCycle = false;
        while (q.size() > 0) {

            int node = q.removeFirst();

            if (vis[node]) {
                isCycle = true;
                continue;
            }

            vis[node] = true;

            for (Edge e : graph[node]) {
                if (!vis[e.v])
                    q.addLast(e.v);
            }

        }
    }

    // No Cycle Detection
    public void bfs_2(ArrayList<Edge>[] graph, int src) {
        LinkedList<Integer> q = new LinkedList<>();
        int n = graph.length;
        boolean[] vis = new boolean[n];

        q.addLast(src);
        vis[src] = true;

        while (q.size() > 0) {

            int node = q.removeFirst();

            for (Edge e : graph[node]) {
                if (!vis[e.v]) {
                    vis[e.v] = true;
                    q.addLast(e.v);
                }
            }

        }
    }

    public int orangesRotting(int[][] grid) {

        LinkedList<Integer[]> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 2) {
                    grid[i][j] = -1;
                    q.addLast(new Integer[] { i, j });
                }
            }
        }

        int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        int ans = 0;
        int level = 0;
        while (q.size() > 0) {
            int size = q.size();
            ans = level;
            while (size-- > 0) {
                Integer[] rotten = q.removeFirst();

                for (int i = 0; i < dir.length; i++) {
                    int r = rotten[0] + dir[i][0];
                    int c = rotten[1] + dir[i][1];

                    if (r > 0 && r < grid.length && c > 0 && c < grid[0].length
                            && grid[r][c] == 1) {

                        grid[r][c] = -1;
                        q.addLast(new Integer[] { r, c });

                    }
                }
            }

            level++;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return ans;
    }
}
