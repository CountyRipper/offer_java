import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
 
public class lc199 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        List<Integer> l1 = rightSideView(root);
        System.out.println(l1);
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        LinkedList<TreeNode> q1 = new LinkedList<>();
        TreeNode cur = root;
        q1.add(cur);
        while(q1.isEmpty()==false){
            res.add(q1.getLast().val);
            int n = q1.size();
            for (int i = 0; i < n; i++) {
                cur = q1.getFirst();
                if(cur.left!=null){
                    q1.add(cur.left);
                }
                if(cur.right!=null){
                    q1.add(cur.right);
                }
                q1.removeFirst();
            }
        }
        return res;
    }
    
    //List l1 = new LinkedList<>();
    
}
