



class Solution {
    
    public boolean isNumber(String s) {
       
        System.out.println("s = " + s); 
        s=s.trim();

        int n=s.length();
        
        boolean isPoint=false;
        boolean isE=false;
        boolean isSign=false;
        boolean isNum=false;
       
        for(int i=0;i<n;i++){
            
            char ch=s.charAt(i);
            if(ch>=48 && ch<=57){
                isNum=true;
                continue;
            }
            if(!isE && isNum && ch=='e'){
                isE=true;
                isNum=false;
                isSign=false;
                continue;
            }
            if(!isPoint && !isE && ch=='.'){
                isPoint=true;
                //isNum=false;                          //"23." is a valid number
                continue;
            }
            if(!isSign && !isNum && (ch=='-' || ch=='+')){
                if(!isE && !isPoint){
                    isSign=true;
                    continue;
                }
                if(isE){
                    isSign=true;
                    continue;
                } else {
                    System.out.println("false\n");
                    return false;
                }
            }else{
                System.out.println("false\n");
                return false;
            }
        }
        if(isNum==false){
            System.out.println("false\n");
            return false;
        }
        System.out.println("true\n");
        return true;    
    }

    public static void main(String args[]){
        Solution s = new Solution();

        String str = "0";
        s.isNumber(str);

        str = "  0.1 ";
        s.isNumber(str);
        
        str = "abc";
        s.isNumber(str);
        
    }

}
