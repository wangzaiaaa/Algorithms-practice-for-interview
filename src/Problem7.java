//重建二叉树

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem7 {

    public static void main(String[] args) {
        int [] pre = {1,2,4,7,3,5,6,8};
        int [] in = {4,7,2,1,5,3,8,6};
        TreeNode root = reConstruct(pre,in);
        LevelTraversal(root);

    }

    /***********
     *
     * @param preorder 先序遍历的序列
     * @param ps       先序序列的起始
     * @param pe       先序序列的终止
     * @param inorder  中序遍历的序列
     * @param is       中序序列的起始
     * @param ie       中序序列的终止
     * @return
     */
    private static TreeNode Construct(int [] preorder,int ps,int pe,int [] inorder,int is,int ie){
        if(ps>pe) return null;
        int index = is;
        while(index<=ie&&inorder[index]!=preorder[ps]) index++;
        if(index>ie)throw new RuntimeException("invalid input");
        TreeNode node = new TreeNode(preorder[ps]);
        node.left = Construct(preorder,ps+1,ps+index-is,inorder,is,index-1);
        node.right = Construct(preorder,ps+index-is+1,pe,inorder,index+1,ie);
        return node;
    }
    private static TreeNode reConstruct(int [] pre,int [] in){
        if(pre==null||in==null||pre.length!=in.length) return null;
        return Construct(pre,0,pre.length-1,in,0,in.length-1);

    }
    public static void LevelTraversal(TreeNode root){
        if(root==null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        TreeNode temp = null;
        while (!queue.isEmpty()){
            temp = queue.poll();
            list.add(temp.val);
            if(temp.left!=null) queue.offer(temp.left);
            if(temp.right!=null) queue.offer(temp.right);
        }
        for(Integer i:list){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
