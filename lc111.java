public class lc111 {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.right==null&&root.left==null) return 1;
        int m1 = minDepth(root.left);
        int m2 = minDepth(root.right);
        if(m1==0)return m2+1;
        if(m2==0) return m1+1;
        else{
            return Math.min(m1, m2)+1;
        }
    }
}