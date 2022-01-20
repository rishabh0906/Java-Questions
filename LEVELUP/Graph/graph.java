import java.util.*;

public class graph {

    public static class Edge {

        Integer v;
        Integer w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public int AllPath(ArrayList<Edge>[] adj, int src, int des, int[] vis) {

        if (src == des)
            return 1;

        vis[src] = 1;
        int count = 0;
        for (Edge e : adj[src]) {

            if (vis[e.v] == 0) {
                count += AllPath(adj, e.v, des, vis);
            }
        }

        vis[src] = 0;

        return count;

    }

    public boolean hasPath(ArrayList<Edge>[] graph, int src, int des, int[] vis) {

        if (src == des)
            return true;

        vis[src] = 1;
        boolean res = false;
        for (Edge e : graph[src]) {

            if (vis[e.v] == 0) {

                res = res || hasPath(graph, e.v, des, vis);
            }
        }

        vis[src] = 0;

        return res;

    }

    public static class Pair {

        int wsf = -1;
        String psf;

        public Pair(int w, String p) {
            this.wsf = w;
            this.psf = p;
        }

    }

    public Pair MaxWeigthPath(ArrayList<Edge>[] graph, int src, int des, boolean[] vis) {

        if (src == des)
            return new Pair(0, "" + src);
        vis[src] = true;

        Pair My_ans = new Pair((int) -1, "");
        for (Edge e : graph[src]) {

            if (vis[e.v])
                continue;

            Pair rec_Ans = MaxWeigthPath(graph, e.v, des, vis);

            if (rec_Ans.wsf != -1 && rec_Ans.wsf + e.w > My_ans.wsf) {
                My_ans.wsf = rec_Ans.wsf + e.w;
                My_ans.psf = src + " " + rec_Ans.psf;
            }
        }

        vis[src] = false;

        return My_ans;

    }

    public Pair MinWeigthPath(ArrayList<Edge>[] graph, int src, int des, boolean[] vis) {

        if (src == des)
            return new Pair(0, "" + src);
        vis[src] = true;

        Pair My_ans = new Pair((int) 1e9, "");
        for (Edge e : graph[src]) {

            if (vis[e.v])
                continue;

            Pair rec_Ans = MinWeigthPath(graph, e.v, des, vis);

            if (rec_Ans.wsf != (int) 1e9 && rec_Ans.wsf + e.w < My_ans.wsf) {
                My_ans.wsf = rec_Ans.wsf + e.w;
                My_ans.psf = src + " " + rec_Ans.psf;
            }
        }

        vis[src] = false;

        return My_ans;

    }

    public static void main(String[] args) {

    }

}