import java.util.ArrayList;
import java.util.List;

public class lc257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        DFS(root, " ", res);
        return res;
    }
    public static void DFS(TreeNode root, String path, List<String> res){
        if (root==null){
            return;
        }
        StringBuffer path_cur = new StringBuffer(path);
        path_cur.append(String.valueOf(root.val));
        if (root.left==null&&root.right==null){
            res.add(path_cur.toString());
            //return;
        }
        else{
            path_cur.append("->");
            DFS(root.left, path_cur.toString(), res);
            DFS(root.right, path_cur.toString(), res);
            //path = path.substring(0,path.length())
        }
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
