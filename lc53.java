public class lc53 {
    public int maxSubArray(int[] nums) {
        int pre = 0 ; int res = nums[0];
        for(int x:nums){
            pre = Math.max(pre, pre+x);
            res = Math.max(res, pre);
        }
        return res;
    }
}
