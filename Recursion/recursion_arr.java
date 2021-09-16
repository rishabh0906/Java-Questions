import java.util.*;

public class recursion_arr {

    public static Scanner scn = new Scanner(System.in);

    public static void print_rec(int[] arr, int n) {
        if (n == 1) {
            System.out.print(arr[n - 1] + " ");
            return;
        }
        print_rec(arr, n - 1);
        System.out.print(arr[n - 1] + " ");

    }

    public static void print_rec_rev(int[] arr, int n) {
        if (n == 1) {
            System.out.print(arr[n - 1] + " ");
            return;
        }
        System.out.print(arr[n - 1] + " ");
        print_rec_rev(arr, n - 1);

    }

    public static int findmax(int[] arr, int n) {
        if (n == 1) {

            return arr[n - 1];
        }
        int res = findmax(arr, n - 1);

        return res > arr[n - 1] ? res : arr[n - 1];
    }

    public static int findmin(int[] arr, int n) {
        if (n == 1) {

            return arr[n - 1];
        }
        int res = findmin(arr, n - 1);

        return res < arr[n - 1] ? res : arr[n - 1];
    }

    public static boolean finddata(int[] arr, int idx, int data) {
        if (idx == arr.length) {
            return false;
        }
        if (arr[idx] == data) {
            return true;
        }
        return finddata(arr, idx + 1, data);
    }

    public static int firstidx(int[] arr, int idx, int data) {
        if (idx == arr.length) {
            return -1;
        }
        if (arr[idx] == data) {
            return idx;
        }
        return firstidx(arr, idx + 1, data);
    }

    public static int lastidx(int[] arr, int idx, int data) {
        if (idx == arr.length) {
            return -1;
        }

        int res = lastidx(arr, idx + 1, data);
        if (res == -1 && arr[idx] == data) {
            res = idx;
        }

        return res;
    }

    public static int[] allindex(int[] arr, int idx, int x, int count) {

        if (idx == arr.length) {
            return (new int[count]);
        }
        if (arr[idx] == x) {
            count++;
        }

        int[] temp = allindex(arr, idx + 1, x, count);
        if (arr[idx] == x) {
            temp[count - 1] = idx;
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 56, 45, 434, 344, 5434, 554, 4543, 334, 334, 54356 };
        int[] ans = allindex(arr, 0, 334, 0);

    }
}