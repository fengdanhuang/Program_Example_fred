
import java.util.*;


class Solution {
    
    public static double[] calcEquation(String[][] equations, double[] values, String[][] query) {
        for(int i=0; i<equations.length; i++){
            for(int j=0; j<equations[0].length; j++){
                System.out.print(equations[i][j] + "  ");
            }
            System.out.println();       
        }

        for(int i=0; i<values.length; i++)
            System.out.print(values[i] + "  ");
        System.out.println();

        for(int i=0; i<query.length; i++){
            for(int j=0; j<query[0].length; j++){
                System.out.print(query[i][j] + "  ");
            }
            System.out.println();
        }
 
        Map<String, Map<String, Double>> numMap = new HashMap<>();
        
        int i = 0;
        
        for(String[] str : equations) {
            insertPairs(numMap, str[0], str[1], values[i]);
            insertPairs(numMap, str[1], str[0], 1.0/values[i]);
            i++;
        }

        double[] res = new double[query.length];
        i = 0;
        for(String[] q: query) {
            Double resObj = handleQuery(q[0], q[1], numMap, new HashSet<>());
            res[i++] = (resObj != null) ? resObj : -1.0;
        }

        for(int k=0; k<res.length; k++)
            System.out.print(res[k] + "  ");
         System.out.println();
        return res;
    }

    public static void insertPairs(Map<String, Map<String, Double>> numMap, String num, String denom, Double value) {
        
        Map<String, Double> denomMap = numMap.get(num);
        if(denomMap == null) {
            denomMap = new HashMap<>();
            numMap.put(num, denomMap);
        }
        denomMap.put(denom, value);
    }
    

    public static Double handleQuery(String num, String denom, Map<String, Map<String, Double>> numMap, Set<String> visitedSet) {
        
        String dupeKey = num+":"+denom;
        if(visitedSet.contains(dupeKey)) return null;
        if(!numMap.containsKey(num) || !numMap.containsKey(denom)) return null;
        if(num.equals(denom)) return 1.0;

        Map<String, Double> denomMap = numMap.get(num);
        visitedSet.add(dupeKey);
        for(String key : denomMap.keySet()) {
            Double res = handleQuery(key, denom, numMap, visitedSet);
            if(res != null) {
                return denomMap.get(key) * res;
            }
        }
        visitedSet.remove(dupeKey);
        return null;
    }


    public static void main(String args[]){
        Solution s1 = new Solution();

	String[][] equations = {{"a", "b"}, {"b", "c"}};
        double[] values = {2.0, 3.0};
        String[][] query = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
        s1.calcEquation(equations, values, query);
    }
}
