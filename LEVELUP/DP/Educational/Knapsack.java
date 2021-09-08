

public class Knapsack {

    public static long knapsack(int[] weight, int[] value, int W, int idx, long[][] dp) {

        if (idx == weight.length)
            return dp[idx][W] = 0;

        if (dp[idx][W] != 0)
            return dp[idx][W];

        long ans1 = knapsack(weight, value, W, idx + 1, dp);

        long ans2 = 0;
        if (W - weight[idx] >= 0) {
            ans2 = knapsack(weight, value, W - weight[idx], idx + 1, dp) + value[idx];
        }

        return dp[idx][W] = Math.max(ans1, ans2);

    }

    public static void main(String[] args) {
        int n = 6;
        int w = 15;

        int[] weight = { 6, 5, 6, 6, 3, 7 };
        int[] value = { 5, 6, 4, 6, 5, 2 };

        long[][] dp = new long[n + 1][w + 1];

      
        long ans = knapsack(weight, value, w, 0, dp);
        System.out.println(ans);

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                System.out.print(dp[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
