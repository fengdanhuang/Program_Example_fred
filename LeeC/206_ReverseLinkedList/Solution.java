



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}




class Solution {

    public void printList(ListNode head){
       
        ListNode l = head;
        while(l!=null){
            System.out.print(l.val);
            if(l.next!=null){
                System.out.print("->");
            }else{
                System.out.print("^");
            }
            l = l.next;
        }
        System.out.println("");
    }
 
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public static void main(String argv[]){
        
        Solution s = new Solution();

        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next=node2; node2.next=node3; node3.next=node4; node4.next=node5; node5.next=null;
        
        s.printList(head);
        s.reverseList(head);
        s.printList(node5);
    }
 
}
