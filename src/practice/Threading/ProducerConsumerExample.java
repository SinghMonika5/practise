package practice.Threading;

import java.util.LinkedList;

public class ProducerConsumerExample {

    public static void main(String[] args) {
        Buffer buffer = new Buffer(2);
        Thread p = new Thread(new Producer(buffer));
        Thread c = new Thread(new Consumer(buffer));
        p.start();
        c.start();

    }
}

class Buffer{


    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity;

    public Buffer(int capacity){
        this.capacity=capacity;
    }

    public void produce(int value)throws InterruptedException{

        synchronized(this){
            while (buffer.size() == capacity){
                System.out.println("Buffer full");
                wait();//wait if buffer is full
            }
            buffer.add(value);
            System.out.println("Produced : "+value);
            notifyAll();
        }
    }

    public void consume()throws InterruptedException{
        synchronized(this){
            while (buffer.isEmpty()){
                wait();//wait for buffer to have some value
            }
            int value = buffer.removeFirst();
            System.out.println("Consumed : "+value);
            notifyAll();
        }
    }

}
class Producer implements Runnable{
    private Buffer buffer;

    public Producer(Buffer buffer){
        this.buffer=buffer;
    }

    public void run(){
        try
        {
            for (int i=0;i<10;i++){
                buffer.produce(i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    private Buffer buffer;
    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }

    public void run(){
        try {
            for (int i = 0;i<10;i++){
                buffer.consume();
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
