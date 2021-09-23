import java.util.*;

public class CutSet {

    public int maxCoins(int[] nums, int si, int ei, int[][] dp) {

        if (si > ei) {
            return 0;
        }

        if (dp[si][ei] != -1)
            return dp[si][ei];
        int leftEle = (si > 0 ? nums[si - 1] : 1);
        int rightEle = (ei < nums.length - 1 ? nums[ei + 1] : 1);

        int ans = 0;
        for (int i = si; i <= ei; i++) {

            int left = maxCoins(nums, si, i - 1, dp);
            int right = maxCoins(nums, i + 1, ei, dp);

            ans = Math.max(ans, left + right + nums[i] * leftEle * rightEle);
        }

        return dp[si][ei] = ans;
    }

    public int maxCoins(int[] nums) {

        int[][] dp = new int[nums.length][nums.length];
        for (int[] a : dp)
            Arrays.fill(a, -1);

        return maxCoins(nums, 0, nums.length - 1, dp);

    }

    // Boolean
    // Parenthesisation-------------------------------------------------------------
    static class Pair {

        long TotalTrue = 0;
        long TotalFalse = 0;

        Pair(long TT, long TF) {
            this.TotalTrue = TT;
            this.TotalFalse = TF;
        }
    }

    static Pair evaluateOR(Pair left, Pair right, int mod) {

        long True = 0;
        long False = 0;
        True = ((left.TotalFalse * right.TotalTrue) % mod + (left.TotalTrue * right.TotalFalse) % mod
                + (left.TotalTrue * right.TotalTrue) % mod) % mod;
        False = (left.TotalFalse * right.TotalFalse) % mod;

        return new Pair(True, False);
    }

    static Pair evaluateAND(Pair left, Pair right, int mod) {

        long True = 0;
        long False = 0;
        False = ((left.TotalFalse * right.TotalTrue) % mod + (left.TotalTrue * right.TotalFalse) % mod
                + (left.TotalFalse * right.TotalFalse) % mod) % mod;
        True = (left.TotalTrue * right.TotalTrue) % mod;

        return new Pair(True, False);
    }

    static Pair evaluateXOR(Pair left, Pair right, int mod) {

        long True = 0;
        long False = 0;
        True = ((left.TotalFalse * right.TotalTrue) % mod + (left.TotalTrue * right.TotalFalse) % mod) % mod;
        False = ((left.TotalFalse * right.TotalFalse) % mod + (left.TotalTrue * right.TotalTrue) % mod) % mod;

        return new Pair(True, False);
    }

    static Pair CountWays(String str, int start, int end, int mod, Pair[][] dp) {

        if (start > end) {

            return new Pair(0, 0);
        }
        if (start == end) {

            if (str.charAt(start) == 'T') {
                return dp[start][end] = new Pair(1, 0);
            }

            return dp[start][end] = new Pair(0, 1);
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        long TotalTrue = 0;
        long TotalFalse = 0;
        for (int i = start; i <= end; i++) {
            if (str.charAt(i) == 'T' || str.charAt(i) == 'F')
                continue;

            Pair left = CountWays(str, start, i - 1, mod, dp);
            Pair right = CountWays(str, i + 1, end, mod, dp);
            Pair ans;
            if (str.charAt(i) == '|') {
                ans = evaluateOR(left, right, mod);
            } else if (str.charAt(i) == '&') {
                ans = evaluateAND(left, right, mod);
            } else {
                ans = evaluateXOR(left, right, mod);
            }

            TotalTrue = (TotalTrue + ans.TotalTrue) % mod;
            TotalFalse = (TotalFalse + ans.TotalFalse) % mod;

        }

        return dp[start][end] = new Pair(TotalTrue, TotalFalse);
    }

    static int countWays(int N, String S) {
        Pair[][] dp = new Pair[N][N];

        int mod = (int) 1003;

        return (int) CountWays(S, 0, N - 1, mod, dp).TotalTrue;
    }
    // Optimal Binary Search Trees

    public static int OptimalBST(int[] keys, int[] freq, int l, int r, int[][] dp) {

        if (l > r) {
            return 0;
        }
        if (l == r) {

            return freq[l];
        }

        if (dp[l][r] != -1)
            return dp[l][r];
        int myAns = (int) 1e9;
        int sum=0;
        for (int i = l; i <= r; i++) {

            int leftCost = OptimalBST(keys, freq, l, i - 1, dp);
            int rightCost = OptimalBST(keys, freq, i + 1, r, dp);
            sum+=freq[i];
            myAns = Math.min(myAns, leftCost + rightCost);

        }


        return dp[l][r] = myAns+sum;
    }

    public static int OptimalBST(int[] keys, int[] freq) {

        int n = keys.length;
        int[][] dp = new int[n][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return OptimalBST(keys, freq, 0, n - 1,  dp);
    }

    public static void main(String[] args) {
        int[] key = { 10, 12 };
        int[] freq = { 34, 50 };

        int ans = OptimalBST(key, freq);
        System.out.println(ans);
    }

}
