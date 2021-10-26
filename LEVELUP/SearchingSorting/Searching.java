import javax.lang.model.util.ElementScanner14;

public class Searching {

    public static int binarySearch(int[] arr, int si, int ei, int value) {

        while (si <= ei) {

            int mid = (si + ei) / 2;

            if (arr[mid] == value)
                return mid;
            else if (arr[mid] < value)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return -1;

    }

    public static int FirstIndex(int[] arr, int si, int ei, int value) {

        int ans = -1;

        while (si <= ei) {

            int mid = (si + ei) / 2;
            if (arr[mid] == value) {
                ans = mid;
                ei = mid - 1;
            } else if (arr[mid] < value)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return ans;
    }

    public static int LastIndex(int[] arr, int si, int ei, int value) {

        int ans = -1;

        while (si <= ei) {

            int mid = (si + ei) / 2;
            if (arr[mid] == value) {
                ans = mid;
                si = mid + 1;
            } else if (arr[mid] < value)
                si = mid + 1;
            else
                ei = mid - 1;
        }

        return ans;
    }

    public static int Floor(int[] arr, int si, int ei, int target) {

        int ans = -1;

        while (si <= ei) {

            int mid = (si + ei) / 2;

            if (arr[mid] <= target) {
                ans = mid;
                si = mid + 1;
            } else
                ei = mid - 1;

        }
        return ans;
    }

    public static int Ceil(int[] arr, int si, int ei, int target) {

        int ans = -1;

        while (si <= ei) {

            int mid = (si + ei) / 2;

            if (arr[mid] >= target) {
                ans = mid;
                ei = mid - 1;
            } else
                si = mid + 1;

        }
        return ans;
    }

    public static int perfectLocation(int[] arr, int target) {

        int si = 0, ei = arr.length;

        while (si < ei) {

            int mid = (si + ei) / 2;

            if (arr[i] <= target) {
                si = mid + 1;
            } else
                ei = mid;
        }

        return ei;

    }

    public static boolean searchMatrix_01(int[][] matrix, int target) {

        int si = 0, ei = matrix.length * matrix[0].length - 1;
        int n = matrix.length, m = matrix[0].length;
        while (si <= ei) {

            int mid = (si + ei) / 2;

            int r = mid / n, c = mid % n;

            if (matrix[r][c] == target)
                return true;
            else if (matrix[r][c] > target)
                ei = mid - 1;
            else
                si = mid + 1;

        }

        return false;

    }

    public static boolean searchMatrix_02(int[][] matrix, int target) {

        int i = 0, j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {

            if (matrix[i][j] == target)
                return true;
            if (matrix[i][j] > target)
                j--;
            else
                i++;
        }

        return false;

    }

    public static void main(String[] args) {

        int[] arr = { 0, 0, 1, 1, 2, 3, 4, 6, 7, 8, 9, 10, 10, 11 };
        System.out.println(perfectLocation(arr, 12));
    }

}
