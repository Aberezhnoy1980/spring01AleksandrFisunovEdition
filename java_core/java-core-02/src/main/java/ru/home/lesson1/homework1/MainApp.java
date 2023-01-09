package ru.home.lesson1.homework1;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        ParticipantProfile[] participants = {
                Human.createHuman("Bob", 20, 1000,2,25),
                new Human.HumanBuilder().setName("Steve").setAge(30).setRunDistanceLimit(300).setJumpHeightLimit(1).setSwimDistanceLimit(35).setOnDistance(true),
                new Cat("Bars", 2, 500, 3, 0),
                new Robot("Robo", 1, 10000, 1, 1000)
        };

        Obstacle[] obstacles = {
                new Cross(100),
                new Wall(2),
                new Pool(20)
        };

        System.out.println("Встречайте наших спортсменов!" + "\n" + Arrays.toString(participants) + "\n" + "Старт!!");

        for (ParticipantProfile p : participants) {
            for (Obstacle o : obstacles) {
                o.participate(p);
                if (!p.isOnDistance()) {
                    break;
                }
            }
        }

        for (ParticipantProfile p : participants) {
            if (p.isOnDistance()) {
                System.out.println("\nВстречайте победителя сегодняшних соревнований!\n" + p.name);
            }
        }
    }
}
