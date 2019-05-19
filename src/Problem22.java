/**
 * @author bonsoirzw
 * @date 2019/5/19
 * 链表中的倒数第k个结点
 */

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }
}
public class Problem22 {
    ListNode findKthNodeToTail(ListNode head,int k){
        if(head==null||k<=0){
            return null;
        }else{
            ListNode ahead = head;
            ListNode behind = null;
            for(int i=0;i<k-1;i++){
                if(ahead.next!=null){
                    ahead = ahead.next;
                }else{
                    return null;
                }
            }
            behind = head;
            while (ahead.next!=null){
                ahead = ahead.next;
                behind = behind.next;
            }
            return behind;
        }

    }
    ListNode generateListNode(int [] array){
        if(array==null||array.length<1){
            return null;
        }else{
            ListNode head = new ListNode(array[0]);
            ListNode cur = head;
            for(int i=1;i<array.length;i++){
                cur.next = new ListNode(array[i]);
                cur = cur.next;
            }
            return head;
        }
    }
    public static void main(String[] args) {
        int []  array = {1,2,3,4,5};
        Problem22 problem22 = new Problem22();
        ListNode head = problem22.generateListNode(array);
        System.out.println(problem22.findKthNodeToTail(head,0));
        System.out.println(problem22.findKthNodeToTail(head,1).val);
        System.out.println(problem22.findKthNodeToTail(head,2).val);
        System.out.println(problem22.findKthNodeToTail(head,3).val);
        System.out.println(problem22.findKthNodeToTail(head,4).val);
        System.out.println(problem22.findKthNodeToTail(head,5).val);

    }

}