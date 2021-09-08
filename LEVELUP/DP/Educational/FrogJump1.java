import java.util.Arrays;

public class FrogJump1 {

    public static int frogJump(int[] height, int idx, int[] dp) {

        if (idx == height.length - 1)
            return dp[idx] = 0;

        if (dp[idx] != -1)
            return dp[idx];
        int ans = frogJump(height, idx + 1, dp) + Math.abs(height[idx] - height[idx + 1]);
        if (idx + 2 < height.length) {
            ans = Math.min(ans, frogJump(height, idx + 2, dp) + Math.abs(height[idx] - height[idx + 2]));
        }

        return dp[idx] = ans;
    }

    public static int frogJump_02(int[] height, int IDX, int[] dp) {

        for (int idx = height.length - 1; idx >= 0; idx--) {
            if (idx == height.length - 1) {
                dp[idx] = 0;
                continue;
            }
            // recursive memoized state can be replaced by iterative tabulation state
            int ans = dp[idx + 1]/* frogJump(height, idx + 1,dp) */ + Math.abs(height[idx] - height[idx + 1]);
            if (idx + 2 < height.length) {
                ans = Math.min(ans,
                        dp[idx + 2] /* frogJump(height, idx + 2,dp) */ + Math.abs(height[idx] - height[idx + 2]));
            }

            dp[idx] = ans;

        }

        return dp[IDX];
    }

    // exteded for k steps
    public static int frogJump_03(int[] height, int idx, int[] dp, int k) {

        if (idx == height.length - 1)
            return dp[idx] = 0;

        if (dp[idx] != -1)
            return dp[idx];
        int ans = (int) 1e9;
        for (int i = 1; i <= k && idx + i < height.length; i++) {

            ans = Math.min(ans, frogJump_03(height, idx + i, dp, k) + Math.abs(height[idx] - height[idx + i]));

        }

        return dp[idx] = ans;
    }

    public static void main(String[] args) {

        int n = 10;
        int[] height = {  40, 10, 20, 70, 80, 10, 20, 70, 80, 60 };
        int k=4;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        System.out.println(frogJump_03(height, 0, dp, k));
    }
}
