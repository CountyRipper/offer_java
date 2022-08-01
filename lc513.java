import java.util.LinkedList;
import java.util.Queue;

public class lc513 {
    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode cur  = root;
        q.add(cur);
        while(!q.isEmpty()){
            res = q.peek().val;
            int n = q.size();
            for(int i=0;i<n;i++){
                cur = q.peek();
                if(cur.left!=null) q.add(cur.left);
                if(cur.right!=null) q.add(cur.right);
                q.poll();
            }
        }
        return res;
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
