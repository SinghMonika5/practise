package practice.FactoryPattern;

public interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

class ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("Circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("Square")) {
            return new Square();
        } else {
            throw new IllegalArgumentException("Invalid shape type: " + shapeType);
        }
    }
}

class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.createShape("Circle");
        circle.draw();

        Shape rectangle = shapeFactory.createShape("Rectangle");
        rectangle.draw();

        Shape square = shapeFactory.createShape("Square");
        square.draw();
    }
}
