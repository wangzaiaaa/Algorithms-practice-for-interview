/**
 * @date 2019/5/29
 * @author bonsoirzw
 */

import java.util.HashMap;

class Node{
    int val;
    Node next = null;
    Node random = null;
    Node(int val){
        this.val = val;
    }
}
public class Problem35 {
    /*
    solution1
     */
    public Node Clone(Node head){
        if(head==null){
            return null;
        }else {
            HashMap<Node,Node> map = new HashMap<Node, Node>();
            Node node = head;
            Node res = new Node(node.val);
            Node temp = res;
            map.put(node,res);
            node = node.next;
            while (node!=null){
                temp.next = new Node(node.val);
                temp = temp.next;
                map.put(node,temp);
                node = node.next;
            }
            Node temhead1 = head;
            Node temhead2 = res;
            while (temhead1!=null){
                temhead2.random = map.get(temhead1.random);
                temhead1 = temhead1.next;
                temhead2 = temhead2.next;
            }
            return res;
        }
    }
    /*
    Solution2
     */
    void CloneNodes(Node head){
        Node pNode = head;
        while (pNode!=null){
            Node cloneNode = new Node(pNode.val);
            cloneNode.next = pNode.next;
            pNode.next = cloneNode;
            pNode = cloneNode.next;
        }
    }
    void ConnectSiblingNodes(Node head){
        Node pNode = head;
        while (pNode!=null){
            Node cloneNode = pNode.next;
            if (pNode.random!=null){
                cloneNode.random = pNode.random.next;
            }
            pNode = cloneNode.next;
        }
    }
    Node ReconnectNodes(Node head){
        Node pNode = head;
        Node cloneNode = null;
        Node cloneHead = null;
        if(pNode!=null){
            cloneHead = pNode.next;
            cloneNode = pNode.next;
            pNode.next = cloneNode.next;
            pNode = pNode.next;
        }
        while (pNode!=null){
            cloneNode.next = pNode.next;
            cloneNode = cloneNode.next;
            pNode.next = cloneNode.next;
            pNode = pNode.next;
        }
        return cloneHead;
    }
    public Node copyRandomList(Node head){
        CloneNodes(head);
        ConnectSiblingNodes(head);
        return ReconnectNodes(head);
    }

}