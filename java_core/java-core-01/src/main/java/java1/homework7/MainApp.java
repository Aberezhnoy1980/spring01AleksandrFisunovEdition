package java1.homework7;

public class MainApp {
    public static void main(String[] args) {
        Plate plate = new Plate(100, 100);

        Cat[] cats = {new Cat("Barsik", 15),
                new Cat("Mursik", 15),
                new Cat("Tarzan", 10),
                new Cat("Pushok", 8),
                new Cat("Snezhok", 25),
                new Cat("Tigrenok", 15),
                new Cat("Koshak", 15),
        };
        for (Cat c : cats) {
            c.eat(plate);
        plate.info();
        }
    }
}
