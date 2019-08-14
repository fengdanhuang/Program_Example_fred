/*
Tao:
Write a class(data structure) including a key as String, count as Integer, and three methods.
1). incr() implements +1. 
2). decr() implements -1. 
3). setMaxCountKey() return the key with maximum Count.


The following is the Hash Map Solution.
setMaxCountKey() has O(n) time complexity.
*/

import java.util.*;

public class MaxCountKey{

    private Map<String,Integer> map = new HashMap<>();

    public void incr(String k){
        map.put(k, map.getOrDefault(k,0)+1);
    }
    public void decr(String k){
	if(!map.containsKey(k)) return;
        map.put(k, map.get(k)-1);
        if(map.get(k) < 0) map.remove(k);
    }
    public String setMaxCountKey(){
        int max = 0;
        String re = new String();
        for(String k:map.keySet()){
            int v = map.get(k);
            if(v > max){
                max = v;
                re = k;
            }
        }
        return re;
     }
     public void printMap(){
         System.out.println("map = " + map);
     }

     public static void main(String args[]){
         MaxCountKey obj = new MaxCountKey();
         
         String maxK = obj.setMaxCountKey();
         System.out.println("maxK = " + maxK); 
         
	 obj.incr("A");
         obj.incr("B");
         obj.incr("C");
         obj.incr("D");
         obj.incr("E");
         obj.incr("E");
         obj.incr("F");
         obj.incr("F");
         obj.printMap();
         
	 obj.decr("A");
         obj.decr("A");
         obj.decr("B");
         obj.printMap();

         maxK = obj.setMaxCountKey();
         System.out.println("maxK = " + maxK); 
    }
}
