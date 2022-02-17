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

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] vis = new boolean[n][m];

        LinkedList<Integer> queue = new LinkedList<>();

        queue.addLast(start[0] * m + start[1]);
        vis[start[0]][start[1]] = true;

        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        while (queue.size() > 0) {

            int idx = queue.removeFirst();
            int i = idx / m;
            int j = idx % m;

            for (int[] dir : dirs) {

                int x = i + dir[0];
                int y = j + dir[1];

                while (x >= 0 && y >= 0 && x < n && y < m && maze[x][y] != 1) {
                    x += dir[0];
                    y += dir[1];
                }

                x -= dir[0];
                y -= dir[1];

                if (x == destination[0] && y == destination[1])
                    return true;
                if (vis[x][y])
                    continue;

                vis[x][y] = true;

                queue.addLast(x * m + y);
            }

        }

        return false;

    }

    public int hasPath_02(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        int[][] vis = new int[n][m];
        for (int[] e : vis) {

            Arrays.fill(e, (int) 1e9);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {

            return a[1] - b[1];
        });

        queue.add(new int[] { start[0] * m + start[1], 0 });
        vis[start[0]][start[1]] = 0;

        int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        while (queue.size() > 0) {

            int[] idx = queue.remove();
            int i = idx[0] / m;
            int j = idx[0] % m;

            for (int[] dir : dirs) {

                int x = i + dir[0];
                int y = j + dir[1];
                int curr = 1;
                while (x >= 0 && y >= 0 && x < n && y < m && maze[x][y] != 1) {
                    x += dir[0];
                    y += dir[1];
                    curr++;
                }

                x -= dir[0];
                y -= dir[1];
                curr--;

                if (idx[1] + curr < vis[x][y]) {
                    vis[x][y] = idx[1] + curr;
                    queue.add(new int[] { x * m + y, idx[1] + curr });
                }
            }

        }

        int ans = vis[destination[0]][destination[1]];

        return (ans == (int) 1e9 ? -1 : ans);

    }

}
