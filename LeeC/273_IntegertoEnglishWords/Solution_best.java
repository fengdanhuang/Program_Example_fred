


class Solution_best{
    
    private static final String[] tens={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    
    private static final String[] twenties={"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    
    private static final String[] hundreds={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    

    public String numberToWords(int num){
        
        if(num==0) return "Zero";
        
        String re = convert(num);
        System.out.println("re = " + re);
        return re;
    }

    private String convert(int num){
        
        String res="";
        
        if(num<10){
            res=tens[num];
        }else if(num<20){
            res=twenties[num-10];
        }else if(num<100){
            res=hundreds[num/10]+" "+convert(num%10);
        }else if(num<1000){
            res=convert(num/100)+" Hundred "+convert(num%100);
        }else if(num<1000000){
            res=convert(num/1000)+" Thousand "+convert(num%1000);
        }else if(num<1000000000){
            res=convert(num/1000000)+" Million "+convert(num%1000000);
        }else{
            res=convert(num/1000000000)+" Billion "+convert(num%1000000000);
        }
        res=res.trim();
        System.out.println("    res = " + res);
        return res;
    }

    public static void main(String args[]){
        Solution_best sb = new Solution_best();

        int num = 123;
        sb.numberToWords(num);

    }
}
