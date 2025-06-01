package practice;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};

        int min=0;
        int max = arr.length-1;
        int mid = (min+max)/2;
        int target=4;

        while(max>=min){
            if(arr[mid] == target){
                System.out.println("found at "+mid);
                break;
            }

            if(target > arr[mid]){
                min=mid+1;
            }

            if(target < arr[mid]){
                max=mid-1;
            }

            mid=(min+max)/2;

        }



    }
}
