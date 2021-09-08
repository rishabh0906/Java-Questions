
import java.util.*;

import javax.lang.model.util.ElementScanner14;

public class StringSet {

    public static void display(int[][] dp) {

        for (int[] a : dp) {
            for (int el : a)
                System.out.print(el + "  ");
            System.out.println();
        }
    }

    public static int LongestPSubs(String str, int l, int r, int[][] dp) {
        if (l > r)
            return dp[l][r] = 0;
        if (l == r)
            return dp[l][r] = 1;
        if (dp[l][r] != 0)
            return dp[l][r];

        char ch1 = str.charAt(l);
        char ch2 = str.charAt(r);
        if (ch1 == ch2) {

            return dp[l][r] = LongestPSubs(str, l + 1, r - 1, dp) + 2;

        }

        return dp[l][r] = Math.max(LongestPSubs(str, l, r - 1, dp), LongestPSubs(str, l + 1, r, dp));

    }

    public static int LongestPSubs_02(String str, int L, int R, int[][] dp) {

        int n = str.length();
        for (int gap = 0; gap < n; gap++) {

            for (int l = 0, r = gap; r < n; l++, r++) {

                if (l > r) {

                    dp[l][r] = 0;
                    continue;
                }
                if (l == r) {

                    dp[l][r] = 1;
                    continue;
                }

                char ch1 = str.charAt(l);
                char ch2 = str.charAt(r);
                if (ch1 == ch2) {

                    dp[l][r] = dp[l + 1][r - 1] + 2;
                    continue;

                }

                dp[l][r] = Math.max(dp[l][r - 1], dp[l + 1][r]);

            }
        }

        return dp[L][R];
    }

    public static void longestPalindromeSubseq() {
        String s = "rereredfdgder";
        int n = s.length();
        int[][] dp = new int[n][n];

        int ans = LongestPSubs(s, 0, n - 1, dp);
        System.out.println(ans);
        display(dp);

    }

    // Distinct Subsequence
    public static int countSubs(String s, String t, int n, int m, int[][] dp) {
        if (m == 0)
            return dp[n][m] = 1;
        if (n == 0)
            return dp[n][m] = 0;

        if (dp[n][m] != -1)
            return dp[n][m];

        char ch1 = s.charAt(n - 1);
        char ch2 = t.charAt(m - 1);

        int count = 0;
        if (ch1 == ch2) {
            count += countSubs(s, t, n - 1, m - 1, dp);
            count += countSubs(s, t, n - 1, m, dp);
        } else {
            count += countSubs(s, t, n - 1, m, dp);
        }

        return dp[n][m] = count;
    }

    public static int countSubs_02(String s, String t, int N, int M, int[][] dp) {

        for (int n = 0; n <= N; n++) {
            for (int m = 0; m <= M; m++) {
                if (m == 0) {

                    dp[n][m] = 1;
                    continue;
                }
                if (n < m) {

                    dp[n][m] = 0;
                    continue;
                }

                char ch1 = s.charAt(n - 1);
                char ch2 = t.charAt(m - 1);

                int count = 0;
                if (ch1 == ch2) {
                    count += dp[n - 1][m - 1];
                    count += dp[n - 1][m];
                } else {
                    count += dp[n - 1][m];
                }
            }
        }

        return dp[N][M];
    }

    public static int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int[] a : dp)
            Arrays.fill(a, -1);

        return countSubs(s, t, n, m, dp);

    }

    // Leetcode 72

    public static int EditDistance(String s, String t, int n, int m, int[][] dp) {

        if (n == 0 || m == 0)
            return dp[n][m] = (n == 0 ? m : n);

        if (dp[n][m] != -1)
            return dp[n][m];
        int insert = EditDistance(s, t, n, m - 1, dp);
        int delete = EditDistance(s, t, n - 1, m, dp);
        int replace = EditDistance(s, t, n - 1, m - 1, dp);

        if (s.charAt(n - 1) == t.charAt(m - 1))
            return dp[n][m] = replace;

        else
            return dp[n][m] = Math.min(Math.min(replace, delete), insert) + 1;

    }

    public static int EditDistance(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int[] a : dp)
            Arrays.fill(a, -1);

        return EditDistance(s, t, n, m, dp);
    }

    // Edit Distance Follow up

    public static int EditDistance_02(String s, String t, int n, int m, int costd, int costi, int costr, int[][] dp) {

        if (n == 0 || m == 0) {

            return dp[n][m] = (n == 0 ? m * costi : n * costd);
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        int insert = EditDistance_02(s, t, n, m - 1, costd, costi, costr, dp);
        int replace = EditDistance_02(s, t, n - 1, m - 1, costd, costi, costr, dp);
        int delete = EditDistance_02(s, t, n - 1, m, costd, costi, costr, dp);

        if (s.charAt(n - 1) == t.charAt(m - 1))
            return dp[n][m] = replace;
        else
            return dp[n][m] = Math.min(Math.min(insert + costi, delete + costd), replace + costr);
    }

    // Wildcard Matching

    public static String RemoveStar(String str) {

        if (str.length() == 0)
            return "";

        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));

        int i = 1;
        while (i < str.length()) {

            while (i < str.length() && sb.charAt(sb.length() - 1) == '*' && str.charAt(i) == '*')
                i++;

            if (i < str.length()) {
                sb.append(str.charAt(i));
            }
            i++;
        }

        return sb.toString();

    }

    public static int WildcardMatch(String s, String t, int n, int m, int[][] dp) {

        if (n == 0) {
            if (m == 0)
                return dp[n][m] = 1;
            else if (m > 1)
                return dp[n][m] = 0;
            else
                dp[n][m] = (t.charAt(m - 1) == '*' ? 1 : 0);
        } else if (m == 0) {

            return dp[n][m] = 0;
        }

        if (dp[n][m] != -1)
            return dp[n][m];

        int a = WildcardMatch(s, t, n - 1, m - 1, dp);
        int b = WildcardMatch(s, t, n - 1, m, dp);
        int c = WildcardMatch(s, t, n, m - 1, dp);

        if (s.charAt(n - 1) == t.charAt(m - 1) || t.charAt(m - 1) == '?') {

            return dp[n][m] = a;
        }

        else {

            if (t.charAt(m - 1) == '*') {

                return dp[n][m] = a | b | c;

            }

        }
        return dp[n][m] = 0;

    }

    public static boolean isMatch(String s, String t) {

        int n = s.length();
        t = RemoveStar(t);

        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int[] a : dp)
            Arrays.fill(a, -1);

        WildcardMatch(s, t, n, m, dp);

        return dp[n][m] == 0 ? false : true;
    }

    public static void main(String[] args) {

        longestPalindromeSubseq();

    }

}
