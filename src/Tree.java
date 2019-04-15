import com.sun.source.tree.Tree;

import java.util.*;


//附上leetcode上我刷过的关于树的一些代码和树的基本操作
class TreeNode{
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode(Integer i){
        this.val = i;
    }
}
public class Problem7 {
    public static void main(String[] args) {
        Integer [] test = {1,2,3,null,4,5,9};
        TreeNode root = generateBinaryTree(test);
        preorderTraversalByRecursion(root);
        System.out.println();
        preorderTraversalByIteration(root);
        System.out.println();
        inorderTraversalByCursion(root);
        System.out.println();
        inorderTraversalByInteation(root);
        postOrderTraversalByCursion(root);
        System.out.println();
        postOrderTraversalByInteration(root);


    }
    /*--------------------------------生成二叉树------------------------------------*/
    public static TreeNode generateBinaryTree(Integer [] array){
        TreeNode root = new TreeNode(0);
        if(array==null||array.length<1||array[0]==null) return root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int curinex = 0,constrant=1;
        TreeNode temp = null;
        while (curinex<array.length&&!queue.isEmpty()){
            temp = queue.poll();
            temp.val = array[curinex++];
            if(temp.val!=null){
                TreeNode left = new TreeNode(0);
                constrant++;
                if(constrant<=array.length){
                    temp.left = left;
                    queue.offer(left);
                }
                TreeNode right = new TreeNode(0);
                constrant++;
                if(constrant<=array.length){
                    temp.right = right;
                    queue.offer(right);
                }
            }
        }
        return root;
    }

    /*--------------------------------生成二叉树------------------------------------*/

    /*--------------------------------二叉树的先序遍历------------------------------------*/
    //二叉树的先序遍历的递归实现
    public static void preorderTraversalByRecursion(TreeNode root){
        if(root!=null){
            System.out.print(root.val+" ");
            preorderTraversalByRecursion(root.left);
            preorderTraversalByRecursion(root.right);
        }
    }

    public static void preorderTraversalByIteration(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        if(root!=null){
            stack.push(root);
            TreeNode temp = null;
            while(!stack.isEmpty()){
                temp = stack.pop();
                System.out.print(temp.val+" ");
                if(temp.right!=null) stack.push(temp.right);
                if(temp.left!=null) stack.push(temp.left);
            }
        }
    }
    /*--------------------------------二叉树的先序遍历------------------------------------*/



    /*--------------------------------二叉树的中序遍历------------------------------------*/
    public static void inorderTraversalByCursion(TreeNode root){
        if(root!=null){
            inorderTraversalByCursion(root.left);
            System.out.print(root.val+" ");
            inorderTraversalByCursion(root.right);
        }
    }

    public static void inorderTraversalByInteation(TreeNode root){
        if(root==null) return;
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        TreeNode cur = root,temp = null;
        while(cur!=null||!stack.isEmpty()){
            while (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }
            temp = stack.pop();
            arrayList.add(temp.val);
            cur = temp.right;
        }
        for(Integer i: arrayList){
            System.out.print(i+" ");
        }
        System.out.println();

    }

    /*--------------------------------二叉树的中序遍历------------------------------------*/


    /*--------------------------------二叉树的后序遍历------------------------------------*/

    public static void postOrderTraversalByCursion(TreeNode root){
        if(root!=null){
            postOrderTraversalByCursion(root.left);
            postOrderTraversalByCursion(root.right);
            System.out.print(root.val+" ");
        }
    }

    public static void postOrderTraversalByInteration(TreeNode root){
        if(root==null) return;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode temp = null;
        while (!stack.isEmpty()){
            temp = stack.pop();
            arrayList.add(temp.val);
            if(temp.left!=null) stack.push(temp.left);
            if(temp.right!=null) stack.push(temp.right);
        }
        Collections.reverse(arrayList);
        for(Integer i:arrayList){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    /*--------------------------------二叉树的后序遍历------------------------------------*/


    /*--------------------------------leetcode100相同的树------------------------------------*/

    public static boolean  isSameTree(TreeNode p, TreeNode q) {
        if(p==null&&q==null) return true;
        else if((p!=null&&q==null)||(p==null&&q!=null)) return false;
        else{
            if(p.val!=q.val) return false;
            return isSameTree(p.left,q.left)&&isSameTree(q.right,p.right);
        }
    }

    /*--------------------------------leetcode100相同的树------------------------------------*/



    /*--------------------------------leetcode101对称的二叉树------------------------------------*/

    public static  boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    /*--------------------------------leetcode101对称的二叉树------------------------------------*/





    /*--------------------------------leetcode102二叉树的层次遍历------------------------------------*/

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return answer;
        queue.offer(root);
        queue.offer(null);
        List<Integer> temp = new ArrayList<>();
        TreeNode tempNode = null;
        while(!queue.isEmpty()){
            tempNode = queue.poll();
            if(tempNode==null){
                answer.add(temp);
                if(queue.size()>0) queue.offer(null);
                temp = new ArrayList<>();
            }else{
                temp.add(tempNode.val);
                if(tempNode.left!=null) queue.offer(tempNode.left);
                if(tempNode.right!=null) queue.offer(tempNode.right);

            }
        }
        return answer;

    }

    /*--------------------------------leetcode102二叉树的层次遍历------------------------------------*/





    /*--------------------------------leetcode104二叉树的最大深度------------------------------------*/

    public static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right)+1);
    }

    /*--------------------------------leetcode104二叉树的最大深度------------------------------------*/



    /*--------------------------------leetcode111二叉树的最小深度------------------------------------*/

    public static int minDepth(TreeNode root) {
        if(root==null) return 0;
        else if(root.left==null&&root.right==null) return 1;
        else if(root.left==null) return minDepth(root.right)+1;
        else if(root.right==null) return minDepth(root.left)+1;
        else return Math.min(1+minDepth(root.left),1+minDepth(root.right));
    }

    /*--------------------------------leetcode111二叉树的最小深度------------------------------------*/




    /*--------------------------------leetcode111路径总和------------------------------------*/

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        if(root.val==sum&&root.left==null&&root.right==null) return true;
        return (hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val));
    }

    /*--------------------------------leetcode111路径总和------------------------------------*/



    /*--------------------------------leetcode114二叉树展开为链表------------------------------------*/

    public static void flatten(TreeNode root) {
        if(root==null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode answer = root,temp=null;
        if(root.right!=null) stack.push(root.right);
        if(root.left!=null) stack.push(root.left);
        while(!stack.isEmpty()){
            temp = stack.pop();
            if(temp.right!=null) stack.push(temp.right);
            if(temp.left!=null) stack.push(temp.left);
            root.right = temp;
            root.left=null;
            root = root.right;
        }
        root = answer;

    }

    /*--------------------------------leetcode114二叉树展开为链表------------------------------------*/


    /*--------------------------------leetcode129求根到叶子节点数字之和------------------------------------*/

    public  int sumNumbers(TreeNode root) {
        return sumNumbers(root,"");
    }
    public int sumNumbers(TreeNode root,String cur){
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return Integer.valueOf(cur+(char)(48+(root.val)));
        if(root.left==null) return sumNumbers(root.right,cur+(char)(root.val+48));
        if(root.right==null) return sumNumbers(root.left,cur+(char)(root.val+48));
        return sumNumbers(root.left,cur+(char)(root.val+48))+sumNumbers(root.right,cur+(char)(root.val+48));

    }

    /*--------------------------------leetcode129求根到叶子节点数字之和------------------------------------*/





    /*--------------------------------leetcode222完全二叉树的节点个数------------------------------------*/

    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    /*--------------------------------leetcode222完全二叉树的节点个数------------------------------------*/


    /*--------------------------------leetcode226翻转二叉树------------------------------------*/

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /*--------------------------------leetcode226翻转二叉树------------------------------------*/



    /*--------------------------------leetcode257二叉树的所有路径------------------------------------*/

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if(root==null) return answer;
        addToList(root,answer,"");
        return answer;
    }
    public static void addToList(TreeNode node,List<String> list,String cur){
        if(node.right!=null&&node.left!=null){
            addToList(node.right,list,cur+String.valueOf(node.val)+"->");
            addToList(node.left,list,cur+String.valueOf(node.val)+"->");
        }else if(node.left==null&&node.right==null) {
            list.add(cur+String.valueOf(node.val));
        }else if(node.left==null){
            addToList(node.right,list,cur+String.valueOf(node.val)+"->");
        }else{
            addToList(node.left,list,cur+String.valueOf(node.val)+"->");
        }
    }


    /*--------------------------------leetcode257二叉树的所有路径------------------------------------*/


    /*--------------------------------leetcode404左叶子之和------------------------------------*/
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int answer = 0;
        TreeNode roottemp,lefttemp;
        while(!queue.isEmpty()){
            roottemp = queue.poll();
            if(roottemp.left!=null){
                lefttemp=roottemp.left;
                if(lefttemp.left==null&&lefttemp.right==null) answer +=lefttemp.val;
                queue.offer(lefttemp);
            }
            if(roottemp.right!=null){
                queue.offer(roottemp.right);
            }

        }
        return answer;

    }

    /*--------------------------------leetcode404左叶子之和------------------------------------*/


    /*--------------------------------leetcode515在每个树行中找最大值------------------------------------*/

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> answer= new ArrayList<>();
        if(root==null) return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        Integer temp = Integer.MIN_VALUE;
        TreeNode node = null;
        while(!queue.isEmpty()){
            node = queue.poll();
            if(node!=null){
                if(node.val>temp) temp = node.val;
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }else{
                answer.add(temp);
                temp = Integer.MIN_VALUE;
                if(queue.size()>=1){
                    queue.offer(null);
                }
            }

        }
        return answer;
    }

    /*--------------------------------leetcode515在每个树行中找最大值------------------------------------*/



    /*--------------------------------leetcode637二叉树的层平均值------------------------------------*/

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        if(root==null) return answer;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int count = 0;
        double avl = 0,sum=0;
        TreeNode temp = null;
        while(!queue.isEmpty()){
            temp = queue.poll();
            if(temp==null){
                avl = sum/count;
                answer.add(avl);
                if(queue.size()>0){
                    sum = 0;
                    count = 0;
                    queue.offer(null);
                }
            }else{
                count++;
                sum += temp.val;
                if(temp.left!=null) queue.offer(temp.left);
                if(temp.right!=null) queue.offer(temp.right);
            }
        }
        return answer;
    }

    /*--------------------------------leetcode637二叉树的层平均值------------------------------------*/

}
