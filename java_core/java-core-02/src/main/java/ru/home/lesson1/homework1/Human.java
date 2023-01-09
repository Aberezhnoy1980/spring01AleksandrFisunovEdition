package ru.home.lesson1.homework1;

public class Human extends ParticipantProfile {
//    private final String name;
//    private final int age;
//    private final int runDistanceLimit;
//    private final int jumpHeightLimit;
//    private final int swimDistanceLimit;
//    public boolean onDistance;

//    Human(String name, int age, int runDistanceLimit, int jumpHeightLimit, int swimDistanceLimit) {
//        super(name, age, runDistanceLimit, jumpHeightLimit, swimDistanceLimit);
//    }

    public static class HumanBuilder extends ParticipantProfile {
//        private String name;
//        private int age;
//        private int runDistanceLimit;
//        private int jumpHeightLimit;
//        private int swimDistanceLimit;

        public HumanBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public HumanBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public HumanBuilder setRunDistanceLimit(int runDistanceLimit) {
            this.runDistanceLimit = runDistanceLimit;
            return this;
        }

        public HumanBuilder setJumpHeightLimit(int jumpHeightLimit) {
            this.jumpHeightLimit = jumpHeightLimit;
            return this;
        }

        public HumanBuilder setSwimDistanceLimit(int swimDistanceLimit) {
            this.swimDistanceLimit = swimDistanceLimit;
            return this;
        }

        public HumanBuilder setOnDistance(boolean onDistance) {
            this.onDistance = true;
            return this;
        }

        public Human createHuman() {
            return Human.createHuman(name, age, runDistanceLimit, jumpHeightLimit, swimDistanceLimit);
        }
    }

    private Human(String name, int age, int runDistanceLimit, int jumpHeightLimit, int swimDistanceLimit) {
        super(name, age, runDistanceLimit, jumpHeightLimit, swimDistanceLimit);
    }

    static Human createHuman(String name, int age, int runDistanceLimit, int jumpHeightLimit, int swimDistanceLimit) {
        return new Human(name, age, runDistanceLimit, jumpHeightLimit, swimDistanceLimit);
    }

//    public Human(String name, int age, int runDistanceLimit, int jumpHeightLimit, int swimDistanceLimit, boolean onDistance) {
//        this.name = name;
//        this.age = age;
//        this.runDistanceLimit = runDistanceLimit;
//        this.jumpHeightLimit = jumpHeightLimit;
//        this.swimDistanceLimit = swimDistanceLimit;
//        this.onDistance = true;
//    }

//    @Override
//    public void run(int distance) {
//        if(distance <= runDistanceLimit) {
//            System.out.println(name + " успешно пробежал");
//        } else {
//            System.out.println(name + " не смог пробежать");
//            onDistance = false;
//        }
//    }
//
//    @Override
//    public void jump(int height) {
//        if(height <= jumpHeightLimit) {
//            System.out.println(name + " успешно перепрыгнул");
//        } else {
//            System.out.println(name + " не смог перепрыгнуть");
//            onDistance = false;
//        }
//    }
//
//    @Override
//    public void swim(int distance) {
//        if(distance <= swimDistanceLimit) {
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
