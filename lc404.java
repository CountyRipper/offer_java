public class lc404 {
    //两种情况，对于左子树，一种是左叶子节点，直接返回值，否则继续递归
    //第二是右子树，如果是叶子，就返回0，否则继续递归
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        else return DFS(root);
    }
    public static int DFS(TreeNode root){
        //if(root==null) return 0;
        int res=  0;
        if(root.left!=null){    
            if(isleaf(root.left)){
                res+=root.left.val;
            }
            else{
                res+=DFS(root.left);
            }
        }
        if(root.right!=null && isleaf(root.right)){
            res+=DFS(root.right);
        }
        return res;
    }
    public static boolean isleaf(TreeNode root){
        return (root.right==null && root.left==null);
    }
}
