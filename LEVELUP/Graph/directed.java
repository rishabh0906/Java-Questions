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
}