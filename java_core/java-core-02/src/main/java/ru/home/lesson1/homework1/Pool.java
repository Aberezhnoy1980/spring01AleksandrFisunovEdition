package ru.home.lesson1.homework1;

public class Pool implements Obstacle {
    private int distance;

    public Pool(int distance) {
        this.distance = distance;
    }

    @Override
    public void participate(ParticipantProfile participant) {
        participant.swim(distance);
    }
}
