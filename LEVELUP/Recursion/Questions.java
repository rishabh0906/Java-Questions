import java.util.*;

public class Questions {
    // Word Break
    public static int WordBreak(String str, String ans, HashSet<String> dict) {
        if (str.length() == 0) {
            System.out.println(ans);
            return 1;
        }
        int count = 0;
        for (int ei = 0; ei < str.length(); ei++) {
            String subs = str.substring(0, ei + 1);
            if (dict.contains(subs)) {
                count += WordBreak(str.substring(ei + 1), ans + subs + " ", dict);
            }
        }

        return count;
    }

    // String after atmost K swaps
    static String max;

    public static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

    public static void findMaximum(String str, int k) {

        if (isGreater(max, str)) {
            max = str;
        }
        if (k == 0) {
            return;
        }

        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) < str.charAt(j)) {
                    str = swap(str, i, j);

                    findMaximum(str, k - 1);
                    str = swap(str, i, j);
                }
            }
        }

    }

    public static boolean isGreater(String str, String temp) {
        if (str.length() > temp.length()) {
            return false;
        } else if (str.length() < temp.length()) {
            return true;
        }

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < temp.charAt(i)) {
                return true;
            } else if (str.charAt(i) > temp.charAt(i)) {
                return false;
            }
        }

        return true;
    }
    // ===================================== SUDOKU SOLVER
    // ===================================

    public boolean checkIfNumberIsSafeToPlace(char[][] UnsolvedSudoku, int row, int col, int number_to_be_place) {
        for (int curr_col = 0; curr_col < 9; curr_col++)
            if (UnsolvedSudoku[row][curr_col] == (char) (number_to_be_place + '0'))
                return false;

        for (int curr_row = 0; curr_row < 9; curr_row++)
            if (UnsolvedSudoku[curr_row][col] == (char) (number_to_be_place + '0'))
                return false;

        row = (row / 3) * 3;
        col = (col / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (UnsolvedSudoku[i + row][j + col] == (char) (number_to_be_place + '0'))
                    return false;
            }
        }
        return true;

    }

    public boolean solveSudoku(char[][] UnsolvedSudoku, int EmptyCells_iterator, ArrayList<Integer> EmptyCells) {
        if (EmptyCells_iterator == EmptyCells.size()) {
            return true;
        }

        int position = EmptyCells.get(EmptyCells_iterator);
        int row = position / 9;
        int column = position % 9;

        for (int num_try_to_place = 1; num_try_to_place <= 9; num_try_to_place++) {
            if (checkIfNumberIsSafeToPlace(UnsolvedSudoku, row, column, num_try_to_place) == true) {
                UnsolvedSudoku[row][column] = (char) (num_try_to_place + '0');
                if (solveSudoku(UnsolvedSudoku, EmptyCells_iterator + 1, EmptyCells) == true)
                    return true;
                UnsolvedSudoku[row][column] = '.';
            }
        }

        return false;

    }

    public void solveSudoku_01(char[][] board) {
        ArrayList<Integer> EmptyCells = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    EmptyCells.add(i * 9 + j);
                }
            }
        }
        solveSudoku(board, 0, EmptyCells);

    }

    // ===========================Sudoku Solver Using bits //
    // ===========================//
    public boolean solveSudoku(char[][] UnsolvedSudoku, int EmptyCells_iterator, ArrayList<Integer> EmptyCells,
            int[] Rows, int[] Cols, int[][] Subs) {
        if (EmptyCells_iterator == EmptyCells.size()) {
            return true;
        }

        int position = EmptyCells.get(EmptyCells_iterator);
        int row = position / 9;
        int column = position % 9;

        for (int num_try_to_place = 1; num_try_to_place <= 9; num_try_to_place++) {
            int mask = (1 << num_try_to_place);

            if ((Rows[row] & mask) == 0 && (Cols[column] & mask) == 0 && (Subs[row / 3][column / 3] & mask) == 0) {
                UnsolvedSudoku[row][column] = (char) (num_try_to_place + '0');
                Rows[row] ^= mask;
                Cols[column] ^= mask;
                Subs[row / 3][column / 3] ^= mask;
                if (solveSudoku(UnsolvedSudoku, EmptyCells_iterator + 1, EmptyCells, Rows, Cols, Subs) == true)
                    return true;
                Rows[row] ^= mask;
                Cols[column] ^= mask;
                Subs[row / 3][column / 3] ^= mask;
                UnsolvedSudoku[row][column] = '.';
            }
        }

        return false;

    }

    public void solveSudoku_02(char[][] board) {
        ArrayList<Integer> EmptyCells = new ArrayList<>();
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[][] subs = new int[3][3];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    EmptyCells.add(i * 9 + j);
                } else {
                    int mask = 1 << (board[i][j] - '0');
                    rows[i] ^= mask;
                    cols[j] ^= mask;
                    subs[i / 3][j / 3] ^= mask;

                }
            }
        }
        solveSudoku(board, 0, EmptyCells, rows, cols, subs);

    }

    // ========================================= Valid Sudoku
    // =================================//
    public boolean isValidSudoku(char[][] board) {

        int[] Rows_Bits = new int[9];
        int[] Cols_Bits = new int[9];
        int[][] SubSquare_Bits = new int[3][3];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;

                int mask = 1 << (board[i][j] - '0');
                if ((Rows_Bits[i] & mask) == 0 && (Cols_Bits[j] & mask) == 0
                        && (SubSquare_Bits[i / 3][j / 3] & mask) == 0) {
                    Rows_Bits[i] ^= mask;
                    Cols_Bits[j] ^= mask;
                    SubSquare_Bits[i / 3][j / 3] ^= mask;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    // ======================================== Crypto
    // ===================================================

    public static int Mapping(String str, int[] map) {
        int val = 0;
        for (int i = 0; i < str.length(); i++) {
            val = val * 10 + map[str.charAt(i) - 'a'];
        }

        return val;
    }

    public static int solve(String str, int idx, boolean[] used, int[] map, String str1, String str2, String str3) {

        if (idx == str.length()) {
            int val1 = Mapping(str1, map);
            int val2 = Mapping(str2, map);
            int val3 = Mapping(str3, map);
            if (val1 + val2 == val3) {
                for (int i = 0; i < 26; i++) {
                    if (map[i] != -1) {
                        char ch = (char) (i + 'a');
                        System.out.println(ch + "->" + map[i] + " ");
                    }
                }

                return 1;
            }

            return 0;

        }

        int count = 0;
        for (int j = 0; j <= 9; j++) {
            if (used[j] == false) {
                used[j] = true;
                map[str.charAt(idx) - 'a'] = j;
                count += solve(str, idx + 1, used, map, str1, str2, str3);
                used[j] = false;
                map[str.charAt(idx) - 'a'] = -1;
            }
        }
        return count;

    }

    public static void VerbalArithmetic(String str1, String str2, String str3) {
        boolean[] unique = new boolean[26];
        String uniqueChar = "";
        for (int i = 0; i < str1.length(); i++) {
            if (unique[str1.charAt(i) - 'a'] == false) {
                unique[str1.charAt(i) - 'a'] = true;
                uniqueChar += str1.charAt(i);
            }
        }
        for (int i = 0; i < str2.length(); i++) {
            if (unique[str2.charAt(i) - 'a'] == false) {
                unique[str2.charAt(i) - 'a'] = true;
                uniqueChar += str2.charAt(i);
            }
        }
        for (int i = 0; i < str3.length(); i++) {
            if (unique[str3.charAt(i) - 'a'] == false) {
                unique[str3.charAt(i) - 'a'] = true;
                uniqueChar += str3.charAt(i);
            }
        }

        boolean[] used = new boolean[10];
        int[] map = new int[26];
        Arrays.fill(map, -1);
        solve(uniqueChar, 0, used, map, str1, str2, str3);

    }

    // two subsets with equal Sum
    public static int equalSet(int[] arr, int idx, int sum1, int sum2, String str1, String str2) {

        if (idx == arr.length) {
            if (sum1 == sum2) {
                System.out.println(str1 + "===" + str2);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += equalSet(arr, idx + 1, sum1 + arr[idx], sum2, str1 + "," + arr[idx], str2);
        count += equalSet(arr, idx + 1, sum1, sum2 + arr[idx], str1, str2 + "," + arr[idx]);

        return count;

    }

    public static int solve_02(int[] arr, int ind, int sum_to_made, ArrayList<ArrayList<Integer>> ans) {

        if (ind == arr.length) {
            if (sum_to_made == 0) {
                System.out.println(ans);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if (sum_to_made - arr[ind] >= 0) {
            ans.get(0).add(arr[ind]);
            count += solve_02(arr, ind + 1, sum_to_made - arr[ind], ans);
            ans.get(0).remove(ans.get(0).size() - 1);
        }
        if (ind != 0) {
            ans.get(1).add(arr[ind]);
            count += solve_02(arr, ind + 1, sum_to_made, ans);
            ans.get(1).remove(ans.get(1).size() - 1);
        }
        return count;
    }

    public static void equalSet_02(int[] arr) {

        int k = 2;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }

        int sum = 0;
        for (int ele : arr) {
            sum += ele;
        }
        if ((sum % k) != 0) {
            return;
        }

        solve_02(arr, 0, sum / k, ans);

    }

    // Ksubsets with Equal Sum ==========================================//
    public static int Ksubsets(int[] arr, int idx, int k, int sum, int[] ksums, ArrayList<ArrayList<Integer>> ans) {

        if (idx == arr.length) {

            for (int i = 0; i < k; i++) {
                if (ksums[i] != sum)
                    return 0;
            }
            System.out.println(ans);
            return 1;

        }

        int count = 0;

        for (int i = 0; i < k; i++) {

            if (ksums[i] == 0) {
                ksums[i] += arr[idx];
                ans.get(i).add(arr[idx]);
                count += Ksubsets(arr, idx + 1, k, sum, ksums, ans);
                ksums[i] -= arr[idx];
                ans.get(i).remove(ans.get(i).size() - 1);
                break;
            } else {
                if (ksums[i] + arr[idx] <= sum) {
                    ans.get(i).add(arr[idx]);
                    ksums[i] += arr[idx];
                    count += Ksubsets(arr, idx + 1, k, sum, ksums, ans);
                    ans.get(i).remove(ans.get(i).size() - 1);
                    ksums[i] -= arr[idx];
                }
            }
        }

        return count;
    }

    public static void Ksubsets(int[] arr, int k) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int sum = 0;
        for (int ele : arr) {
            sum += ele;
        }

        if (sum % k != 0)
            return;

        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        int[] ksums = new int[k];

        Ksubsets(arr, 0, k, sum / k, ksums, ans);

    }

    public static int Counter = 1;

    public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {

        if (i == n + 1) {
            if (rssf == k) {
                System.out.print(Counter + ". ");
                Counter++;
                for (int idx = 0; idx < k; idx++) {
                    System.out.print(ans.get(idx) + " ");
                }
                System.out.println();

            }
            return;
        }

        for (int idx = 0; idx < k; idx++) {

            if (ans.get(idx).size() == 0) {
                ans.get(idx).add(i);
                solution(i + 1, n, k, rssf + 1, ans);
                ans.get(idx).remove(ans.get(idx).size() - 1);
                break;
            } else {
                ans.get(idx).add(i);
                solution(i + 1, n, k, rssf, ans);
                ans.get(idx).remove(ans.get(idx).size() - 1);

            }
        }

    }

    // CrossWord Puzzle ===================================//

    static char[][] box = { { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
            { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' }, { '+', '-', '-', '-', '-', '-', '-', '-', '+', '+' },
            { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' }, { '+', '-', '+', '+', '+', '+', '+', '+', '+', '+' },
            { '+', '-', '-', '-', '-', '-', '-', '+', '+', '+' }, { '+', '-', '+', '+', '+', '-', '+', '+', '+', '+' },
            { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' }, { '+', '+', '+', '+', '+', '-', '+', '+', '+', '+' },
            { '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' } };

    static String[] words = { "agra", "norway", "england", "gwalior" };

    public static boolean isSafeH(int r, int c, String word) {

        int left = c - 1;
        while (left >= 0 && box[r][left] != '+') {
            left--;
        }
        int right = c + 1;
        while (right < 10 && box[r][right] != '+') {
            right++;
        }
        int lc = left + 1;
        int rc = right - 1;

        if (rc - lc + 1 != word.length())
            return false;

        for (int i = 0; i < word.length(); i++) {
            if (box[r][lc + i] != '-' && box[r][lc + i] != word.charAt(i))
                return false;
        }

        return true;

    }

    public static int placeV(int r, int c, String word) {

        int loc = 0;
        for (int i = 0; i < word.length(); i++) {

            if (box[r + i][c] == '-') {
                loc ^= (1 << i);
                box[r + i][c] = word.charAt(i);
            }
        }
        return loc;

    }

    public static void unplaceV(int r, int c, int loc, String word) {
        for (int i = 0; i < word.length(); i++) {

            if ((loc & (1 << i)) != 0) {
                loc ^= (1 << i);
                box[r + i][c] = '-';

            }
        }
    }

    public static boolean isSafeV(int r, int c, String word) {
        int top = r - 1;
        while (top >= 0 && box[top][c] != '+') {
            top--;
        }
        int bottom = r + 1;
        while (bottom < 10 && box[bottom][c] != '+') {
            bottom++;
        }
        int lr = top + 1;
        int rr = bottom - 1;

        if (rr - lr + 1 != word.length())
            return false;

        for (int i = 0; i < word.length(); i++) {
            if (box[lr+i][c] != '-' && box[lr+i][c] != word.charAt(i))
                return false;
        }

        return true;
    }

    public static int placeH(int r, int c, String word) {
        int loc = 0;
        for (int i = 0; i < word.length(); i++) {

            if (box[r][c + i] == '-') {
                loc ^= (1 << i);
                box[r][c + i] = word.charAt(i);

            }
        }
        return loc;
    }

    public static void unplaceH(int r, int c, int loc, String word) {
        for (int i = 0; i < word.length(); i++) {

            if ((loc & (1 << i)) != 0) {
                loc ^= (1 << i);
                box[r][c + i] = '-';

            }
        }
    }

    public static boolean CrossWord(int index) {

        if (index == words.length) {

            return true;
        }

        String word = words[index];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (isSafeH(i, j, word)) {
                    int loc = placeH(i, j, word);
                    if (CrossWord(index + 1))
                        return true;
                    unplaceH(i, j, loc, word);
                }
                if (isSafeV(i, j, word)) {
                    int loc = placeV(i, j, word);
                    if (CrossWord(index + 1))
                        return true;
                    unplaceV(i, j, loc, word);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6 };
         equalSet(arr, 1, 10, 0, "10", "");
        equalSet_02(arr);
       CrossWord(0);
     
       for(int i=0;i<10;i++){
        for(int j=0;j<10;j++){
            System.out.print(box[i][j]+" ");
        }
        System.out.println();
    }

    }

}
