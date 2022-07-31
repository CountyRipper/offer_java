public class lc108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        TreeNode root = split(0, n-1, nums);
        return root;
        
    }
    public static TreeNode split(int start,int end, int[]nums){
        if(start == end) return new TreeNode(nums[end]);
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = split(start, mid-1, nums);
        root.right = split(mid+1, end, nums);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
