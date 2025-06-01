package practice.ReflectionAPI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

class Person{

    private String imutableName;
    public Person(String imutableName){
        this.imutableName = imutableName;
    }


    public String getImutableName(){
        return imutableName;
    }

}

public class Test {



    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        // Get a reference to the class
        Class<?> clazz = Person.class;

        // Get a reference to the private field
        Field privateField = clazz.getDeclaredField("imutableName");

        // Set the field accessible
        privateField.setAccessible(true);

        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        // Create an instance of the class (assuming there's a no-args constructor)
        Object instance = constructor.newInstance("test");
        // Access the value of the private field
        Object fieldValue = privateField.get(instance);
        System.out.println("Private field value: " + fieldValue+" "+fieldValue.hashCode());
        fieldValue = "Apple";
        System.out.println("Private field value: " + fieldValue+" "+fieldValue.hashCode());
    }
}
