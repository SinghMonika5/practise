package practice;

public class Fabonacci {

    public static void fab1(int n){

        if(n < 1){
            System.out.println(1);
            return;
        }
        int first=0;
        int second=1;
        int res=0;
        while(res<n){
            res = first + second;
            first = second;
            second = res;
           // System.out.println(res);
        }

    }

    public static int fab2(int n){
        if(n < 1){
            return 1;
        }
        return (fab2(n-1)+fab2(n-2));

    }


    public static void generateFibonacci(int n) {
        System.out.print("Fibonacci Sequence up to " + n + ": ");
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    public static void main(String[] args) {

        //0,1,1,2,3,5,8,13,21
        int i = 10;

        //fab1(i);

        generateFibonacci(i);

    }


}
