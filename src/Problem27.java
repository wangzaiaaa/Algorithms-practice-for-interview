/**
 * @author bonsoirzw
 * @date 2019/5/21
 * ¶þ²æÊ÷¾µÏñ
 */
class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val = val;
    }
}
public class Problem27 {
    void invertTree(TreeNode root){
        if(root==null){
            return;
        }else if(root.left==null&&root.right==null){
            return;
        }else{
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if(root.left!=null){
                invertTree(root.left);
            }
            if(root.right!=null){
                invertTree(root.right);
            }
        }
    }
}