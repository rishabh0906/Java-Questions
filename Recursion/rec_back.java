import java.util.*;
//BackTracking
// mark
// dfs on unvisited
// unmark

public class rec_back {
    public static Scanner scn = new Scanner(System.in);

    public static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
            { -1, -1 } };
    public static String[] dirs = { "d", "t", "r", "l", "sw", "sw", "ne", "nw" };

    public static int floodFill(int sr, int sc, String ans, int[][] vis) {

        if (sr == vis.length - 1 && sc == vis[0].length - 1) {
            System.out.println(ans);
            return 1;
        }
        vis[sr][sc] = 1;
        int count = 0;
        for (int i = 0; i < dir.length; i++) {
            for (int rad = 1; rad <= Math.max(vis.length, vis[0].length); rad++) {
                int r = sr + rad * dir[i][0];
                int c = sc + rad * dir[i][1];
                if (r >= 0 && r < vis.length && c >= 0 && c < vis[0].length) {
                    if (vis[r][c] == 0) {

                        count += floodFill(r, c, ans + dirs[i] + rad, vis);

                    }
                } else {
                    break;
                }
            }
        }
        vis[sr][sc] = 0;

        return count;

    }

    public static int[] xMove = { 2, 1, -1, -2, -2, -1, 1, 2 };
    public static int[] yMove = { 1, 2, 2, 1, -1, -2, -2, -1 };

    public static boolean knightTour(int sr, int sc, int n, int[][] Sol, int movesi) {
        Sol[sr][sc] = movesi;
        if (movesi == n * n - 1) {
            return true;
        }

        boolean res = false;
        for (int i = 0; i < 8; i++) {
            int r = sr + xMove[i];
            int c = sc + yMove[i];
            if (r >= 0 && r < n && c >= 0 && c < n && Sol[r][c] == -1) {
                res = knightTour(r, c, n, Sol, movesi + 1);
                if (res) {
                    return res;
                }
            }
        }
        Sol[sr][sc] = -1;
        return res;
    }

    public static int longestPath(int sr, int sc, int n, String ans, int[][] maze, int[][] dir, String[] dirS) {
        if (sr == n - 1 && sc == n - 1) {
            System.out.println(ans);
            return 0;

        }

        maze[sr][sc] = 1;
        int count = -1;
        for (int i = 0; i < dir.length; i++) {
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if (r >= 0 && r < n && c >= 0 && c < n && maze[r][c] == 0) {
                count = Math.max(count, longestPath(r, c, n, ans + dirS[i], maze, dir, dirS));
            }
        }

        maze[sr][sc] = 0;

        return count == -1 ? count : count + 1;
    }

    public static int shortestPath(int sr, int sc, int n, String ans, int[][] maze, int[][] dir, String[] dirS) {
        if (sr == n - 1 && sc == n - 1) {
            return 0;
        }

        maze[sr][sc] = 1;
        int count = (int) 1e9;
        for (int i = 0; i < dir.length; i++) {
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if (r >= 0 && r < n && c >= 0 && c < n && maze[r][c] == 0) {
                count = Math.min(count, shortestPath(r, c, n, ans + dirS[i], maze, dir, dirS));
            }
        }

        maze[sr][sc] = 0;

        return count == (int) 1e9 ? count : count + 1;
    }

    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 1 }, { 0, 0, 1 }, { 0, 1, 0 } };
        // int [][] vis=new int[3][3];
        // System.out.println(floodFill(0,0,"",mat));

        int[][] dir = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
        String[] dirS = { "D", "R", "L", "U" };

        // System.out.println(longestPath(0,0,3,"",mat,dir,dirS));
        // System.out.println(shortestPath(0,0,3,"",mat,dir,dirS));

        // int [][]Sol=new int[8][8];
        // for(int i=0;i<8;i++)
        // {
        // for(int j=0;j<8;j++)
        // {
        // Sol[i][j]=-1;
        // }
        // }

        // knightTour(0,0,8,Sol,0);
        // for(int i=0;i<8;i++)
        // {
        // for(int j=0;j<8;j++)
        // {
        // System.out.print(Sol[i][j]+" ");
        // }
        // System.out.println();
        // }
    }
}