package practice;// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class Buffer2{

    LinkedList<Integer> buffer = new LinkedList<>();
    int limit;
    
    public Buffer2(int limit){
        this.limit=limit;
    }
    
    public void produce(int i) throws InterruptedException{
        synchronized(this){
            while(buffer.size() == limit){
                wait();
            }
            System.out.println("produced : "+i+"\n");
            buffer.add(i);
            notifyAll();
        }
    }
    
        public void consume() throws InterruptedException{
        synchronized(this){
            while(buffer.isEmpty()){
                wait();
            }
            System.out.println("consumed : "+buffer.removeFirst()+"\n");
            notifyAll();
        }
    }
    
    
}

class Consumer2 implements Runnable{
    
    Buffer2 buffer;
    
    public Consumer2(Buffer2 buffer){
        this.buffer=buffer;
    }
    public void run(){
      
    
          for(int i=0;i<10;i++){
              try {
                  buffer.consume();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
          
    
    }
    
}


class Producer2 implements Runnable{
    
    Buffer2 buffer;
    
    public Producer2(Buffer2 buffer){
        this.buffer=buffer;
    }
    public void run(){
      
      try{
          for(int i=0;i<10;i++){
           buffer.produce(i);
           Thread.sleep(2000);
           }
          
      }catch(InterruptedException e){
          e.printStackTrace();
      }
      
    }
    
}

public class HelloWorld {
   
   public static void main(String[] args)throws InterruptedException {
   
    Buffer2 buffer = new Buffer2(3);
    Thread consumer = new Thread(new Consumer2(buffer));
    Thread producer = new Thread(new Producer2(buffer));
    
    consumer.start();
    producer.start();
     
       
    }
}