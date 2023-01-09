package ru.home.lesson1.homework1;

public class Robot extends ParticipantProfile {

    public Robot(String name, int age, int runDistanceLimit, int jumpHeightLimit, int swimDistanceLimit) {
        super(name, age, runDistanceLimit, jumpHeightLimit, swimDistanceLimit);
    }

//    @Override
//    public void run(int distance) {
//        if (distance <= runDistanceLimit) {
//            System.out.println(name + " успешно пробежал");
//        } else {
//            System.out.println(name + " не смог пробежать");
//            onDistance = false;
//        }
//    }
//
//    @Override
//    public void jump(int height) {
//        if (height <= jumpHeightLimit) {
//            System.out.println(name + " успешно перепрыгнул");
//        } else {
//            System.out.println(name + " не смог перепрыгнуть");
//            onDistance = false;
//        }
//    }
//
//    @Override
//    public void swim(int distance) {
//        if (distance <= swimDistanceLimit) {
//            System.out.println(name + " успешно проплыл");
//        } else {
//            System.out.println(name + " не смог проплыть");
//            onDistance = false;
//        }
//    }
//
//    @Override
//    public boolean isOnDistance() {
//        return onDistance;
//    }
}
