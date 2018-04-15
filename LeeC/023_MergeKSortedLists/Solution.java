import java.util.*;


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class Solution {
    
    public static ListNode mergeKLists(ListNode[] lists){
	ListNode l = lists[0];
	while (l!=null){
	    System.out.print(l.val + "->");
	    l = l.next; 
        }       
	System.out.println();
 
	l = lists[1];
	while (l!=null){
	    System.out.print(l.val + "->");
	    l = l.next; 
        }       
	System.out.println();
        
        
	ListNode re = partion(lists,0,lists.length-1);
	


	l = re;
	while (l!=null){
	    System.out.print(l.val + "->");
	    l = l.next;
	}
	System.out.println();
	return re;
    }

    public static ListNode partion(ListNode[] lists,int s,int e){
	System.out.println("  partition: s = " + s + ", e = " + e);       
 
        if(s==e)  return lists[s];
    
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else{
            return null;
        }
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
	
	if(l1==null) return l2;
        
	if(l2==null) return l1;
        
        System.out.println("    merge: l1.val = " + l1.val + ", l2.val = " + l2.val);
	if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }

    public static void main(String args[]){
	Solution s1 = new Solution();

	ListNode l1 = new ListNode(5); ListNode l1a = new ListNode(6); ListNode l1b = new ListNode(7);
	l1.next = l1a; l1a.next = l1b; 

	ListNode l2 = new ListNode(2); ListNode l2a = new ListNode(3); ListNode l2b = new ListNode(4);
        l2.next = l2a; l2a.next = l2b;
	
	ListNode[] lists = new ListNode[]{l1, l2};
	s1.mergeKLists(lists);

    }
}
