
import java.util.*;


class Solution {
    
    public List<List<String>> groupStrings(String[] strings) {
	System.out.println();
        for(int i=0; i<strings.length; i++)
	    System.out.print(strings[i] + "  ");
	System.out.println();
	 
        List<List<String>> result = new ArrayList<List<String>>();
        
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for (String str : strings) {
            System.out.println("    str = " + str);   
	
	    System.out.println("    str.charAt(0) = " + str.charAt(0));

            int offset = str.charAt(0) - 'a';
	    System.out.println("    offset = " + offset);            

	    String key = "";
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }
	    System.out.println("    key = " + key);

            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                map.put(key, list);
            }
            map.get(key).add(str);
	    System.out.println("    map = " + map);
        }
        
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            Collections.sort(list);
            result.add(list);
        }
       
	System.out.println("map = " + map);	
	System.out.println("result = " + result + "\n"); 
        return result;
    }


    public static void main(String args[]){
	Solution s1 = new Solution();

	String[] s = new String[] {"abc","bcd","acef","xyz","az","ba","a","z"};
	s1.groupStrings(s);

    }
    

}
