import java.util.LinkedList;
import java.util.Queue;

/**
 * @author bonsoirzw 
 * @date 2019/5/25
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}
public class Problem32 {
    void PrintFromTopToBottom(TreeNode root){
        if(root==null){
            return;
        }else{
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            TreeNode temp = null;
            while (!queue.isEmpty()){
                temp = queue.poll();
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
                System.out.print(temp.val + " ");
            }
        }
    }
}