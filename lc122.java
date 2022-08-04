public class lc122 {
    public int maxProfit(int[] prices) {
        int row = prices.length;
        int[][]dp = new int[row][2];
        dp[0][0]=0;//卖出
        dp[0][1]=-prices[0];//买入
        for(int i=1;i<row;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);//卖出
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);//买入？
        }
        return dp[row-1][0];//最后一定是卖出之后的
    }
}
