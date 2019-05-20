/**
 * @author bonsoirzw
 * @date 2019/5/20
 * 链表中的环入口点
 */

public class Problem23 {
    /**
     * 找到快慢指针的相遇点，即环的入口点
     * @param head
     * @return
     */
    ListNode findMeetNode(ListNode head){
        if(head==null){
            return null;
        }else{
            ListNode slowNode = head.next;
            if(slowNode==null){
                return null;
            }else{
                ListNode fastNode = slowNode.next;
                while (slowNode!=null&&fastNode!=null){
                    if(slowNode==fastNode) return fastNode;
                    slowNode = slowNode.next;
                    fastNode = fastNode.next;
                    if(fastNode!=null){
                        fastNode = fastNode.next;
                    }
                }
                return null;
            }
        }
    }

    ListNode findEntryNodeOfLoop(ListNode head){
        ListNode meetingNode = findMeetNode(head);
        if(meetingNode==null) return null;
        int nodesOfLoop = 1;
        ListNode temp = meetingNode;
        while (temp.next!=meetingNode){
            nodesOfLoop++;
            temp = temp.next;
        }
        ListNode node1 = head;
        for(int i=0;i<nodesOfLoop;i++){
            node1 = node1.next;
        }
        ListNode node2 = head;
        while (node1!=node2){
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode secNode = new ListNode(2);
        head.next = secNode;
        ListNode lastNode = new ListNode(3);
        secNode.next = lastNode;
        lastNode.next = secNode;
        System.out.println(new Problem23().findEntryNodeOfLoop(head).val);
    }
}
