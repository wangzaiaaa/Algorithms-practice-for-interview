import java.util.Stack;

//从尾到头打印链表
class ListNode{
    int val;
    ListNode next;
    ListNode(int i){
        this.val = i;
    }

}
public class Problem6 {

    //在链表的末尾添加一个节点
    public static void addToTail(ListNode head,ListNode node){
        if(head==null){
            head = node;
            return;
        }
        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = node;
    }
    //找到链表的第i个节点
    public static ListNode findIthListNode(ListNode head,int i){
        if(i<=0) throw new IllegalArgumentException("the arguement i must greater than zero ");
        if(head==null) throw new NullPointerException("head is null");
        if(i==1) return head;
        int target = 1;
        ListNode temp = head;
        while(temp!=null&&target!=i){
            temp = temp.next;
            target++;
        }
        return i==target ? temp:null;
    }
    //用栈实现逆序打印链表
    public static void reversinglyPrintListByStack(ListNode head){
        if (head==null) return;
        ListNode temp = head;
        Stack<Integer> stack = new Stack<>();
        while(temp!=null){
            stack.push(temp.val);
            temp = temp.next;
        }
        while (!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }
    //用递归实现逆序打印链表
    public static void reversingPrintListByRecursion(ListNode head){
         if(head!=null){
             if(head.next!=null){
                 reversingPrintListByRecursion(head.next);
             }
             System.out.print(head.val+" ");
         }
    }

    public static void main(String[] args) throws Exception{
        ListNode head = new ListNode(1);
        ListNode temp = head,add=null;
        for(int i=2;i<5;i++){
            add = new ListNode(i);
            temp.next = add;
            temp = temp.next;
        }
        System.out.println(findIthListNode(head,3).val);
        addToTail(head,new ListNode(10));
        reversingPrintListByRecursion(head);
        System.out.println();
        reversinglyPrintListByStack(head);
    }
}
