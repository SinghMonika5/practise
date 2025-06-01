package practice;

public class FindMissingElementOptimised {

    public static void main(String[] args){

        int[] arr = {2,1,5,3,7,6,9,8};

        int sum = 0;
        for(int num:arr){
            sum += num;
        }

        int n = arr.length+1;//+1 if not starting from 0
        int expectedSum = (n*(n+1))/2;

        int missing = expectedSum-sum;
        System.out.println(missing);



    }
}
