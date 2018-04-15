


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}



class Solution{ 
    
    public ListNode plusOne(ListNode head) {
	ListNode p = head;
	while(p!=null){
	    System.out.print(p.val + " -> ");
	    p = p.next;        
	}
	System.out.println();

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;
        
        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        
        if (j.val != 9) {
            j.val++;
        } else {
            i.val++;
            i = i.next;
            while (i != null) {
                i.val = 0;
                i = i.next;
            }
        }
        
        if (dummy.val == 0) {
	    p = dummy.next;
	    while(p!=null){
	        System.out.print(p.val + " -> ");
	        p = p.next;        
	    } 
	    System.out.println();
            return dummy.next;
        }
       
	p = dummy;
	while(p!=null){
	    System.out.print(p.val + " -> ");
	    p = p.next;        
	} 
	System.out.println();
        return dummy;
    }

    
    public static void main(String args[]){
	Solution s1 = new Solution();
	
	ListNode[] l = new ListNode[]{new ListNode(1), new ListNode(2), new ListNode(3)};
	l[0].next = l[1]; l[1].next = l[2];
	s1.plusOne(l[0]);
	
	l = new ListNode[]{new ListNode(9), new ListNode(9), new ListNode(9)};
	l[0].next = l[1]; l[1].next = l[2];
	s1.plusOne(l[0]);
    }
    
}
