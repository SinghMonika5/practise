package practice.DesignPatterns;

public class FactoryPatternDemo {
    public static void main(String[] args) {

        Product p1 = ProductFactory.createProduct("A");
        p1.create();
        Product p2 = ProductFactory.createProduct("B");
        p2.create();
    }
}

interface Product {
    void create();
}

class ConcreteProductA implements Product {
    @Override
    public void create() {
        System.out.println("Creating Product A");
    }
}

class ConcreteProductB implements Product {
    @Override
    public void create() {
        System.out.println("Creating Product B");
    }
}

class ProductFactory {
    public static Product createProduct(String type) {
        if (type.equals("A")) {
            return new ConcreteProductA();
        } else if (type.equals("B")) {
            return new ConcreteProductB();
        }
        return null;
    }
}

