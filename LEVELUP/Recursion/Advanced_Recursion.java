

public class Advanced_Recursion {

    public static int infinitePermutation(int[] coins, int target, String asf) {
        if (target == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for (int i = 0; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                count += infinitePermutation(coins, target - coins[i], asf + coins[i]);
            }
        }

        return count;
    }

    public static int infiniteCombination(int[] coins, int idx, int target, String asf) {
        if (target == 0) {
            System.out.println(asf);
            return 1;
        }
        int count = 0;

        for (int i = idx; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                count += infiniteCombination(coins, i, target - coins[i], asf + coins[i]);
            }
        }

        return count;
    }

    public static int singleCombination(int[] coins, int idx, int target, String asf) {
        if (target == 0) {
            System.out.println(asf);
            return 1;
        }
        int count = 0;

        for (int i = idx; i < coins.length; i++) {
            if (target - coins[i] >= 0) {
                count += singleCombination(coins, i + 1, target - coins[i], asf + coins[i]);
            }
        }

        return count;
    }

    public static int singlePermutation(int[] coins, int target, String asf) {

        if (target == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] != -1 && target - coins[i] >= 0) {

                int val = coins[i];
                coins[i] = -1;
                count += singlePermutation(coins, target - val, asf + val);
                coins[i] = val;
            }

        }

        return count;

    }

    public static int infinitePermutation_Subs(int[] arr, int target, int idx, String asf) {
        if (target == 0) {
            System.out.println(asf);
            return 1;
        }
        if (idx == arr.length) {
            return 0;
        }

        int count = 0;
        count += infinitePermutation_Subs(arr, target, idx + 1, asf);

        if (target - arr[idx] >= 0) {
            count += infinitePermutation_Subs(arr, target - arr[idx], 0, asf + arr[idx]);
        }

        return count;
    }

    public static int infiniteCombination_Subs(int[] arr, int target, int idx, String asf) {
        if (target == 0) {
            System.out.println(asf);
            return 1;
        }
        if (idx == arr.length) {
            return 0;
        }

        int count = 0;
        count += infiniteCombination_Subs(arr, target, idx + 1, asf);

        if (target - arr[idx] >= 0) {
            count += infiniteCombination_Subs(arr, target - arr[idx], idx, asf + arr[idx]);
        }
        return count;

    }

    public static int SingleCombination_Subs(int[] arr, int target, int idx, String asf) {
        if (target == 0) {
            System.out.println(asf);
            return 1;
        }
        if (idx == arr.length) {
            return 0;
        }

        int count = 0;
        count += SingleCombination_Subs(arr, target, idx + 1, asf);

        if (target - arr[idx] >= 0) {
            count += SingleCombination_Subs(arr, target - arr[idx], idx + 1, asf + arr[idx]);
        }
        return count;

    }

    public static int singlePermutation_Subs(int[] arr, int target, int idx, String asf) {
        if (target == 0) {
            System.out.println(asf);
            return 1;
        }
        if (idx == arr.length) {
            return 0;
        }

        int count = 0;

        if (arr[idx] != -1 && target - arr[idx] >= 0) {
            int val = arr[idx];
            arr[idx] = -1;
            count += singlePermutation_Subs(arr, target - val, 0, asf + val);
            arr[idx] = val;

        }
        count += singlePermutation_Subs(arr, target, idx + 1, asf);
        return count;

    }

    // Queen Set
    // ====================================================================

    public static int Place(int qsf, int bsf, int n, int k, String asf) {

        if (qsf == k) {
            System.out.println(asf);
            return 1;
        }
        if (bsf == n) {
            return 0;
        }

        int count = 0;
        for (int j = bsf; j < n; j++) {
            count += Place(qsf + 1, j + 1, n, k, asf + "q" + qsf + "b" + j + " ");
        }

        return count;

    }

    public static int queenCombination1D_sub(int tnb, int bno, int tnq, int qpsf, String asf) {
        if (qpsf > tnq || bno > tnb) {
            if (qpsf > tnq) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;
        count += queenCombination1D_sub(tnb, bno + 1, tnq, qpsf + 1, asf + "b" + bno + "q" + qpsf + " ");
        count += queenCombination1D_sub(tnb, bno + 1, tnq, qpsf, asf);

        return count;
    }

    public static void queenCombination1D(int n, int k) {

        System.out.println(Place(0, 0, n, k, ""));
    }

    public static int Place2(int q, int n, int k, boolean[] vis, String asf) {
        if (q == k) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                vis[i] = true;
                count += Place2(q + 1, n, k, vis, asf + "b" + i + "q" + q + " ");
                vis[i] = false;
            }
        }
        return count;
    }

    public static int queenPermutation1D_sub(int tnb, int bno, int tnq, int qpsf, boolean[] vis, String asf) {
        if (qpsf > tnq || bno > tnb) {
            if (qpsf > tnq) {
                System.out.println(asf);
                return 1;
            }
            return 0;
        }

        int count = 0;

        if (!vis[bno]) {
            vis[bno] = true;
            count += queenPermutation1D_sub(tnb, 1, tnq, qpsf + 1, vis, asf + "b" + bno + "q" + qpsf + " ");
            vis[bno] = false;
        }
        count += queenPermutation1D_sub(tnb, bno + 1, tnq, qpsf, vis, asf);
        return count;
    }

    public static void queenPermutation1D(int n, int k) {

        boolean[] vis = new boolean[n];
        System.out.println(Place2(0, n, k, vis, ""));

    }

    // Queen 2D

    public static int queenPermutation2D(boolean[][] box, int q, String asf) {
        if (q == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length;
        int m = box[0].length;

        for (int b = 0; b < n * m; b++) {
            int r = b / m;
            int c = b % m;

            if (!box[r][c]) {
                box[r][c] = true;
                count += queenPermutation2D(box, q - 1, asf + "(" + r + "," + c + ") ");
                box[r][c] = false;
            }
        }

        return count;
    }

    public static int queenPermutation2D_sub(boolean[][] box, int q, int bsf, String asf) {
        int n = box.length;
        int m = box[0].length;
        if (q == 0) {
            System.out.println(asf);
            return 1;
        }
        if (bsf == n * m) {
            return 0;
        }

        int count = 0;

        int r = bsf / m;
        int c = bsf % m;

        if (box[r][c] == false) {
            box[r][c] = true;
            count += queenPermutation2D_sub(box, q - 1, 0, asf + "(" + r + "," + c + ") ");
            box[r][c] = false;
        }
        count += queenPermutation2D_sub(box, q, bsf + 1, asf);
        return count;

    }

    public static int queenCombination2D(boolean[][] box, int q, int bsf, String asf) {
        if (q == 0) {
            System.out.println(asf);
            return 1;
        }

        int count = 0;
        int n = box.length;
        int m = box[0].length;

        for (int b = bsf; b < n * m; b++) {
            int r = b / m;
            int c = b % m;
            count += queenCombination2D(box, q - 1, b + 1, asf + "(" + r + "," + c + ") ");

        }

        return count;
    }

    public static int queenCombination2D_sub(boolean[][] box, int q, int bsf, String asf) {
        int n = box.length;
        int m = box[0].length;
        if (q == 0) {
            System.out.println(asf);
            return 1;
        }
        if (bsf == n * m) {
            return 0;
        }

        int count = 0;

        int r = bsf / m;
        int c = bsf % m;

        count += queenCombination2D_sub(box, q - 1, bsf + 1, asf + "(" + r + "," + c + ") ");
        count += queenCombination2D_sub(box, q, bsf + 1, asf);

        return count;

    }

    public static void queen2D() {
        int n = 4;
        boolean[][] box = new boolean[n][n];
        // queenPermutation2D(box,n,"");
        queenPermutation2D_sub(box, n, 0, "");

    }

    public static void main(String[] args) {

        // int []arr={2,3,5,7};
        // System.out.println(infinitePermutation(arr,10,""));

        // queenCombination1D(6,4);
        // queenPermutation1D(6,4);
        queen2D();

    }

}