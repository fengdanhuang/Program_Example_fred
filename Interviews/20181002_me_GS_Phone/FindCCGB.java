
/*

Interviwer: HK (White Old Man)

Question 2:

Given a tree, find the closest common generelized boss.
The pointer is from low to high.
Follow up: resolve it in O(n) space, in 'depfth of binary tree' of time complexity.
    

      root
   /  /  \  \
  A  B   C   D
 /
O    ...
*/


/*
Two methods offered by the interviwer:

Method 1. 
User one HashSet.
One node u and all ancestry into a HashSet.
Loop over another node v and all ancestors, check whether this node is existed in the HashSet.


Method 2.
1. Get the depth of node u, v,
   for instance, depth(u) = 3, depth(v) = 5.
2. If depth(u) = depth(v), compare ancestors by level, and going up.
3. If depth(u)(=3) != depth(v)(=5), first going up to two level for v, then 
   compare u and v level by level.
*/

public class FindCCGB{


    public void findClosestCommonGeneralizedBoss(TreeNode root){
    }

    public static void main(String[] args){

    }
}

