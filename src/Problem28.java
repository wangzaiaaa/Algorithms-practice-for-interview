/**
 * @author bonsoirzw 
 * @date 2019/5/21
 */
public class Problem28 {
    boolean isSymmetrical(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }
        if(root1==null||root2==null){
            return false;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return isSymmetrical(root1.left,root2.right)&&isSymmetrical(root1.right,root2.left);
    }
}