package practice;

import java.util.ArrayList;
import java.util.List;

public class MaxOfSubarray {
    public static void main(String[] args) {

//FIND MAXIMUM SUBARRAY OF SIZE 3
//You are given an array arr of integers and a positive integer k.
//The task is to find the maximum value for each contiguous subarray of size k in the given array.
//In other words, you need to find the maximum element within each window of size k as it slides through the array.
//The contiguous subarrays of size K=3 are as follows:
//
//[1, 2, 3] -> Maximum value is 3
//[2, 3, 1] -> Maximum value is 3
//[3, 1, 4] -> Maximum value is 4
//[1, 4, 5] -> Maximum value is 5
//[4, 5, 2] -> Maximum value is 5
//[5, 2, 3] -> Maximum value is 5
//[2, 3, 6] -> Maximum value is 6

        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<arr.length;i++){

            int start = i;
            int end = i+3;
            int max = 0;
            for(int j=start;j<end;j++){
                if(max < arr[j]){
                    max = arr[j];
                }
                // System.out.print(arr[j]+",");
            }
            list.add(max);
            if (end == arr.length)break;
            System.out.println();

        }

        System.out.println(list);



    }
}
