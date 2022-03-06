package java1.homework7;

public class Plate {
    private int capacity;
    private int food;

    public Plate(int capacity, int food) {
        this.capacity = capacity;
        this.food = food;
    }

    public int getFood () {
        return food;
    }

    public void decreaseFood(int amount) {
        food -= amount;
        if (food < 0) {
            food = 0;
            System.out.println("plate is empty. Please, fill the plate");
        }
    }

    public void fill(int amount) {
        food += amount;
        if (food > capacity) {
            food = capacity;
            System.out.println("plate is full and the food spills out");
        }
    }

    public void info() {
        System.out.printf("plate: %d / %d\n", food, capacity);
    }

}
