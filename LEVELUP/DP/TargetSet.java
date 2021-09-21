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

    public static void display2D(boolean[][] dp) {

        for (boolean[] a : dp) {
            for (boolean e : a) {
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

    //////////////////////////////////// Subset Sum////////////////////
    static int isSubsetSumHelper(int n, int[] arr, int sum, int[][] dp) {

        if (sum == 0) {

            return dp[n][sum] = 1;
        }
        if (n == 0) {
            return dp[n][sum] = 0;
        }

        if (dp[n][sum] != -1)
            return dp[n][sum];
        int ans = 0;
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

    /// Reverse Engg for finding all solutions
    public static int isSubsetSum_backEngg(int n, int[] arr, int sum, boolean[][] dp, String ans) {

        if (sum == 0) {
            System.out.println(ans);
            return 1;
        }

        if (n == 0) {

            return 0;
        }

        int count = 0;
        if (dp[n - 1][sum])
            count += isSubsetSum_backEngg(n - 1, arr, sum, dp, ans);

        if (sum - arr[n - 1] >= 0 && dp[n - 1][sum - arr[n - 1]]) {
            count += isSubsetSum_backEngg(n - 1, arr, sum - arr[n - 1], dp, arr[n - 1] + " " + ans);
        }

        return count;
    }

    public static Boolean isSubsetSum(int N, int arr[], int sum) {

        int[][] dp = new int[N + 1][sum + 1];

        for (int[] a : dp)
            Arrays.fill(a, -1);

        int ans = isSubsetSumHelper(N, arr, sum, dp);
        display2D(dp);

        return ans == 1 ? true : false;
    }

    public static int isSubsetSum_tab(int N, int[] arr, int sum) {
        boolean[][] dp = new boolean[N + 1][sum + 1];

        isSubsetSumHelper_tab(N, arr, sum, dp);
        return isSubsetSum_backEngg(N, arr, sum, dp, "");

        // display2D(dp);
        // return ans;
    }

    //////////////////////////////// KnapSack...................................

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

    static int knapSack_with_duplicates(int n, int w, int val[], int wt[], int[][] dp) {

        if (n == 0 || w == 0) {

            return dp[n][w] = 0;
        }

        if (dp[n][w] != -1)
            return dp[n][w];

        int count = knapSack_with_duplicates(n - 1, w, val, wt, dp);

        if (w - wt[n - 1] >= 0) {

            count = Math.max(count, knapSack_with_duplicates(n, w - wt[n - 1], val, wt, dp) + val[n - 1]);
        }

        return dp[n][w] = count;
    }

    static int knapSack_with_duplicates(int N, int W, int val[], int wt[]) {
        int[][] dp = new int[N + 1][W + 1];

        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return knapSack_with_duplicates(N, W, val, wt, dp);
    }

    /// find Number of Solutions of a Linear equation using Coeff in Coeff. Array
    public static int NumberOfSolutions(int[] Coeff, int index, int rhs, int[][] dp) {

        if (rhs == 0) {
            return dp[index][rhs] = 1;
        }

        if (index == 0)
            return dp[index][rhs] = 0;

        if (dp[index][rhs] != -1) {
            return dp[index][rhs];
        }

        int count = 0;

        count += NumberOfSolutions(Coeff, index - 1, rhs, dp);
        if (rhs - Coeff[index - 1] >= 0)
            count += NumberOfSolutions(Coeff, index, rhs - Coeff[index - 1], dp);

        return dp[index][rhs] = count;
    }

    public static int NumberOfSolutions(int[] Coeff, int rhs) {

        int[][] dp = new int[Coeff.length + 1][rhs + 1];

        for (int[] a : dp)
            Arrays.fill(a, -1);

        int ans = NumberOfSolutions(Coeff, Coeff.length, rhs, dp);
        display2D(dp);
        return ans;

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
        System.out.println(isSubsetSum_tab(arr.length, arr, target));
        // System.out.println(NumberOfSolutions(arr, target));

    }

}
