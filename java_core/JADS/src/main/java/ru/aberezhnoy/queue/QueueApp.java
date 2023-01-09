package ru.aberezhnoy.queue;

public class QueueApp {
    public static void main(String[] args) {
        Queue<Integer> queue = new QueueImpl<>(5);
        queue.insert(10);
        queue.insert(20);
        queue.insert(30);
        queue.insert(40);
        queue.insert(50);

        System.out.println(queue.getSize());

        queue.display();

        queue.remove();
        queue.remove();

        System.out.println(queue.getSize());

        queue.display();

        queue.insert(50);
        queue.insert(60);
        queue.insert(70);
        queue.insert(80);

        System.out.println(queue.getSize());

        queue.display();

        while (!queue.isEmpty()) {
            int n = queue.remove();
            System.out.println(n);
        }

        System.out.println(queue.getSize());

        queue.insert(1);
        queue.insert(1);
        queue.insert(1);
        queue.insert(1);
        queue.insert(1);

        System.out.println(queue.getSize());

        queue.display();
    }
}
