package ru.home.lesson1.homework1;

public class Cross implements Obstacle {
    private final int distance;

    public Cross(int distance) {
        this.distance = distance;
    }

    @Override
    public void participate(ParticipantProfile participant) {
        participant.run(distance);
    }
}
