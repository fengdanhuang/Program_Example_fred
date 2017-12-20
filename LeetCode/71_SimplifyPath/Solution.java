
import java.util.*;

class Solution {

    	public static String simplifyPath(String path) {
    
		Deque<String> stack = new LinkedList<>();
    		
		Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
   		
		System.out.println("skip = " + skip);
		 
		for (String dir : path.split("/")) {
       			System.out.println("dir = " + dir); 
			if (dir.equals("..") && !stack.isEmpty()) stack.pop();
        		else if (!skip.contains(dir)) stack.push(dir);
    		
		}	
		
		System.out.println("stack = " + stack);
    		
		String res = "";
    		
		for (String dir : stack) res = "/" + dir + res;
    		
		return res.isEmpty() ? "/" : res;
	}


	public static void main(String args[]){
		
		System.out.println("/home/ =>" + simplifyPath("/home/"));
		System.out.println("/a/./b/../../c/ =>" + simplifyPath("/a/./b/../../c/"));
		System.out.println("/a/./b/../../../c/ =>" + simplifyPath("/a/./b/../../../c/"));
		System.out.println("/a/./../b/../../../c/ =>" + simplifyPath("/a/./../b/../../../c/"));
		System.out.println("/a///b///// =>" + simplifyPath("/a///b/////"));
		System.out.println("/a///b////../ =>" + simplifyPath("/a///b////../"));
		System.out.println("/a///b////./ =>" + simplifyPath("/a///b////./"));
		System.out.println("/a///b//../../../ =>" + simplifyPath("/a///b//../../../"));
	}
}
