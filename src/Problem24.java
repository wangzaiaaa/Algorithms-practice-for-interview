class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
public class Problem24 {
    static ListNode reverseList(ListNode head){
        if(head==null||head.next==null) return null;
        ListNode res = null,curNode=head;
        ListNode preNode = null;
        while (curNode!=null){
            ListNode next = curNode.next;
            if(next==null) res = curNode;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode secNode = new ListNode(2);
        head.next = secNode;
        secNode.next = new ListNode(3);
        ListNode nullNode = reverseList(null);
        System.out.println(nullNode==null);
        ListNode res = reverseList(head);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
