

//Note: Don't create a char array, directly print. Because the char array will take a very large space.

public class Solution{


    void printX(int n){

        for(int i=0; i<n; i++){

            for(int j=0; j<n; j++){
                if(i==j || i+j==(n-1)) System.out.print("X");
                else System.out.print(" ");
            }
            System.out.println();
        }

        System.out.println("\n");
    }

    void printO(int n){
        help(n, 0, 0);
        System.out.println("\n");
    }


    void help(int n, int i, int j){
        
        if (i==n && j==n) return;
        
        if(j<n){
            if(i==j || i+j==(n-1)) System.out.print("*");
            else System.out.print(" ");
            j++;
        }else{
            System.out.println();
            j=0;
            i++;
        }
        
        //System.out.println("help("+n+","+i+","+j+")");
        help(n,i,j);     
    }
        
    public static void main(String args[]){
        Solution sol = new Solution();

        sol.printX(1);
        sol.printX(2);
        sol.printX(5);
        sol.printX(10);

        sol.printO(1);
        sol.printO(2);
        sol.printO(3);
        sol.printO(5);
        sol.printO(6);
        sol.printO(10);
    }

}
