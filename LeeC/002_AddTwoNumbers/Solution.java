
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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        
        int carry = 0;
        int sum = 0;
        int v1 = 0, v2 = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            
            ListNode cur = new ListNode(0);
            
            if(l1==null){
                v1 = 0;
            }else{
                v1 = l1.val;
                l1 = l1.next;
            }
            
            if(l2==null){
                v2 = 0;
            }else{
                v2 = l2.val;
                l2 = l2.next;
            }
                     
            sum = v1 + v2 + carry;  
            
            cur.val = sum % 10;
            carry = sum / 10;
            
            prev.next = cur;
            prev = cur;

        }
        return head.next;
    }

    public static void main(String argv[]){
        Solution s = new Solution();

        ListNode l1 = new ListNode(2);ListNode l1b = new ListNode(4);ListNode l1c = new ListNode(3);
        ListNode l2 = new ListNode(5);ListNode l2b = new ListNode(6);ListNode l2c = new ListNode(2);
        ListNode head = s.addTwoNumbers(l1, l2);
        s.printList(head);
        

    }
    
}
