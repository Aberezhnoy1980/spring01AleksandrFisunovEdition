package ru.home.generics;

public class Generics {

    public static void main(String[] args) {

        // Through to creation instance of object class
        SimpleBox simpleBox1 = new SimpleBox(20);
        SimpleBox simpleBox2 = new SimpleBox(40);

        if (simpleBox1.getObject() instanceof Integer && simpleBox2.getObject() instanceof Integer) {
            int sum = (Integer) simpleBox1.getObject() + (Integer) simpleBox2.getObject();
            System.out.println("sum = " + sum);
        } else {
            System.out.println("Box contains different types");
        }

//        simpleBox1.setObject("Java");
//        int secondSum = (Integer) simpleBox1.getObject() + (Integer) simpleBox2.getObject();

        // Through to use generics
        TestGeneric<String> genStr = new TestGeneric<>("Hello");
        genStr.showType();
        System.out.println("genStr.getObject(): " + genStr.getObject());
        TestGeneric<Integer> genInt = new TestGeneric<>(140);
        genInt.showType();
        System.out.println(("genInt.getObject(): " + genInt.getObject()));
        int valueFromGenString = genInt.getObject();
//        genInt.setObject("Java"); // Compilation error

        TwoGen<Integer, String> twoGenObject = new TwoGen<>(555, "Hello");
        twoGenObject.showType();
        int intValue = twoGenObject.getObject1();
        String strValue = twoGenObject.getObject2();
        System.out.println(intValue);
        System.out.println(strValue);

        Stats<Integer> intStats = new Stats<>(1, 2, 3, 4, 5);
        System.out.println(("Average value intStats is: " + intStats.avg()));
        Stats<Double> doubleStats = new Stats<>(1.0, 2.0, 3.0, 4.0, 5.0);
        System.out.println("Average value doubleStats is: " + doubleStats.avg());
        // Stats<String> stringStats = new Stats<>(1, 2, 3, 4, 5); // String is not a child of Number super class
        // System.out.println("Average value stringStats is: " + stringStats.avg());

//        Stats<Integer> integerStats = new Stats<>(1, 2, 3, 4, 5);
//        Stats<Double> doubleStats1 = new Stats<>(1.0, 2.0, 3.0, 4.0, 5.0);
//        if (integerStats.sameAvg(doubleStats1)) {
//            System.out.println("Average values is equals");
//        } else {
//            System.out.println("Average values isn't equals");
//        }

        Stats<Integer> integerStats = new Stats<>(1, 2, 3, 4, 5);
        Stats<Integer> integerStats1 = new Stats<>(2, 1, 3, 4, 5);
        Stats<Double> doubleStats1 = new Stats<>(1.0, 2.0, 3.0, 4.0, 5.0);
        System.out.println(integerStats.sameAvg(integerStats1));
//        System.out.println(integerStats.sameAvg(doubleStats1)); // error
//        (T = Integer) != (T = Double)

        Stats<Integer> iStats = new Stats<>(1, 2, 3, 4, 5);
        System.out.println("Average value iStats is: " + iStats.avg());
        Stats<Double> dStats = new Stats<>(1.1, 2.2, 3.3, 4.4, 5.5);
        System.out.println("Average value dStats is: " + dStats.avg());
        Stats<Float> fStats = new Stats<>(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        System.out.println("Average value fStats is: " + fStats.avg());

        System.out.println("Average values iStats and dStats");
        if (iStats.wildCardSameAvg(dStats)) {
            System.out.println("Equal");
        } else {
            System.out.println("Different");
        }

        System.out.println("Average values iStats and fStats");
        if (iStats.wildCardSameAvg(fStats)) {
            System.out.println("Equal");
        } else {
            System.out.println("Different");
        }
    }

    // Hard way
    private static class SimpleBox {
        private Object object;

        public SimpleBox(Object object) {
            this.object = object;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }
    }

    // Right way
    private static class TestGeneric<T> {
        private T object;

        public TestGeneric(T object) {
            this.object = object;
        }

        public T getObject() {
            return object;
        }

        public void setObject(T object) {
            this.object = object;
        }

        public void showType() {
            System.out.println("Type T: " + object.getClass().getName());
        }
    }

    private static class TwoGen<T, V> {
        private T object1;
        private V object2;

        public TwoGen(T object1, V object2) {
            this.object1 = object1;
            this.object2 = object2;
        }

        public void showType() {
            System.out.println("Type T: " + object1.getClass().getName());
            System.out.println("Type V: " + object2.getClass().getName());

        }

        public T getObject1() {
            return object1;
        }

        public V getObject2() {
            return object2;
        }
    }

    private static class Stats<T extends Number> {
        private T[] numbers;

        public Stats(T... numbers) {
            this.numbers = numbers;
        }

        public double avg() {
            double sum = 0.0;
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i].doubleValue();
            }
            return sum / numbers.length;
        }

        public boolean sameAvg(Stats<T> another) {
            return Math.abs(this.avg() - another.avg()) < 0.0001;
        }

        public boolean wildCardSameAvg(Stats<?> another) {
            return Math.abs(this.avg() - another.avg()) < 0.0001;
        }
    }
}
