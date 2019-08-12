

/*
#
# Determine whether the input string 's' matches the given pattern. Most characters in
# the pattern only match themselves in the input (i.e., 'A' in the pattern can only match
# 'A' in the input. However, there is one special character '*', which can match any number 
# of characters (including zero). Think of the 'dir' command in Windows or the 'ls' command
# in Unix

"a*****b*c*d"      "abxxxxcd"           True
ls a*b.csv          acb.csv          True
ls a*bc.csv         ab.csv           False

*/


import java.io.*;
import java.util.*;



class PatternMatch {
  /*
  public boolean isPattern(String pattern, String input){
    if(input == null && pattern == null) return true;
    if(input == null || pattern == null) return false;
    int i = 0;
    int j = 0;
    while(i < pattern.length() && j < input.length()){
      while (pattern.charAt(i) == '*') i++;
      if(pattern.charAt(i) != input.charAt(j)) return false;
      else{i++; j++;}  
    }
    return true;
    
  }*/
  public boolean isPattern(String pattern, String input){
    if(input == null && pattern == null) return true;
    if(input == null || pattern == null) return false;
    String[] pp = pattern.split("\\*+");
    int[] index = new int[pp.length];
    for(int i=0; i< pp.length; i++){
      if(input.indexOf(pp[i]) == -1) return false;
      else index[i] = input.indexOf(pp[i]);
    }
    for(int i=1; i< pp.length; i++){
      if (index[i-1] >= index[i]) return false;
    }
    return true;
  }
  
  public static void main(String[] args) {
    
    Solution s = new Solution();
    String p = "a*****b*c*d";
    String i = "abxxxxcd";
    System.out.println(s.isPattern(p, i));
  }
}