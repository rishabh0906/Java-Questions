import java.util.*;

public class UnionFind {

    public static Scanner scn = new Scanner(System.in);
    private static int[] parent;
    int[] size;
    int[] rank;

    public static int find(int u) {

        if (parent[u] == u) {

            return u;
        }

        return parent[u] = find(parent[u]);
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

        int[] disconnectedNodes = new int[redundant.size()+1];
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

}
