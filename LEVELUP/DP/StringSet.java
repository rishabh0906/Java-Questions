
import java.util.*;
import java.util.List;

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

    // Longest Pallindromic Substring
    public static void LongestPallindromicSubstring(String str) {
        int n = str.length();
        boolean[][] dp = new boolean[n][n];

        int countSubstring = 0;
        int MaxLenSubstring = 0;
        String res = "";
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0, j = gap; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;

                } else if (gap == 1 && str.charAt(i) == str.charAt(j)) {
                    dp[i][j] = true;

                } else if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;

                }

                if (dp[i][j] == true) {
                    countSubstring++;
                    if (MaxLenSubstring < j - i + 1) {
                        MaxLenSubstring = j - i + 1;
                        res = str.substring(i, j + 1);
                    }
                }
            }
        }
        System.out.println(countSubstring + " " + MaxLenSubstring + " " + res);

    }

    public static int LongestCommonSubstring(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n][m];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return ans;

    }

    // Leetcode 139

    public static boolean WordBreak(String str, List<String> wordDict) {

        HashSet<String> st = new HashSet<>();

        int maxLen = 0;
        for (String e : wordDict) {
            st.add(e);
            maxLen = Math.max(e.length(), maxLen);
        }

        boolean[] dp = new boolean[str.length() + 1];

        dp[0] = true;
        for (int i = 0; i <= str.length(); i++) {
            if (!dp[i])
                continue;

            for (int l = 1; l <= maxLen && l + i <= str.length(); l++) {

                String s = str.substring(i, i + l);

                if (st.contains(s)) {
                    dp[i + l] = true;
                }
            }
        }

        return dp[str.length()];
    }

    public static void GoldMine_reverseEngg(int[][] dp, int sr, int sc, int[][] dir, String asf) {

        if (sc == 0) {
            System.out.println("(" + sr + ", " + sc + ") " + asf);
            return;
        }
        int idx = -1;
        int MaxGold = 0;
        for (int i = 0; i < dir.length; i++) {

            int r = sr + dir[i][0];
            int c = sc + dir[i][1];

            if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length && dp[r][c] > MaxGold) {
                MaxGold = dp[r][c];
                idx = i;
            }

        }

        if (idx != -1) {

            int r = sr + dir[idx][0];
            int c = sc + dir[idx][1];

            GoldMine_reverseEngg(dp, r, c, dir, "(" + sr + ", " + sc + ") " + asf);
        }

    }

    public static int maxGold(int n, int m, int M[][]) {
        for (int i = 1; i < m; i++) {

            for (int j = 0; j < n; j++) {

                int GoldSoFar = M[j][i - 1];

                if (j > 0 && M[j - 1][i - 1] > GoldSoFar) {
                    GoldSoFar = M[j - 1][i - 1];
                }
                if (j < n - 1 && M[j + 1][i - 1] > GoldSoFar) {
                    GoldSoFar = M[j + 1][i - 1];
                }

                M[j][i] += GoldSoFar;
            }
        }
        /*
         * 1 5 8 2 3 12 0 8 12 12
         * 
         */

        int res = 0;
        int idx = -1;
        for (int i = 0; i < n; i++) {

            if (M[i][m - 1] > res) {
                res = M[i][m - 1];
                idx = i;
            }
        }
        int[][] dir = { { 0, -1 }, { -1, -1 }, { 1, -1 } };
        GoldMine_reverseEngg(M, idx, m - 1, dir, "");

        return res;

    }

    public static String lpss_backEng(String str, int si, int ei, int[][] dp) {
        if (si >= ei) {
            return si == ei ? str.charAt(si) + "" : "";
        }

        if (str.charAt(si) == str.charAt(ei)) {
            return str.charAt(si) + lpss_backEng(str, si + 1, ei - 1, dp) + str.charAt(ei);
        } else if (dp[si + 1][ei] > dp[si][ei - 1]) {
            return lpss_backEng(str, si + 1, ei, dp);
        } else {
            return lpss_backEng(str, si, ei - 1, dp);
        }
    }

    public void wordBreak_backEngg(String s, int idx, boolean[] dp, int maxLen, List<String> wordDict,
            HashSet<String> set, String ssf, List<String> ans) {
        if (idx >= s.length()) {
            ans.add(ssf.substring(0, ssf.length() - 1));
            return;
        }

        for (int l = 1; l <= maxLen && idx + l <= s.length(); l++) {
            if (dp[idx + l]) {
                String substr = s.substring(idx, idx + l);
                if (set.contains(substr)) {
                    wordBreak_backEngg(s, idx + l, dp, maxLen, wordDict, set, ssf + substr + " ", ans);
                }
            }
        }
    }

    public static void main(String[] args) {

        longestPalindromeSubseq();

    }

}
