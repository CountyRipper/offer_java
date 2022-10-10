import java.util.HashMap;
import java.util.LinkedHashMap;

public class lc105 {
    public int[] preorder;
    //dic存储的是inorder的索引
    public HashMap<Integer,Integer> dic = new LinkedHashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for( int i=0;i<inorder.length;i++){
            dic.put(inorder[i],i);//注意顺序
        }
        return build(0,0,preorder.length-1);
    }
    public TreeNode build(int root, int left, int right){
        if(left>right) return null;
        TreeNode cur = new TreeNode(preorder[root]);
        int cur_index = dic.get(preorder[root]);//获取到在inorder的索引
        int left_r = cur_index-1; 
        int right_l = cur_index+1;
        cur.left = build(root+1,left,left_r);
        cur.right = build((cur_index-left)+root+1,right_l,right); //根节点索引 + 左子树长度 + 1
        return cur;
    }
}
