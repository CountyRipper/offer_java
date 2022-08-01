public class lc654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buil(nums, 0, nums.length);
    }
    public TreeNode buil(int []nums,int start, int end){
        if(start>end) return null;
        if(start==end) return new TreeNode(nums[start]);
        else{
            int big = findbig(nums, start, end);
            TreeNode root = new TreeNode(nums[big]);
            root.right = buil(nums, start, big-1);
            root.left = buil(nums, big+1, end);
            return root;
        }
    }
    public int findbig(int []nums,int start, int end){
        int p=0;
        int v = Integer.MIN_VALUE;
        for( int i=start;i<=end;i++){
            if(v< nums[i]){
                v = nums[i];
                p = i;
            }
        }
        return p;
    }
}
