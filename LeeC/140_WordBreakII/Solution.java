


public class Solution {
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        return memDFS(s, wordDict, new HashMap<String, List<String>>());
    }
    
    private List<String> memDFS(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<>();
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (word.length() == s.length()) {
                    res.add(word);
                    continue;
                }
                List<String> subList = memDFS(s.substring(word.length()), wordDict, map);
                for (String sub : subList) {
                    res.add(word + " " + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
    
}
