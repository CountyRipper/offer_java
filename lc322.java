import java.util.Arrays;

public class lc322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Arrays.sort(coins);
        int res=0;
        for(int i=n-1;i>=0;i--){
            if(amount>=coins[i]){
                res+=(amount/coins[i]);
                amount=amount%coins[i];
            }
        }
        if(amount==0) return res;
        else return -1;
    }
}
