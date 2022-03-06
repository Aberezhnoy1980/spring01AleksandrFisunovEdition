package java1.homework6;

public class MainApp {
    public static void main(String[] args) {
        Animal animal = new Animal("Animal", "Animal", "black", 1000, 1000, 1000);

        System.out.println(animal);

        Cat cat = new Cat("Cat", "Barsik", "white", 2, 200, 0);
        Dog dog = new Dog("Dog", "Bobik", "black", 3, 500, 10);
        cat.run(100);
        cat.swim(0);
        dog.swim(8);
        dog.run(600);
        System.out.println(cat.getCatsCount() + "\n" + dog.getDogsCount() + "\n" + Animal.getAnimalsCount());

    }

}
