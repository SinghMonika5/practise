package practice;

public class SecondHighestElement {
    public static void main(String[] args) {
        int a[]={6,6,6,6};
        int second=Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        for(int b:a){
          if(b>max){
            second=max;
            max=b;
          }
          else if(second<b && b!=max)
              second=b;
            }

        if(second==Integer.MIN_VALUE){
            System.out.println("there is no second element");
        }
        else{
            System.out.println("second element:"+second);

        }


        }




}
