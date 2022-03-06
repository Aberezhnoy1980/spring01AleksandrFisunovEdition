package ru.home.spring_context.entities;

import org.springframework.stereotype.Component;


public class ColorCameraRoll implements CameraRoll {
    @Override
    public void processing() {
        System.out.println("-1 цветной кадр");
    }
}
