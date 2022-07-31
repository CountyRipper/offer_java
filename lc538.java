public class lc538 {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root!= null){
            convertBST(root.right);
            sum+=root.val;
            root.val = sum;
            convertBST(root.left);
        }
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