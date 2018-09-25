


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class Solution {

    public ListNode root;

    public boolean isPalindrome(ListNode head) {   
        root = head; 
        return (head == null) ? true : _isPalindrome(head);
    }

    public boolean _isPalindrome(ListNode head) {
    
        boolean flag = true;
    
        if (head.next != null) {
            flag = _isPalindrome(head.next);
        }
    
        if (flag && root.val == head.val) {
            root = root.next;
            return true;
        }
        return false;
    }
    
    public static void main(String args[]){
        Solution s = new Solution();

        ListNode head = new ListNode(1); ListNode l2 = new ListNode(2);
        s.isPalindrome(head);

        head = new ListNode(1); l2 = new ListNode(2); ListNode l3 = new ListNode(2); ListNode l4 = new ListNode(1);
        s.isPalindrome(head);
 
    }

}
