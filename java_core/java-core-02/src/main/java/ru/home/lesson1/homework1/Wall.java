package ru.home.lesson1.homework1;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void participate(ParticipantProfile participant) {
        participant.jump(height);
    }
}
