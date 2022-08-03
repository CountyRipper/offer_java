

public class lc222 {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int l=0 ,r = 0;
        TreeNode n = root.right;
        while(n!=null){
            r++;
            n=n.right;
        }
        n = root.left;
        while(n!=null){
            l++;
            n=n.left;
        }
        
        if(l==r){return  (int)Math.pow(l, r) ;}
        else{
            return countNodes(root.right)+countNodes(root.left)+1;
        }
    }    
}

