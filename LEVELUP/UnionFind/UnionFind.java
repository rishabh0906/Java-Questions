import java.util.*;

public class UnionFind {

    public static Scanner scn = new Scanner(System.in);
    private static int[] parent;
    private static int[] size;
    int[] rank;

    public static int find(int u) {

        if (parent[u] == u) {

            return u;
        }

        return parent[u] = find(parent[u]);
    }

    public static void merge(int u, int v) {

        int p1 = find(u);
        int p2 = find(v);
        if (p1 == p2)
            return;
        if (size[p1] >= size[p2]) {
            parent[p2] = p1;
            size[p1] += size[p2];
        } else {
            parent[p1] = p2;
            size[p2] += size[p2];
        }
    }

    public static void main(String[] args) {

        int n = scn.nextInt();

        ArrayList<Integer[]> redundant = new ArrayList<>();
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++)
            parent[i] = i;
        for (int i = 0; i < n - 1; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();

            int p1 = find(u);
            int p2 = find(v);

            if (p1 != p2) {
                parent[p2] = p1;
                continue;
            }

            redundant.add(new Integer[] { u, v });

        }

        int[] disconnectedNodes = new int[redundant.size() + 1];
        int indx = 0;
        for (int i = 1; i <= n; i++) {
            int p = find(i);

            if (p == i) {
                disconnectedNodes[indx++] = p;
            }
        }

        System.out.println(redundant.size());

        for (int i = 0; i < redundant.size(); i++) {
            System.out.println(redundant.get(i)[0] + " " + redundant.get(i)[1] + " " + disconnectedNodes[i] + " "
                    + disconnectedNodes[i + 1]);
        }

    }

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        parent = new int[n];
        size =new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1) {

                    merge(i, j);
                }
            }
        }

        int[] freq = new int[n];
        Arrays.sort(initial);
        for (int i = 0; i < initial.length; i++) {
            freq[find(initial[i])]++;
        }

        int ans = initial[0];

        int mx = 0;

        for (int i = 0; i < initial.length; i++) {
            int p = find(initial[i]);

            if (freq[p] > 1)
                continue;

            if (size[p] > mx) {
                mx = size[p];
                ans = initial[i];
            }
        }

        return ans;
    }

}
