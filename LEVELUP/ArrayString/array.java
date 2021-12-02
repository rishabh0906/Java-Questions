import java.util.*;

public class array {

    public static void swap(int[] nums, int i, int j) {

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int i, int j) {

        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static int[] rotateArray(int[] nums, int k) {
        int n = nums.length;
        k = (k % n + n) % n;

        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);

        return nums;
    }

    public static int[] segregateNegPos(int[] nums) {

        int i = -1;
        int n = nums.length;
        int j = 0;
        while (j < n) {

            if (nums[j] < 0) {

                swap(nums, j, ++i);
            }
            j++;

        }

        return nums;

    }

    public static int[] segregate01(int[] nums, int start) {
        int i = -1;
        int n = nums.length;
        int j = start;
        while (j < n) {

            if (nums[j] == 0) {

                swap(nums, j, ++i);
            }
            j++;

        }

        return nums;
    }

    public static int[] segregate012(int[] nums) {

        int zero = -1;
        int two = nums.length;
        int i = 0;
        while (i < two) {

            if (nums[i] == 0) {
                swap(nums, i++, ++zero);
            } else if (nums[i] == 2) {

                swap(nums, i, --two);
            } else {
                i++;
            }

        }
        return nums;
    }

    // Maximum Sum of Configuration
    public int max_sum(int A[], int n) {

        int total = 0;
        int cSum = 0;
        int idx = 0;
        for (int ele : A) {
            total += ele;
            cSum += idx * ele;
            idx++;
        }

        int max = cSum;

        for (int i = 1; i < n; i++) {
            int newSum = cSum + n * A[i - 1] - total;

            max = Math.max(max, newSum);
            cSum = newSum;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] a = { 1, 1, 1, 0, 2, 1, 2, 2, 0, 0, 1 };

        segregate012(a);
        for (int ele : a)
            System.out.print(ele + " ");
    }

    class pair {

        Integer sum = 0;
        int[] idx;

        pair(int sum, int[] idx) {
            this.sum = sum;
            this.idx = idx;

        }
    }

    public int kthSmallest(int[][] mat, int k) {

        PriorityQueue<pair> pq = new PriorityQueue<>();

        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][0];
        }
        int[] idx = new int[mat.length];
        pq.add(new pair(sum, idx));

        while (k-- > 0) {

            pair top = pq.remove();

            for (int i = 0; i < mat.length; i++) {

                if (top.idx[i] + 1 < mat[0].length) {

                    int newsum = top.sum - mat[i][top.idx[i]] + mat[i][top.idx[i] + 1];
                    int[] newidx = top.idx.clone();
                    newidx[i] = top.idx[i] + 1;
                    pq.add(new pair(newsum, newidx));
                }
            }
        }

        return pq.peek().sum;
    }

}
