


class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}



class Solution {
    
    public boolean hasCycle(ListNode head) {

        
    
        if (head == null || head.next == null) return false;
        
        ListNode slow = head;
        
        ListNode fast = head.next;
    
        while (slow != fast) {
            
            if (fast == null || fast.next == null)  return false;

            slow = slow.next;
            
            fast = fast.next.next;
        }
        
        return true;
    }

    public static void main(String args[]){
        Solution s = new Solution();

        ListNode head = new ListNode(-21);
        ListNode l2 = new ListNode(10);
        ListNode l3 = new ListNode(17);
        ListNode l4 = new ListNode(8);
        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(-21);

        head.next = l2; l2.next=l3;l3.next=l4;l4.next=l5;l5.next=l6;
        boolean re = s.hasCycle(head);
        System.out.println("re = " + re + "\n");
    }
}
