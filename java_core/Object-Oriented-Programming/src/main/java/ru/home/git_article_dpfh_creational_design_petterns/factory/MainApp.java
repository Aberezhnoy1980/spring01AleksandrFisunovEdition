package ru.home.git_article_dpfh_creational_design_petterns.factory;

public class MainApp {

    public static void main(String[] args) {
        Door door = DoorFactory.makeDoor(100, 200);
        System.out.println("door created\n width: " + door.getWidth() + "\nheight: " + door.getHeight() + "\nsqr: " + (door.getWidth())* door.getHeight());

        Door door2 = DoorFactory.makeDoor(50, 50);
        System.out.println("door created\n width: " + door2.getWidth() + "\nheight: " + door2.getHeight() + "\nsqr: " + (door2.getWidth())* door2.getHeight());
    }
}
