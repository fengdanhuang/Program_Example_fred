
import java.util.*;


class Solution {
    
    public boolean validWordSquare(List<String> words) {
        
        int height = words.size();
        
        if (height==0) return false;
        
        int width = words.get(0).length();
        
        if (height!=width) return false;
        
        char[][] square = new char[height][width];
        
        for (int i=0; i<height; i++) {
            int j=0;
            for (char c: words.get(i).toCharArray()) {
                if (j==width) return false;
                square[i][j++]=c;
            }
        }
        
        for (int i=1; i<width; i++) {
            for (int j=0; j<i; j++) {
                if (square[i][j] != square[j][i]) return false;
            }
        }
        
        return true;
    }

}
