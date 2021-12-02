class BuyAndSell {
    // atmost one
    public int maxProfit_01(int[] prices) {

        int buy = (int) -1e9;
        int sell = 0;

        for (int i = 0; i < prices.length; i++) {

            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, -prices[i]);

        }

        return sell;

    }

    // Infinite Transaction
    public int maxProfit_02(int[] prices) {
        int buy = (int) -1e9;
        int sell = 0;

        for (int i = 0; i < prices.length; i++) {

            sell = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, sell - prices[i]);

        }

        return sell;
    }

    // With Transaction fee
    public int maxProfit_03(int[] prices, int fee) {
        int buy = (int) -1e9;
        int sell = 0;

        for (int i = 0; i < prices.length; i++) {

            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);

        }

        return sell;
    }

    // cooldown
    public int maxProfit_04(int[] prices) {

        int buy = (int) -1e9;
        int sell = 0;
        int sellprev = 0;

        for (int i = 0; i < prices.length; i++) {

            int sellnew = Math.max(sell, buy + prices[i]);
            buy = Math.max(buy, sellprev - prices[i]);
            sellprev = sell;
            sell = sellnew;

        }

        return sell;
    }

    // atmost 2 transaction
    public int maxProfit_05(int[] prices) {

        int n = prices.length;
        int[][][] dp = new int[n][3][2];

        for (int i = 0; i < n; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = (int) -1e9;
        }

        for (int i = 0; i < n; i++) {

            for (int k = 1; k <= 2; k++) {

                dp[i][k][0] = i == 0 ? 0 : Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(i == 0 ? (int) -1e9 : dp[i - 1][k][1],
                        (i == 0 ? 0 : dp[i - 1][k - 1][0]) - prices[i]);

            }
        }
        return dp[n - 1][2][0];
    }
// Atmost 2 transactions
    public int maxProfit_06(int[] prices) {
        int buy1 = (int) -1e9;
       int sell1 = 0;
       int sell2=0;
       int buy2=(int) -1e9;

       for (int i = 0; i < prices.length; i++) {
           sell2=Math.max(sell2,buy2+prices[i]);
           buy2=Math.max(buy2,sell1-prices[i]);
           sell1 = Math.max(sell1, buy1 + prices[i]);
           buy1 = Math.max(buy1, - prices[i]);

       }

       return Math.max(sell1,sell2);
   }
}
