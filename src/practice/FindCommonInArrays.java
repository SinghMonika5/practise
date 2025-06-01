package practice;

import java.util.Arrays;

public class FindCommonInArrays {

    public static void main(String[] args) throws InterruptedException{

        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5,6,7};
        int[] resultArr = new int[Math.min(arr.length,arr2.length)];
        int index=0;
       for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr2.length;j++){
               if(arr[i] == arr2[j]){
                   resultArr[index++] = arr[i];
                   break;
               }
            }
        }
        resultArr = Arrays.copyOf(resultArr,index);
        Arrays.stream(resultArr).forEach(i-> System.out.println(i));


        //USING JAVA8
        resultArr  = Arrays.stream(arr).filter(num -> Arrays.stream(arr2).anyMatch(n-> n == num)).distinct().toArray();

    }

}
