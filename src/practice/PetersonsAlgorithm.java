package practice;

public class PetersonsAlgorithm {

    static boolean[] interested = {false,false};
    static int turn = 0;

    static class Process implements Runnable {

        private final int id;
        public Process(int id){
            this.id=id;
        }

        public void run(){

            //Entry section
            interested[id]=true;
            turn =  1 - id;
            while (interested[1-id] && turn == 1-id){
                //wait
                System.out.println("Process "+id+" is waiting turn is : "+turn);
            }
            //critical section
            for (int i = 0;i<10;i++)
            System.out.println("Process "+id+" is in the critical section");
            //exit section
            interested[id] = false;
        }

    }

    public static void main(String[] args){
        Thread p0 = new Thread(new Process(0));
        Thread p1 = new Thread(new Process(1));

        p0.start();
        p1.start();

        try {
            p0.join();
            p1.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
