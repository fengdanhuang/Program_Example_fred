


/* 
Your previous Plain Text content is preserved below:

Write a function that takes an unsorted list of arbitrary length N and an integer K (K < N), and returns the (K+1)th smallest element in the list. So, for example, if K is 0, then you'd return the smallest number, if K is 1, you'd return the second smallest value, etc.

The function must run in O(N). In other words, sorting the list first is not a viable solution. However, use this hint: think of how Quicksort works.

       0  2       1
[7, 8, 2, 5, 100, 3, 6], K=2

Follow up 0: What is the time and space complexity of your implementation?

Follow up 1: What if there is no priority queue implemented inside Java. How to you implement a heap?


 */


import java.io.*;
import java.util.*;


class KthSmallestNumer {

  public int findKthSmallest(int[] nums, int k){
    PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> (n2-n1));
    for(int n : nums){
      heap.add(n);
      if(heap.size() > k) heap.poll();
    }
    return heap.poll();
  }

  public static void main(String[] args) {
    
    Solution s = new Solution();
    
    int[] nums = new int[]{7, 8, 2, 5, 100, 3, 6};
    int k = 2;
    System.out.println(s.findKthSmallest(nums, k+1));

  }
}