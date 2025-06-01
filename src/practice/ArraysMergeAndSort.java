package practice;

import java.util.Arrays;

public class ArraysMergeAndSort {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};
        int[] resultArr = new int[arr.length+arr2.length];



        for(int i=0;i<arr.length;i++){
            resultArr[i]=arr[i];
        }

        int index = arr.length;

        for(int i=0;i<arr2.length;i++){
            resultArr[index+i]=arr2[i];
        }

//bubble sort
/*
        for(int i=0;i<resultArr.length;i++){
            for(int j=1+i;j<resultArr.length;j++){

                if(resultArr[i] > resultArr[j]){

                    int temp = resultArr[i];
                    resultArr[i] =resultArr[j];
                    resultArr[j] = temp;

                }

            }

        }
  */




        Arrays.stream(resultArr).sorted().forEach(n-> System.out.print(n+", "));



    }
}
