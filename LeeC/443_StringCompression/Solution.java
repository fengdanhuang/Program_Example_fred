



class Solution {
    
    public int compress(char[] chars) {
    
        for(int i=0; i<chars.length; i++)
            System.out.print(chars[i] + "  ");
        System.out.println();
    
        int count = 1;
        int index = 1;
        
        for(int i = 1 ; i < chars.length ; i++) {
            
            if(chars[i] == chars[i-1]) {
                count++;
            }else{
                
                if(count == 1) {
                    chars[index] = chars[i];
                    index++;
                }else{
                    int mod = count % 10;
                    int ten = (count-mod) / 10;
                    if(ten > 0){                      
                        chars[index++] = (char)(48+ten);
                    }
                    chars[index++] = (char)(48+mod);
                    chars[index++] = chars[i];
                    count = 1;                                        
                } 
                
            }
            
        }
        
        if(count != 1) {
            
            int mod = count % 10;
            int ten = (count-mod) / 10;
            if(ten > 0){                      
                chars[index++] = (char)(48+ten);
            }
            
            chars[index++] = (char)(48+mod);
            
        }
        
        System.out.println("index = " + index + "\n"); 
        return index;
    }


    public static void main(String args[]){
        Solution s = new Solution();

        char[] ch = new char[]{'a','a','b','b','c','c','c'};
        s.compress(ch);

        ch = new char[]{'a'};
        s.compress(ch);

        ch = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        s.compress(ch);
       
    }
}
