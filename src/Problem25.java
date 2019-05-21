/**
 * @author bonsoirzw
 * @date 2019/5/21
 * 合并2个有序的链表
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
public class Problem25 {
    ListNode mergeTwoList(ListNode head1,ListNode head2){
        if(head1==null){
            return head2;
        }
        else if(head2==null){
            return head1;
        }
        ListNode head = null;
        if(head1.val<head2.val){
            head = head1;
            head.next = mergeTwoList(head1.next,head2);
        }else{
            head = head2;
            head.next = mergeTwoList(head1,head2.next);
        }
        return head;
    }

    ListNode generateList(int [] array){
        if(array==null||array.length<1){
            return null;
        }else{
            ListNode head = new ListNode(array[0]);
            ListNode temp = head;
            for(int i=1;i<array.length;i++){
                temp.next = new ListNode(array[i]);
                temp = temp.next;
            }
            return head;
        }
    }
    public static void main(String[] args) {
        Problem25 problem25 = new Problem25();
        int [] array1 = {3,5,7};
        int [] array2 = {1,2,6,8};
        ListNode head1 = problem25.generateList(array1);
        ListNode head2 = problem25.generateList(array2);
        ListNode head = problem25.mergeTwoList(head1,head2);
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}