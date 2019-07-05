Given an array of N integers. Find the largest number.
O(N)

Find k largest numbers.
O(N logN)
N ~ hundred millions
k ~ a few thousands


O(N log k)   


Binary search
Given a sorted array of N unique integers. Find number q.
- If found, return the index of q
- If not found, return the index it would be if we insert q into the array.

[1, 3, 5]
q = 1 => 0
q = 3 => 1
q = 2 => 1
l=0,r=2,mid=1,r=0,mid=0,l=1, return l=1

[1]
q = 0 => 0
l=0,r=0,mid=0, r = -1, return l=0
q = 2 => 1
l=0,r=0,mid=0,l=1, return l=1

public int serach(int[] nums, int q){
    int mid;
    int l = 0, r = nums.length - 1;
    while (l <= r){
        mid = l + (r - l) / 2; // mid = l + (r - l) / 2
        if(nums[mid] == q) return mid;
        else if ( q < nums[mid] ) r = mid - 1;  //  q < nums[mid]
        else l = mid + 1;
    }
    return l;
}

Dictionary
Given a "blackbox" dictionary.
is_in_dict(s): true/false if string s is in dictionary

A step of transformation: A -> B by replacing a char of A by another char.
'dog' -> 'dot'
'house' -> 'mouse'

Given 2 strings, X and Y, which are in dictionary, find the shortest way (in term of number of steps) to transform X into Y, such that all intermediate strings are in dictionary.

assuming all lower case char 'a' - 'z'

Input: X, Y
Output: an array [X, A1, A2, A3, ... Y] or [] if impossible.

public String[] 
 1. Declare a hashmap,
 2. Choose String X, calculate the offset of each char vs. 'a'.  'b'-'a' = 1 . 'dog' = 4  // 'd'-'a' 'o'- ('d'-'a')
    Build a key base on that and put a {key=[],

dict [dog, dot, hot, hat]
X = dog
Y = hat


public List<String> search(String X, String Y){
     char[] xarray = X.toCharArray();
     List<String> re = new ArrayList<>();
     find(xarray, Y, re);
     return re;
}
     
     
public boolean find(char[] xarray, String Y, List<String> re){ 
     for(char ch:xarray){
         for(int i=0; i<26; i++){
             if(ch+i != ch){
                 ch = ch + i;
                 String ns = new String(xarray);
                 re.add(ns);
                 if(is_in_dict(ns) && ns.equals(Y) return true;
                 find(ns, re);
             }
         }
     }
}            



























