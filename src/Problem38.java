/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root==null){
            sb.append('$');
            return sb.toString();
        }else{
            sb.append((char)('0'+root.val));
            sb.append(Serialize(root.left));
            sb.append(Serialize(root.right));
        }
         return sb.toString();
       
        
  }
    int index = -1;
    TreeNode Deserialize(String str) {
       index++;
        if(index>=str.length()){
           return null;
       }else{
           if(str.charAt(index)=='$'){
               return null;
           }else{
               TreeNode node = new TreeNode((int)(str.charAt(index)-'0'));
               node.left = Deserialize(str);
               node.right = Deserialize(str);
               return node;
           }
           
       }
  }
}