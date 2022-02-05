import java.util.*;

public class CutSet {

    public static void display(int[] dp) {
        for (int ele : dp) {
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public static void display2D(int[][] dp) {
        for (int[] d : dp) {
            display(d);
        }
        System.out.println();
    }

    public static int mcm_memo(int[] arr, int si, int ei, int[][] dp) {
        if (ei - si == 1) {
            return dp[si][ei] = 0;
        }

        if (dp[si][ei] != 0)
            return dp[si][ei];

        int minRes = (int) 1e9;
        for (int cut = si + 1; cut < ei; cut++) {
            int leftRes = mcm_memo(arr, si, cut, dp);
            int rightRes = mcm_memo(arr, cut, ei, dp);

            minRes = Math.min(minRes, leftRes + arr[si] * arr[cut] * arr[ei] + rightRes);
        }

        return dp[si][ei] = minRes;
    }

    public static int mcm_Dp(int[] arr, int SI, int EI, int[][] dp) {
        int n = arr.length;
        String[][] sdp = new String[n][n];

        for (int gap = 1; gap < n; gap++) {
            for (int si = 0, ei = gap; ei < n; si++, ei++) {
                if (ei - si == 1) {
                    dp[si][ei] = 0;
                    sdp[si][ei] = (char) (si + 'A') + "";
                    continue;
                }

                int minRes = (int) 1e9;
                String minStr = "";
                for (int cut = si + 1; cut < ei; cut++) {
                    int leftRes = dp[si][cut];// mcm_memo(arr, si, cut, dp);
                    int rightRes = dp[cut][ei];// mcm_memo(arr, cut, ei, dp);

                    if (leftRes + arr[si] * arr[cut] * arr[ei] + rightRes < minRes) {
                        minRes = leftRes + arr[si] * arr[cut] * arr[ei] + rightRes;
                        minStr = "(" + sdp[si][cut] + sdp[cut][ei] + ")";
                    }
                }

                dp[si][ei] = minRes;
                sdp[si][ei] = minStr;
            }

        }
        System.out.println(sdp[SI][EI]);
        return dp[SI][EI];
    }

    public static void mcm() {
        int[] arr = { 10, 30, 5, 60 };
        int n = arr.length;
        int[][] dp = new int[n][n];

        System.out.println(mcm_Dp(arr, 0, n - 1, dp));

        display2D(dp);
    }

    // Min Max =======================================================

    public static class pairmm {
        int min = (int) 1e9;
        int max = 0;

        pairmm() {

        }

        pairmm(int val) {
            this.min = this.max = val;
        }
    }

    public static pairmm evaluateMinMax(pairmm leftRes, pairmm rightRes, char operator) {
        pairmm pair = new pairmm();
        if (operator == '+') {
            pair.min = leftRes.min + rightRes.min;
            pair.max = leftRes.max + rightRes.max;
        } else if (operator == '*') {
            pair.min = leftRes.min * rightRes.min;
            pair.max = leftRes.max * rightRes.max;
        }
        return pair;
    }

    public static pairmm minMax(String str, int si, int ei, pairmm[][] dp) {
        if (si == ei) {
            return dp[si][ei] = new pairmm((str.charAt(si) - '0'));
        }

        if (dp[si][ei] != null)
            return dp[si][ei];

        pairmm myRes = new pairmm();
        for (int cut = si + 1; cut < ei; cut += 2) {
            pairmm leftRes = minMax(str, si, cut - 1, dp);
            pairmm rightRes = minMax(str, cut + 1, ei, dp);
            pairmm pair = evaluateMinMax(leftRes, rightRes, str.charAt(cut));

            myRes.min = Math.min(myRes.min, pair.min);
            myRes.max = Math.max(myRes.max, pair.max);
        }

        return dp[si][ei] = myRes;
    }

    public static void minMax() {
        String str = "1+2*3+4*5";
        int n = str.length();
        pairmm[][] dp = new pairmm[n][n];

        pairmm res = minMax(str, 0, n - 1, dp);

        System.out.println("Min value: " + res.min);
        System.out.println("Max value: " + res.max);
    }

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
        int sum = 0;
        for (int i = l; i <= r; i++) {

            int leftCost = OptimalBST(keys, freq, l, i - 1, dp);
            int rightCost = OptimalBST(keys, freq, i + 1, r, dp);
            sum += freq[i];
            myAns = Math.min(myAns, leftCost + rightCost);

        }

        return dp[l][r] = myAns + sum;
    }

    public static int OptimalBST(int[] keys, int[] freq) {

        int n = keys.length;
        int[][] dp = new int[n][n];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return OptimalBST(keys, freq, 0, n - 1, dp);
    }

    public static void main(String[] args) {
        int[] key = { 10, 12 };
        int[] freq = { 34, 50 };

        int ans = OptimalBST(key, freq);
        System.out.println(ans);
    }

   

}
