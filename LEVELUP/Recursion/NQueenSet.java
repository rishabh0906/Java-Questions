

public class NQueenSet {

    public static boolean isSafe1(boolean[][] box, int sr, int sc) {
        int[][] dir = { { 0, -1 }, { -1, 0 }, { -1, -1 }, { -1, 1 } };

        for (int i = 0; i < dir.length; i++) {
            for (int rad = 1; rad <= box.length; rad++) {
                int r = sr + rad * dir[i][0];
                int c = sc + rad * dir[i][1];
                if (r >= 0 && c >= 0 && r < box.length && c < box[0].length) {
                    if (box[r][c])
                        return false;
                } else {
                    break;
                }
            }
        }
        return true;
    }

    public static int NQueen_01_Combination(boolean[][] box, int b, int q, String asf) {

        if (q == 0) {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        int n = box.length;
        int m = box[0].length;
        for (int i = b; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (isSafe1(box, r, c)) {
                box[r][c] = true;
                count += NQueen_01_Combination(box, i + 1, q - 1, asf + "(" + r + "," + c + ") ");
                box[r][c] = false;
            }
        }

        return count;

    }

    public static boolean isSafe2(boolean[][] box, int sr, int sc) {
        int[][] dir = { { 0, -1 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 0, 1 }, { 1, 0 }, { 1, 1 }, { 1, -1 } };

        for (int i = 0; i < dir.length; i++) {
            for (int rad = 1; rad <= box.length; rad++) {
                int r = sr + rad * dir[i][0];
                int c = sc + rad * dir[i][1];
                if (r >= 0 && c >= 0 && r < box.length && c < box[0].length) {
                    if (box[r][c])
                        return false;
                } else {
                    break;
                }
            }
        }
        return true;
    }

    public static int NQueen_01_Permutation(boolean[][] box, int q, String asf) {

        if (q == 0) {
            System.out.println(asf);
            return 1;
        }
        int count = 0;
        int n = box.length;
        int m = box[0].length;
        for (int i = 0; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (!box[r][c] && isSafe2(box, r, c)) {
                box[r][c] = true;
                count += NQueen_01_Permutation(box, q - 1, asf + "(" + r + "," + c + ") ");
                box[r][c] = false;
            }
        }

        return count;

    }

    static boolean[] row, col, diag, anti;

    public static int NQueen_02_Combination(int n, int m, int q, int b, String asf) {
        if (q == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = b; i < n * m; i++) {
            int r = i / m;
            int c = i % m;

            if (!row[r] && !col[c] && !diag[r + c] && !anti[c - r + n - 1]) {
                row[r] = col[c] = diag[r + c] = anti[c - r + n - 1] = true;
                count += NQueen_02_Combination(n, m, q - 1, i + 1, asf + "(" + r + "," + c + ") ");
                row[r] = col[c] = diag[r + c] = anti[c - r + n - 1] = false;

            }
        }

        return count;

    }

    public static int NQueen_02_Permutation(int n, int m, int q, String asf) {
        if (q == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < n * m; i++) {
            int r = i / m;
            int c = i % m;

            if (!row[r] && !col[c] && !diag[r + c] && !anti[c - r + n - 1]) {
                row[r] = col[c] = diag[r + c] = anti[c - r + n - 1] = true;
                count += NQueen_02_Permutation(n, m, q - 1, asf + "(" + r + "," + c + ") ");
                row[r] = col[c] = diag[r + c] = anti[c - r + n - 1] = false;

            }
        }
        return count;
    }

    public static int NQueen_03_Combination(int n, int m, int floor, int q, String asf) {
        if (q == 0) {
            System.out.println(asf);
            return 1;
        }

        if (floor >= n) {
            return 0;
        }

        int count = 0;
        for (int room = 0; room < m; room++) {
            int r = floor;
            int c = room;

            if (!col[c] && !diag[r + c] && !anti[c - r + n - 1]) {
                col[c] = diag[r + c] = anti[c - r + n - 1] = true;
                count += NQueen_03_Combination(n, m, floor + 1, q - 1, asf + "(" + r + "," + c + ") ");
                col[c] = diag[r + c] = anti[c - r + n - 1] = false;

            }
        }

        return count;

    }

    public static int NQueen_03_Permutation(int n, int m, int floor, int q, String asf) {
        if (q == 0) {
            System.out.println(asf);
            return 1;
        }

        if (floor >= n) {
            return 0;
        }

        int count = 0;
        for (int room = 0; room < m; room++) {
            int r = floor;
            int c = room;

            if (!col[c] && !diag[r + c] && !anti[c - r + n - 1]) {
                col[c] = diag[r + c] = anti[c - r + n - 1] = true;
                count += NQueen_03_Permutation(n, m, 0, q - 1, asf + "(" + r + "," + c + ") ");
                col[c] = diag[r + c] = anti[c - r + n - 1] = false;
            }
        }

        count += NQueen_03_Permutation(n, m, floor + 1, q, asf);

        return count;

    }

    /// N Queen Using Bits Manipulation
    static int colMask = 0, diagMask = 0, antiMask = 0;

    public static int NQueen_04_Combination(int n, int m, int floor, int q, String asf) {
        if (q == 0) {
            System.out.println(asf);
            return 1;
        }

        if (floor >= n) {
            return 0;
        }

        int count = 0;
        for (int room = 0; room < m; room++) {
            int r = floor;
            int c = room;

            if ((colMask & (1 << c)) == 0 && (diagMask & (1 << (r + c))) == 0
                    && (antiMask & (1 << (r - c + n - 1))) == 0) {
                colMask ^= (1 << c);
                diagMask ^= (1 << (r + c));
                antiMask ^= (1 << (r - c + n - 1));
                count += NQueen_04_Combination(n, m, floor + 1, q - 1, asf + "(" + r + "," + c + ") ");
                colMask ^= (1 << c);
                diagMask ^= (1 << (r + c));
                antiMask ^= (1 << (r - c + n - 1));

            }
        }

        return count;

    }

    public static void main(String[] args) {

        int n = 4;
        row = new boolean[n];
        col = new boolean[n];
        diag = new boolean[2 * n - 1];
        anti = new boolean[2 * n - 1];
        System.out.println(NQueen_03_Permutation(n, n, 0, n, ""));

    }

}