package practice;

public class FindMissingElement {

    public static void main(String[] args){

        int[] arr = {2,1,5,3,7,6,9,8,0};
        for(int i=0;i<arr.length;i++){

            for(int j=i+1;j<arr.length;j++){
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int i:arr){
            System.out.println(i);
        }

        for(int i=0;i<arr.length-1;i++){
            if(arr[i] != arr[i+1]-1){
                System.out.println("missing number is : "+(arr[i]+1));
                break;
            }
        }
    }
}
