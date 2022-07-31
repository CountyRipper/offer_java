
public class lc236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root ==p || root == q){
            return root;
        }
        TreeNode leftnode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        if(leftnode==null){
            return rightNode; //没找到左，找到右
        }
        else if(rightNode==null){
            return leftnode;    //没找到右，找到了左
        }
        else return root; //找到了
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
