public class lc509 {
    public int fib(int n) {
        // if(n==0) return 0;
        // else if(n==1) return 1;
        // else return fib(n-1)+fib(n-2);
        int []dp = new int[n+1];
        dp[0]=0;
        for(int i = 1 ; i<n+1;i++){
            if(i==1) dp[i] = 1;
            else dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
