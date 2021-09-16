import java.util.*;

public class TargetSet {

    public static void display(int[] dp) {

        for (int ele : dp) {
            System.out.print(ele + " ");
        }
    }

    public static void display2D(int[][] dp) {

        for (int[] a : dp) {
            for (int e : a) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    public static int Permutation(int[] arr, int target, int[] dp) {
        if (target == 0)
            return dp[target] = 1;

        if (dp[target] != -1)
            return dp[target];
        int count = 0;
        for (int ele : arr) {
            if (target - ele >= 0)
                count += Permutation(arr, target - ele, dp);
        }

        return dp[target] = count;

    }

    // Each Target ke liye each element traverse ho rha h
    public static int Permutation_dp(int[] arr, int target, int[] dp) {

        dp[0] = 1;

        for (int i = 1; i <= target; i++) {

            int count = 0;
            for (int ele : arr) {
                if (i - ele >= 0)
                    count += dp[i - ele];
            }
            dp[i] = count;
        }

        return dp[target];

    }

    public static int Combination(int[] arr, int target, int n, int[][] dp) {

        if (target == 0)
            return dp[n][target] = 1;

        if (dp[n][target] != -1)
            return dp[n][target];
        int count = 0;
        for (int i = n; i > 0; i--) {

            if (target - arr[i - 1] >= 0) {
                count += Combination(arr, target - arr[i - 1], i, dp);
            }
        }

        return dp[n][target] = count;

    }

    // Each element ke liye each target traverse ho rha h O(n) solution
    public static int Combination_dp(int[] arr, int target, int[] dp) {

        dp[0] = 1;

        for (int ele : arr) {

            for (int i = ele; i <= target; i++) {
                if (i - ele >= 0)
                    dp[i] += dp[i - ele];
            }

        }

        return dp[target];

    }

    static int isSubsetSumHelper(int n, int[] arr, int sum, int[][] dp) {

        if (sum == 0) {

            return dp[n][sum] = 1;
        }
        if (n == 0) {
            return dp[n][sum] = 0;
        }

        if (dp[n][sum] != -1)
            return dp[n][sum];
        int ans=0;
        if (sum - arr[n - 1] >= 0) {

            ans = isSubsetSumHelper(n - 1, arr, sum - arr[n - 1], dp);
        }
        if (ans == 1) {

            return dp[n][sum] = 1;
        }
        ans = isSubsetSumHelper(n - 1, arr, sum, dp);

      

        return dp[n][sum] = ans;
    }

    /// Subset Sum Tabulation
    static boolean isSubsetSumHelper_tab(int N, int[] arr, int SUM, boolean[][] dp) {

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= SUM; j++) {

                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = false;
                    continue;
                }

                boolean ans = dp[i - 1][j];

                if (j - arr[i - 1] >= 0) {

                    ans = ans || dp[i - 1][j - arr[i - 1]];
                }

                dp[i][j] = ans;

            }
        }

        return dp[N][SUM];

    }

    static Boolean isSubsetSum(int N, int arr[], int sum) {

        int[][] dp = new int[N + 1][sum + 1];

        for (int[] a : dp)
            Arrays.fill(a, -1);

        int ans = isSubsetSumHelper(N, arr, sum, dp);
        display2D(dp);
        return ans == 1 ? true : false;
    }

    static int knapSack(int W, int[] wt, int[] val, int n, int[][] dp) {

        if (n == 0) {

            return dp[n][W] = 0;
        }

        if (dp[n][W] != -1)
            return dp[n][W];

        int ans = knapSack(W, wt, val, n - 1, dp);

        if (W - wt[n - 1] >= 0) {

            ans = Math.max(ans, knapSack(W - wt[n - 1], wt, val, n - 1, dp) + val[n - 1]);
        }

        return dp[n][W] = ans;
    }

    static int knapSack_dp(int W, int[] wt, int[] val, int N, int[][] dp) {

        for (int n = 0; n <= N; n++) {

            for (int w = 0; w <= W; w++) {
                if (n == 0) {

                    dp[n][w] = 0;
                    continue;
                }

                int ans = dp[n - 1][w];

                if (w - wt[n - 1] >= 0) {

                    ans = Math.max(ans, dp[n - 1][w - wt[n - 1]] + val[n - 1]);
                }

                dp[n][w] = ans;
            }
        }

        return dp[N][W];

    }

    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int[] a : dp)
            Arrays.fill(a, -1);

        return knapSack(W, wt, val, n, dp);
    }

    public static void main(String[] args) {

        int[] arr = { 2, 3, 5, 7 };

        int target = 10;
        // int n = arr.length;
        // int[][] dp = new int[n + 1][target + 1];

        // for (int[] a : dp)
        // Arrays.fill(a, -1);

        // System.out.println(Combination(arr, target, arr.length, dp));
        // display2D(dp);

        // int[] dp2 = new int[target + 1];

        // System.out.println(Combination_dp(arr, target, dp2));
        // display(dp2);
        isSubsetSum(arr.length, arr, target);

    }

}
