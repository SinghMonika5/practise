package practice;

public class SumOfTwoElementInArray {
    public static void main(String[] args) {
        int[] arr = {1,5,3,6,8,10,34,1,22,4};

        int target=6;
        boolean found = false;
        for(int i=0;i<arr.length;i++){
            int part = target-arr[i];
            for(int j=i+1;j<arr.length;j++){
                if((part - arr[j]) == 0){
                    System.out.println(i+" - "+j);
                    found = true;
                    break;
                }
                if(found)break;

            }
        }



    }
}
