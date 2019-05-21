/**
 * @author bonsoirzw
 * @date 2019/5/21
 * 树的子结构
 */
class TreeNode{
    int val;
    TreeNode left,right;
    TreeNode(int val){
        this.val = val;
    }
}
public class Problem26 {
    boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1==null){
            return false;
        }

        if(root1.val!=root2.val) {
            return false;
        }
        return DoesTree1HaveTree2(root1.left,root2.left)&&DoesTree1HaveTree2(root1.right,root2.right);

    }
    boolean HasSubTree(TreeNode root1,TreeNode root2){
        boolean res = false;
        if(root1!=null&&root2!=null){
            if(root1.val==root2.val){
                res = DoesTree1HaveTree2(root1,root2);
            }
            if (!res){
                res = DoesTree1HaveTree2(root1.left,root2);
            }
            if(!res){
                res = DoesTree1HaveTree2(root1.right,root2);
            }
        }
        return res;
    }
}