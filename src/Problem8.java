class MyTreeNode{
    int val;
    MyTreeNode parent,left,right;
    MyTreeNode(int val,MyTreeNode parent){
        this.val=val;
        this.parent = parent;
    }
}
public class Problem8{
    public MyTreeNode getNext(MyTreeNode node){
        if(node==null) return null;
        MyTreeNode ans = null;
        if(node.right!=null){
            MyTreeNode right = node.right;
            while (right.left!=null){
                right = right.left;
            }
            ans = right;
        }else if(node.parent!=null){
            MyTreeNode cur = node;
            MyTreeNode parent = node.parent;
            while (parent!=null&&parent.right==cur){
                cur = parent;
                parent = cur.parent;
            }
            ans = parent;
        }
        return ans;
    }
}
