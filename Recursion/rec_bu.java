import java.util.*;

public class rec_bu {

    public static Scanner scn = new Scanner(System.in);

    public static int subs(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        count += subs(str.substring(1), ans);
        count += subs(str.substring(1), ans + str.charAt(0));
        return count;
    }

    public static int Subsequenece(String str, String ans, int index) {

        if (index == str.length()) {

            System.out.println(ans);
            return 1;
        }

        int count = 0;

        count += Subsequenece(str, ans + str.charAt(index), index + 1); // include
        count += Subsequenece(str, ans, index + 1); // exclude

        return count;
    }

    public static String[] map = { ".;", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz", "+-*", "<>/" };

    public static int keypad(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        char ch = str.charAt(0);
        String word = map[ch - '0'];
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            count += keypad(str.substring(1), ans + word.charAt(i));
        }
        return count;
    }

    public static int mazePath(int sr, int sc, int dr, int dc, String ans) {
        if (sr == dr && sc == dc) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        if (sc + 1 <= dc) {
            count += mazePath(sr, sc + 1, dr, dc, ans + "h");
        }
        if (sr + 1 <= dr) {
            count += mazePath(sr + 1, sc, dr, dc, ans + "v");
        }
        if (sr + 1 <= dr && sc + 1 <= dc) {
        count += mazePath(sr + 1, sc + 1, dr, dc, ans + "d");
        }
        return count;
    }

    public static int diceJump(int n, String ans) {
        if (n == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = 1; i <= 6 && (n - i) >= 0; i++) {
            count += diceJump(n - i, ans + i);
        }
        return count;
    }

    public static int permutation(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            String ros = str.substring(0, i) + str.substring(i + 1);
            count += permutation(ros, ans + str.charAt(i));
        }
        return count;
    }

    public static int permutationwithDuplicates(String str) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < freq[i]; j++) {
                sb.append((char) (i + 'a'));
            }
        }
        return permute(sb.toString(), "");
    }

    public static int permute(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        char prev = '$';
        for (int i = 0; i < str.length(); i++) {
            if (prev != str.charAt(i)) {
                String ros = str.substring(0, i) + str.substring(i + 1);
                count += permute(ros, ans + str.charAt(i));
            }
            prev = str.charAt(i);
        }
        return count;
    }

    public static int decode(String str, String ans) {

        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        char num = str.charAt(0);
        if (num == '0') {
            return 0;
        }
        char ch = (char) ('a' + num - '1');

        count += decode(str.substring(1), ans + ch);

        if (str.length() > 1) {

            int num2 = (num - '0') * 10 + (str.charAt(1) - '0');
            if (num2 <= 26) {
                char ch1 = (char) ('a' + num2 - 1);
                count += decode(str.substring(2), ans + ch1);
            }
        }

        return count;
    }

    public static int DecodeWays(String str, int idx, String ans) {

        if (idx == str.length()) {
            System.out.println(ans);

            return 1;
        }

        if (str.charAt(idx) == '0') {

            return 0;
        }

        int count = 0;
        int num = str.charAt(idx) - '0';
        char ch = (char) (str.charAt(idx) - '1' + 'a');
        count += DecodeWays(str, idx + 1, ans + ch);

        if (idx + 1 < str.length()) {

            int num2 = num * 10 + (str.charAt(idx + 1) - '0');

            if (num2 <= 26) {
                count += DecodeWays(str, idx + 2, ans + (char) (num2 + 'a'));
            }

        }

        return count;

    }

    public static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    public static String[] dirs = { "d", "t", "r", "l" };

    public static int floodFill(int[][] mat, int sr, int sc, int n, int m, String ans) {

        if (sr == mat.length && sc == mat[0].length) {
            System.out.println(ans);
            return 1;
        }
        mat[sr][sc] = 2;
        int count = 0;
        for (int i = 0; i < dir.length; i++) {
            int r = sr + dir[i][0];
            int c = sc + dir[i][1];
            if (r >= 0 && r < n && c >= 0 && c < m && mat[r][c] != 1 && mat[r][c] != 2) {
                count += floodFill(mat, r, c, n, m, ans + dirs[i]);
            }
        }
        mat[sr][sc] = 0;
        return count;

    }

    
    public static void main(String[] args) {

        // System.out.println(mazePath( 0,0, 3, 3, ""));
        // subs("abc","");
        // int ans = keypad("235", "");
        int ans = DecodeWays("12204", 0, "");
        System.out.println(ans);
        // System.out.println(mazePath(1,1,3,2,""));
        // diceJump(9,"");

    }

}