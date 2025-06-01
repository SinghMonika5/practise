package practice.DesignPatterns;

public class BuilderPattern {

    public static void main(String[] args) {

        BuilderPatternDemo obj1 = new BuilderPatternDemo.Builder()
                .setField1(10)
                .setField2("Hello")
                .build();

        BuilderPatternDemo obj2 = new BuilderPatternDemo.Builder()
                .setField1(20)
                .build();

        BuilderPatternDemo obj3 = new BuilderPatternDemo.Builder()
                .setField1(1)
                .setField2("One")
                .setField3(1.0)
                .build();



// obj1 has field1=10, field2="Hello", and other fields uninitialized
// obj2 has field1=20, field2=null, and other fields uninitialized

    }


}


class BuilderPatternDemo {
    // 30 fields
    private int field1;
    private String field2;
    private double field3;
    // ... (other fields)

    // Private constructor to prevent direct instantiation
    private BuilderPatternDemo(Builder builder) {
        // Assign values from the builder to the fields
        this.field1 = builder.field1;
        this.field2 = builder.field2;
        this.field3 = builder.field3;
        // ... (assign other fields)
    }

    // Static nested Builder class
    public static class Builder {
        // Fields corresponding to the main class
        private int field1;
        private String field2;
        private double field3;
        // ... (other fields)

        // Builder methods to set the values for individual fields
        public Builder setField1(int field1) {
            this.field1 = field1;
            return this;
        }

        public Builder setField2(String field2) {
            this.field2 = field2;
            return this;
        }

        public Builder setField3(double field3){
            this.field3 = field3;
            return this;
        }

        // ... (other builder methods)

        // Method to build the final object
        public BuilderPatternDemo build() {
            return new BuilderPatternDemo(this);
        }
    }
}

