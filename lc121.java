public class lc121 {
    public int maxProfit(int[] prices) {
        //也有dp思想，通过记录最小值来方便计算
        // 因为之前出现的最大值无用，最小值之后的最大值才有用
        int minprice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minprice){
                minprice= prices[i];
            }
            else if((prices[i] - minprice)>maxProfit){
                maxProfit = (prices[i] - minprice);
            }
        }
        return maxProfit;
    }
}
