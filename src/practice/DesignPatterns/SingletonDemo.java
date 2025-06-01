package practice.DesignPatterns;

public class SingletonDemo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            Singleton s = Singleton.getInstance();
            System.out.println(s);
        });

        Thread t2 = new Thread(()->{
            Singleton s = Singleton.getInstance();
            System.out.println(s);
        });

        t1.start();
        t2.start();
    }
}

class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Private constructor to prevent instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
