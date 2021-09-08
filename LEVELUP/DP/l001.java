import java.util.Arrays;;

public class l001 {

    public static void display(long[][] dp) {

        for (long[] a : dp) {

            for (long el : a)
                System.out.print(el + " ");
            System.out.println();
        }
    }

    public static void displayint(int[][] dp) {

        for (int[] a : dp) {

            for (int el : a)
                System.out.print(el + " ");
            System.out.println();
        }
    }

    public static void display2(long[] dp) {

        for (long el : dp)
            System.out.print(el + " ");
    }

    public static int mazePath_memo(int n, int m, int sr, int sc, int[][] dir, int[][] dp) {

        if (sr == n && sc == m) {
            return dp[sr][sc] = 1;
        }

        if (dp[sr][sc] != 0)
            return dp[sr][sc];
        int ans = 0;
        for (int i = 0; i < dir.length; i++) {

            int nextr = sr + dir[i][0];
            int nextc = sc + dir[i][1];

            if (nextr >= 0 && nextr <= n && nextc >= 0 && nextc <= m) {
                ans += mazePath_memo(n, m, nextr, nextc, dir, dp);

            }
        }

        return dp[sr][sc] = ans;

    }

    public static int mazePath_tab(int n, int m, int[][] dir, int[][] dp) {

        for (int i = n; i >= 0; i--) {
            for (int j = m; j >= 0; j--) {

                if (i == n || j == m) {
                    dp[i][j] = 1;
                    continue;
                }

                dp[i][j] = dp[i + 1][j] + dp[i + 1][j + 1] + dp[i][j + 1];
            }
        }

        return dp[0][0];

    }

    public static void mazePath() {

        int n = 3, m = 3;
        int[][] dp = new int[n][m];

        int[][] dir = { { 1, 0 }, { 1, 1 }, { 0, 1 } };
        System.out.println(mazePath_tab(n - 1, m - 1, dir, dp));
        displayint(dp);

    }

    public static int boardPathUsingDice(int n, int[] dp) {

        if (n == 0)
            return dp[n] = 1;

        if (dp[n] != 0)
            return dp[n];

        int count = 0;
        for (int i = 1; i <= 6 && n - i >= 0; i++) {

            count += boardPathUsingDice(n - i, dp);
        }

        return dp[n] = count;

    }

    public static void boardpath() {

        int n = 10;
        int[] dp = new int[n + 1];

        boardPathUsingDice(n, dp);

    }

    public int numDecode(String s, int idx, int[] dp) {

        for (int i = s.length(); i >= 0; i--) {

            if (i == s.length()) {
                dp[i] = 1;
                continue;
            }

            char ch1 = s.charAt(i);
            if (ch1 == '0') {

                dp[i] = 0;
                continue;
            }

            int count = 0;
            count += dp[i + 1];

            if (i < s.length() - 1) {

                char ch2 = s.charAt(i + 1);

                int num = (ch1 - '0') * 10 + (ch2 - '0');
                if (num <= 26) {
                    count += dp[i + 2];
                }
            }

            dp[i] = count;

        }
        return dp[0];
    }

    public int numDecode_opti(String s) {

        int prev = 1, prevprev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch1 = s.charAt(i);
            int count = 0;
            if (ch1 != '0') {
                count += prev;

                if (i < s.length() - 1) {

                    char ch2 = s.charAt(i + 1);

                    int num = (ch1 - '0') * 10 + (ch2 - '0');
                    if (num <= 26) {
                        count += prevprev;
                    }

                }
            }
            prevprev = prev;
            prev = count;

        }
        return prev;
    }

    public int numDecodings(String s) {

        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);

        int ans = numDecode(s, 0, dp);
        return ans;
    }

    /// Extend DecodeWays 2
    public long decodeWays(String s, int idx, int M, long[] dp) {

        if (idx == s.length())
            return dp[idx] = 1;

        if (dp[idx] != -1)
            return dp[idx];

        char ch = s.charAt(idx);
        if (ch == '0')
            return dp[idx] = 0;

        long count = 0;
        if (ch == '*') {
            count += 9 * decodeWays(s, idx + 1, M, dp) % M; // Ist *

            if (idx < s.length() - 1) {

                char ch2 = s.charAt(idx + 1);
                if (ch2 == '*') {
                    count += 15 * decodeWays(s, idx + 2, M, dp) % M; // Ist IInd */
                } else if (ch2 <= '6') {

                    count += 2 * decodeWays(s, idx + 2, M, dp) % M; // Ist * IInd char//
                } else if (ch2 > '6') {
                    count += decodeWays(s, idx + 2, M, dp) % M;
                }
            }

            return dp[idx] = count % M;
        }

        count += decodeWays(s, idx + 1, M, dp) % M;

        if (idx < s.length() - 1) {
            char ch2 = s.charAt(idx + 1);

            if (ch2 == '*') {

                if (ch == '1') {
                    count += 9 * decodeWays(s, idx + 2, M, dp) % M;
                } else if (ch == '2') {
                    count += 6 * decodeWays(s, idx + 2, M, dp) % M;
                }
            } else {
                int num = (ch - '0') * 10 + (ch2 - '0');

                if (num <= 26) {
                    count += decodeWays(s, idx + 2, M, dp) % M;
                }
            }
        }

        return dp[idx] = count % M;

    }

    // Optimized
    public long decodeWays_tab(String s, int IDX, int M, long[] dp) {

        long prev = 1;
        long prevprev = 0;
        for (int idx = s.length() - 1; idx >= 0; idx--) {

            char ch = s.charAt(idx);
            long count = 0;
            if (ch != '0') {
                if (ch == '*') {
                    count += 9 * prev % M; // Ist *

                    if (idx < s.length() - 1) {

                        char ch2 = s.charAt(idx + 1);
                        if (ch2 == '*') {
                            count += 15 * prevprev % M; // Ist IInd */
                        } else if (ch2 <= '6') {

                            count += 2 * prevprev % M; // Ist * IInd char//
                        } else if (ch2 > '6') {
                            count += prevprev % M;
                        }
                    }

                } else {

                    count += prev % M;

                    if (idx < s.length() - 1) {
                        char ch2 = s.charAt(idx + 1);

                        if (ch2 == '*') {

                            if (ch == '1') {
                                count += 9 * prevprev % M;
                            } else if (ch == '2') {
                                count += 6 * prevprev % M;
                            }
                        } else {
                            int num = (ch - '0') * 10 + (ch2 - '0');

                            if (num <= 26) {
                                count += prevprev % M;
                            }
                        }
                    }
                }
            }
            prevprev = prev;
            prev = count;

        }
        return prev;

    }

    public int numDecodings_extend(String s) {

        long[] dp = new long[s.length() + 1];
        Arrays.fill(dp, -1);
        int M = (int) 1e9 + 7;
        int idx = 0;
        int ans = (int) decodeWays(s, idx, M, dp);

        return ans;
    }

    // Goldmine
    // Min Cost Path
    public static long friendPair(int n, long[] dp, int mod) {

        if (n == 0)
            return dp[n] = 1;

        if (dp[n] != -1)
            return dp[n];
        long single = friendPair(n - 1, dp, mod);
        long pair = n - 2 >= 0 ? friendPair(n - 2, dp, mod) * (n - 1) : 0;

        return dp[n] = (single + pair % mod) % mod;

    }

    public static long friendPair2(int n, long[] dp, int mod) {

        long a = 1, b = 1;

        for (int i = 2; i <= n; i++) {

            long sum = a + b * (i - 1) % mod;
            a = b;
            b = sum % mod;
        }

        return b;
    }

    public static void countFriendsPairings() {
        int n = 5;
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        int mod = (int) 1e9 + 7;
        long ans = friendPair(n, dp, mod);

        System.out.println(ans);
        display2(dp);
    }

    // Divide N in k Groups

    public static long DivideInKgroups(int n, int k, long[][] dp, int mod) {
        if (k == 1 || n == k)
            return dp[n][k] = 1;

        if (dp[n][k] != -1)
            return dp[n][k];

        long self = DivideInKgroups(n - 1, k - 1, dp, mod);
        long partOfGroup = DivideInKgroups(n - 1, k, dp, mod) * k;

        return dp[n][k] = (self + partOfGroup) % mod;

    }

    public static long DivideInKgroups_02(int n, int k, long[][] dp, int mod) {

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= k; j++) {
              
                if (i == j || j == 1) {
                    dp[i][j] = 1;
                    continue;
                }

                long self = dp[i - 1][j - 1];
                long partOfGroup = dp[i - 1][j] * j;

                dp[i][j] = (self + partOfGroup) % mod;
            }

        }

        return dp[n][k];

    }

    public static void Divide() {

        int n = 5, k = 3;
        long[][] dp = new long[n + 1][k + 1];
        for (long[] a : dp) {
            Arrays.fill(a, -1);
        }
        int mod = (int) 1e9 + 7;
        DivideInKgroups(n, k, dp, mod);
        display(dp);
    }

    // 516,1143,72

    
    public static void main(String[] args) {
        Divide();
    }

}