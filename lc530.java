public class lc530 {
    int ans,pre;
    public int getMinimumDifference(TreeNode root) {
        if(root==null) return 0;
        ans = Integer.MAX_VALUE;
        pre = -1;
        midbacktrack(root);
        return ans;
    }
    public void midbacktrack(TreeNode root){
        if(root == null) return;
        midbacktrack(root.left);
        if(pre != -1){
            ans = Math.min(ans, root.val-pre);
            pre = root.val;
        }
        pre = root.val;
        midbacktrack(root.right);
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
