public class lc450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null) return root;
        // find the treenode
        if(root.val<key) root.right = deleteNode(root.right, key);
        else if(root.val>key) root.left = deleteNode(root.left, key);
        else{
            //found this node
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            TreeNode cur = root.right;//find the most left position in right
            
            while(cur.left!=null){
                
                cur = cur.left;
            }
            cur.left = root.left;
            root=root.right;
        }
        return root;
    }
}

