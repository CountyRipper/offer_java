import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
