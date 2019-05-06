
//删除链表中的一个节点
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
public class Problem18 {
    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        ListNode temp = test;
        for(int i=1;i<9;i++){
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        temp.next = new ListNode(9);


        DeleteNode(test,test);
        while (test!=null){
            System.out.print(test.val + " ");
            test = test.next;
        }

    }
    static void DeleteNode(ListNode head,ListNode nodeToBeDel){
        if(head==null||nodeToBeDel==null) return;
        if(nodeToBeDel.next!=null){
            ListNode temp = nodeToBeDel.next;
            nodeToBeDel.val = temp.val;
            nodeToBeDel.next = temp.next;
            temp = nodeToBeDel;
        }else if(head==nodeToBeDel){
            head = null;
        }else{
            ListNode temp = head;
            while (temp.next!=null){
                temp = temp.next;
            }
            temp = null;
        }
    }
    static void DeleteDuplication(ListNode head){
        if(head==null) return;
        ListNode preNode = null,node = head,next = null,nodeToBeDel=null;
        boolean needDelete = false;
        while (node!=null){
            next = node.next;
            needDelete = false;
            if(next!=null&&next.val==node.val) needDelete = true;
            if(!needDelete){
                preNode = node;
                node = node.next;
            }else{
                int val = node.val;
                nodeToBeDel = node;
                while (nodeToBeDel!=null&&nodeToBeDel.val==val){
                    next = nodeToBeDel.next;
                    nodeToBeDel = null;
                    nodeToBeDel = next;
                }
                if(preNode==null) head = next;
                else preNode.next = next;
                node = next;
            }
        }
    }
}