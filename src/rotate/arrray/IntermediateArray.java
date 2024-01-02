package rotate.arrray;

import java.util.Arrays;

/*Problem: Rotate an array of n elements to the right by k steps. For example, with n
        = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

        In a straightforward way, we can create a new array and then copy elements to the
        new array. Then change the original array by using System.arraycopy().

        Space is O(n) and time is O(n).*/


public class IntermediateArray {

    public static void main (String[] args){
        int[] ints = new int[]{1,2,3,4,5,6};
        Arrays.stream(reverse(ints,2)).forEach(System.out::print);
        //Arrays.stream(ints).forEach(System.out::print);
    }

    public static int[] reverse(int [] nums, int k){
        if(k>nums.length)
            k= k %nums.length;

        int[] result = new int [nums.length];

        for(int i =0; i<k ; i++){
            result[i] =nums[nums.length-k+i];
        }
        int j=0;
        for(int i =k;i<nums.length;i++){
            result[i] = nums[j];
            j++;
        }
        //System.arraycopy(result,0,nums,0,nums.length);
        int[] newArray =Arrays.copyOf(result,nums.length);
        return newArray;
    }
}
