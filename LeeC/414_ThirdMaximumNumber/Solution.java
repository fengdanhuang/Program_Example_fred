


class Solution {
    
    public int thirdMax(int[] a) {
       
        for(int i=0; i<a.length; i++)
            System.out.print(a[i] + "  ");
        System.out.println();
 
        System.out.println("Integer.MIN_VALUE = " + Integer.MIN_VALUE);
         
        int m1=Integer.MIN_VALUE, m2=m1, m3=m1,c=0;
        
        
        for (int d:a) {
            if ((d == m1 && c > 0) || (d == m2 && c > 1)) continue;

            if (d > m1) {
                m3 = m2;
                m2 = m1;
                m1 = d;
                c++;
            } else if (d > m2) {
                m3 = m2;
                m2 = d;
                c++;
            } else if (d >= m3) {
                m3 = d;
                c++;
            }
        }
        
        int re;
        if(c>=3) re=m3;
        else re=m1;
        System.out.println("re = " + re + "\n");
        return re; 
    }

    public static void main(String args[]){
        Solution s = new Solution();

        int[] a = new int[]{3, 2, 1};
        s.thirdMax(a);

        a = new int[]{1, 2};
        s.thirdMax(a);
        
        a = new int[]{2, 2, 3, 1};
        s.thirdMax(a);

    }
}
