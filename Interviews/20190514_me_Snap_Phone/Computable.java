

public class Computable{

    public boolean computable(int[] list, int target){
        if(list == null || list.length == 0) return false;
        return cal(list, 0, 0, target);
    }
    public boolean cal(int[] list, int i, int sum, int target){
        if (i == list.length){
            if(sum == target) return true;
            else return false;
        }else{ 
            return cal(list, i+1, sum + list[i], target) ||
                   cal(list, i+1, sum - list[i], target) ||
                   cal(list, i+1, sum * list[i], target) ||
                   cal(list, i+1, sum / list[i], target);
            
        }
    }

    public static void main(String args[]){
        int[] list = new int[]{1, 2, 3, 4};
        int target = 10;
        Computable ts = new Computable();
        if(ts.computable(list, target)) System.out.println("1, 2, 3, 4, target=10; true");
        else System.out.println("1, 2, 3, 4, target=10; false");

        target = 25;
        if(ts.computable(list, target)) System.out.println("1, 2, 3, 4, target=25; true");
        else System.out.println("1, 2, 3, 4, target=25; false");
       
        target = 100; 
        if(ts.computable(list, target)) System.out.println("1, 2, 3, 4, target=100; true");
        else System.out.println("1, 2, 3, 4, target=100; false");
    }
}

