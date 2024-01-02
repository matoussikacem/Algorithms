package rotate.arrray;

//However, the time is O(n*k).
//space O(1)
public class BubbleRotate {


    public static void rotate(int [] arr, int order) {
        if(arr ==null || arr.length ==0 || order<0)
            throw new IllegalArgumentException("Illegal argument");

        for(int i =0;i<order;i++){
            for (int j = arr.length-1;j>0;j--){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] =temp;
            }
        }
    }
}
