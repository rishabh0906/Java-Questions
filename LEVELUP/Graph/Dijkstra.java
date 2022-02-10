import java.util.*;
import java.util.PriorityQueue;

class Dijkstra {

    public class Edge {

        Integer v;
        Integer w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    public class Pair {
        Integer u;
        Integer p;
        Integer w;
        Integer wsf;

        Pair(int u, int p, int w, int wsf) {
            this.u = u;
            this.p = p;
            this.w = w;
            this.wsf = wsf;
        }

    }

    public void addEdge(int u, int v, int w, ArrayList<Edge> graph[]) {

        graph[u].add(new Edge(v, w));
        graph[v].add(new Edge(u, w));
    }

    public void Dijkstra_(ArrayList<Edge> graph[]) {
        int V = graph.length;
        ArrayList<Edge>[] myGraph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            myGraph[i] = new ArrayList<>();
        }
        int[] dis = new int[V];
        Arrays.fill(dis, (int) 1e9);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {

            return a.wsf - b.wsf;
        });

        pq.add(new Pair(0, -1, 0, 0));

        while (pq.size() > 0) {

            Pair t = pq.remove();

            if (dis[t.u] != (int) 1e9)
                continue;

            dis[t.u] = t.wsf;
            if (t.p != -1) {

                addEdge(t.u, t.p, t.w, myGraph);
            }

            for (Edge e : graph[t.u]) {

                if (dis[e.v] != (int) 1e9) {
                    pq.add(new Pair(e.v, t.u, e.w, t.wsf + e.w));
                }
            }
        }

    }

    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<Integer[]> adj[] = new ArrayList[n];
        for (int[] e : times) {

            adj[e[0]].add(new Integer[] { e[1], e[2] });
        }

        int[] dis = new int[n];
        Arrays.fill(dis, (int) 1e9);
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> {

            return a[1] - b[1];
        });

        pq.add(new Integer[] { k, 0 });

        while (pq.size() > 0) {

            Integer[] t = pq.remove();

            if (dis[t[0]] != (int) 1e9)
                continue;

            dis[t[0]] = t[1];

            for (Integer[] e : adj[t[0]]) {

                if (dis[e[0]] != (int) 1e9) {
                    pq.add(new Integer[] { e[0], t[1] + e[1] });
                }
            }
        }

        int max = 0;

        for (int ele : dis) {
            max = Math.max(max, ele);
        }

        return max == (int) 1e9 ? -1 : max;

    }

    public static void BellmanFord(int[][] graph, int V, int src) {

        int[] distance = new int[V];

        boolean NegativeCycle = false;
        Arrays.fill(distance, (int) 1e9);
        for (int i = 1; i <= V; i++) {
            int[] currDistance = new int[V];
            for (int j = 0; j < V; i++) {
                currDistance[j] = distance[j];
            }
            boolean update = false;
            for (int[] e : graph) {
                int u = e[0];
                int v = e[1];
                int w = e[2];
                if (distance[u] + w < currDistance[v]) {
                    currDistance[v] = distance[u] + w;
                    update = true;
                }
            }

            if (update == false)
                break;

            if (i == V && update) {
                NegativeCycle = true;
            }

            distance = currDistance;

        }

    }

}