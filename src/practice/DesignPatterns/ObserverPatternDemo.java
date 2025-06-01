package practice.DesignPatterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();

        ConcreteObserver observer1 = new ConcreteObserver("Observer 1");
        ConcreteObserver observer2 = new ConcreteObserver("Observer 2");
        ConcreteObserver observer3 = new ConcreteObserver("Observer 3");

        subject.addObserver(observer1);
        subject.addObserver(observer2);

        subject.notifyObservers("Hello Observers!"); // This will notify observer1 and observer2

        subject.removeObserver(observer2);
        subject.addObserver(observer3);

        subject.notifyObservers("Updated Message!"); // This will notify observer1 and observer3
    }
}

interface Observer {
    void update(String message);
}



class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}



class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
