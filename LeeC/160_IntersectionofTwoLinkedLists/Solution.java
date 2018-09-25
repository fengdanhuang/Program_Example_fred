


class ListNode {

    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
        next = null;
    }
}


class Solution {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        //boundary check
        if(headA == null || headB == null) return null;
    
        ListNode a = headA;
        ListNode b = headB;
    
        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
    	    //for the end of first iteration, just reset the pointer to the head of another linkedlist
            
            if(a==null) a = headB;
            else a = a.next;
            
            if(b==null) b = headA;
            else b = b.next;
        }
    
        return a;
    }

    public static void main(String args[]){
        Solution s = new Solution();

        ListNode headA=new ListNode(2);ListNode A2=new ListNode(3);ListNode A3=new ListNode(4);ListNode A4=new ListNode(1);ListNode A5=new ListNode(5);
        headA.next=A2;A2.next=A3;A3.next=A4;A4.next=A5;

        ListNode headB=new ListNode(11);ListNode B2=new ListNode(12);ListNode B3=new ListNode(13);ListNode B4=new ListNode(4);ListNode B5=new ListNode(1);ListNode B6=new ListNode(5);
        headB.next=B2;B2.next=B3;B3.next=B4;B4.next=B5;B5.next=B6;

        ListNode re = s.getIntersectionNode(headA, headB);
        if(re == null) System.out.println("re = " + re + "\n");
        else System.out.println("re.val = " + re.val + "\n");
    }
    
}
