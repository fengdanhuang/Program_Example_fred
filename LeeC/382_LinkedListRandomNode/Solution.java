


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class Solution {
    
    ListNode head;
    Random random;
    
    public Solution(ListNode h) {
        head = h;       
        random = new Random();        
    }
    
    public int getRandom() {
        
        ListNode c = head;
        int r = c.val;
        for(int i=1;c.next != null;i++){
            
            c = c.next;
            if(random.nextInt(i + 1) == i) r = c.val;                        
        }
        
        return r;
    }
    
}

class Test{
 
    //Your Solution object will be instantiated and called as such:
    public static void main(String args[]){
	ListNode head = new ListNode(1);
	head.next = new ListNode(2);
	head.next.next = new ListNode(3);
 
        Solution obj = new Solution(head);
        int param_1 = obj.getRandom();
    }

}
