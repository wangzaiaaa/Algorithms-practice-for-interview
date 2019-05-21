/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root1, TreeNode root2) {
        boolean res = false;
        if(root1!=null && root2!=null){
            if(root1.val==root2.val){
                res = DoesTree1HaveTree2(root1,root2);
            }
            if (!res){
                res = isSubtree(root1.left,root2);
            }
            if(!res){
                res = isSubtree(root1.right,root2);
            }
        }
        return res;     
    }
    boolean DoesTree1HaveTree2(TreeNode root1,TreeNode root2){
        if(root1==null&&root2==null){
            return true;
        }
       
        if(root1==null||root2==null){
            return false;
        }
        
        if(root1.val==root2.val){
            return DoesTree1HaveTree2(root1.left,root2.left)&&DoesTree1HaveTree2(root1.right,root2.right);
        }
        return false;
    }
}