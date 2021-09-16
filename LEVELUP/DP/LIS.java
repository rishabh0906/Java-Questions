import java.util.Arrays;

public class LIS {

    public static int lis(int[] arr, int index, int[] dp) {

        if (dp[index] != 0)
            return dp[index];

        int ans = 1;
        for (int i = index - 1; i >= 0; i--) {

            if (arr[i] < arr[index]) {

                ans = Math.max(ans, lis(arr, i + 1, dp));

            }
        }

        return dp[index] = ans;

    }

    public static int LIS_LR(int[] arr, int[] dp) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public static int LIS_RL(int[] arr, int[] dp) {
        int maxLen = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public static int bitonic_subs(int[] arr) {

        int maxLen = 0;
        int n = arr.length;

        int[] LIS = new int[n];
        int[] LDS = new int[n];

        LIS_LR(arr, LIS);
        LIS_RL(arr, LDS);

        for (int i = 0; i < n; i++) {

            maxLen = Math.max(maxLen, LIS[i] + LDS[i] - 1);
        }

        return maxLen;
    }

    public int findNumberOfLIS(int[] nums) {

        int maxLen = 0;
        int maxCount = 0;
        int[] dp = new int[nums.length];
        int[] Count = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            dp[i] = 1;
            int count = 1;
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {

                    if (dp[j] + 1 > dp[i]) {

                        dp[i] = dp[j] + 1;
                        count = Count[j];
                    } else if (dp[j] + 1 == dp[i]) {

                        count += Count[j];
                    }
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxCount = count;
            } else if (dp[i] == maxLen) {
                maxCount += count;
            }

            Count[i] = count;

        }

        return maxCount;

    }

    // Non overlapping Maximum Brigde

    public static int NonOverlappingBridge(int[][] arr) {

        Arrays.sort(arr, (a, b) -> {
            return a[1] - b[1];
        });

        int[] dp = new int[arr.length];
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j][0] < arr[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;

    }

    // Russian Envelopes

    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr, (a, b) -> {
            return a[1] - b[1];
        });

        int[] dp = new int[arr.length];
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j][0] < arr[i][0] && arr[j][1] < arr[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    public static void main(String[] args) {

    }
}
