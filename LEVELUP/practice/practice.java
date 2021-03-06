
import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class practice {

    public static Scanner scn = new Scanner(System.in);

    public static void solve() {

        int n, h;
        n = scn.nextInt();
        h = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();

        }

        Arrays.sort(arr);
        int max = arr[n - 1];
        int sec_max = arr[n - 2];

        long count = 2 * (h / (max + sec_max)) + (h % (max + sec_max) != 0 ? (h % (max + sec_max) <= max ? 1 : 2) : 0);

        System.out.println(count);
    }

    class DisjointUnionSet {

        public int[] par;
        public int[] size;

        public DisjointUnionSet(int n) {

            this.par = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                this.par[i] = i;
                this.size[i] = 1;
            }

        }

        public int find_set(int v) {

            if (par[v] == v)
                return v;
            return par[v] = find_set(par[v]);
        }

        public boolean union_set(int x, int y) {

            int xp = find_set(x);
            int yp = find_set(y);
            if (xp == yp)
                return false;

            if (size[xp] > size[yp]) {
                par[yp] = par[xp];
                size[xp] += size[yp];
            } else {
                par[xp] = par[yp];
                size[yp] += size[xp];
            }
            return true;
        }
    }

    public ArrayList<Integer> sieve() {

        boolean[] prime = new boolean[100000];
        ArrayList<Integer> pf = new ArrayList<>();
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;

        for (int i = 2; i * i < 100000; i++) {

            if (prime[i]) {
                pf.add(i);
                for (int p = 2 * i; p < 10000; p += i) {

                    prime[p] = false;
                }
            }
        }

        return pf;
    }

    public int largestComponentSize(int[] nums) {

        int n = nums.length;
        DisjointUnionSet dsu = new DisjointUnionSet(n);
        ArrayList<Integer> prime = sieve();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < prime.size() && prime.get(j) <= nums[i]; j++) {

                if (nums[i] % prime.get(j) == 0) {

                    if (!map.containsKey(prime.get(j))) {
                        map.put(prime.get(j), new ArrayList<>());
                    }
                    map.get(prime.get(j)).add(i);
                }
            }
        }

        for (int key : map.keySet()) {

            ArrayList<Integer> component = map.get(key);
            for (int i = 0; i < component.size() - 1; i++) {

                dsu.union_set(component.get(i), component.get(i + 1));
            }
        }

        int ans = 0;

        for (int i = 0; i < dsu.size.length; i++) {
            ans = Math.max(ans, dsu.size[i]);
        }

        return ans;

    }

    public static class Circle {

        public Circle(int radius) throws Exception {
            init(radius);
        }

        public static void MyException(int radius) throws Exception {
            if (radius <= 0) {
                throw new Exception("Radius Negative");
            }
        }

        public static void init(int radius) throws Exception {
            MyException(radius);
            // Further Code
        }

    }

    public static void main(String[] args) throws Exception {
        int r = scn.nextInt();
        Circle c = new Circle(r);

    }

    public int value(int[][] shops) {
        int n = shops.length;
        int[][] dp = new int[n][3];

        dp[0][0] = shops[0][0];
        dp[0][1] = shops[0][1];
        dp[0][2] = shops[0][2];

        for (int i = 1; i < n; i++) {

            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][2]) + shops[i][0];
            dp[i][1] = Math.max(dp[i - 1][2], dp[i - 1][0]) + shops[i][1];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][0]) + shops[i][2];
        }

        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }

}
