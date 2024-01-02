package rotate.arrray;

import java.util.Arrays;

/*In a straightforward way, we can create a new array and then copy elements to the
        new array. Then change the original array by using System.arraycopy().

        Space is O(n) and time is O(n).*/
public class Reversal {

    public static void main (String [] args) {
        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        rotate(intArray, 3);

        Arrays.stream(intArray).forEach(System.out::print);
    }

    public static void rotate (int[] arr, int order) {
        if(arr ==null|| arr.length ==0 || order <0){
            throw new IllegalArgumentException("Illegal argument");
        }
        if(order >arr.length)
            order = arr.length%order;

        int a = arr.length - order;

        reverse(arr, 0,a-1);
        reverse(arr, a,arr.length-1);
        reverse(arr, 0,arr.length-1);
    }


    public static void reverse(int [] arr, int left, int right) {
        if(arr == null || arr.length ==1)
            return;
        while (left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left ++;
            right --;
        }
    }
}
