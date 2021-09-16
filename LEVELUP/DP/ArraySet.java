import java.util.Arrays;

public class ArraySet {

    public static int maxDotProduct_Uti(int[] nums1, int[] nums2, int n, int m, int[][] dp) {
        if (m == 1) {

            int maximumScore = (int) -1e9;
            for (int i = 0; i < n; i++) {
                maximumScore = Math.max(maximumScore, nums1[i] * nums2[m - 1]);
            }

            return dp[n][m] = maximumScore;

        }

        if (n == 1) {
            int maximumScore = (int) -1e9;
            for (int i = 0; i < m; i++) {
                maximumScore = Math.max(maximumScore, nums2[i] * nums1[n - 1]);
            }

            return dp[n][m] = maximumScore;

        }

        if (dp[n][m] != (int) -1e9)
            return dp[n][m];

        int excludeBoth = maxDotProduct_Uti(nums1, nums2, n - 1, m - 1, dp);
        int include1exclude2 = maxDotProduct_Uti(nums1, nums2, n, m - 1, dp);
        int include2exclude1 = maxDotProduct_Uti(nums1, nums2, n - 1, m, dp);

        int ans1 = Math.max(excludeBoth + nums2[m - 1] * nums1[n - 1], Math.max(include1exclude2, include2exclude1));
        return dp[n][m] = Math.max(ans1, nums1[n - 1] * nums2[m - 1]);

    }

    public static int maxDotProduct(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int[] a : dp)
            Arrays.fill(a, (int) -1e9);
        return maxDotProduct_Uti(nums1, nums2, n, m, dp);

    }

    public static void main(String[] args) {

    }

}
