package ru.home.spring_context.entities;

import org.springframework.stereotype.Component;

@Component("cameraRoll")
public class BlackAndWhiteCameraRoll implements CameraRoll {
    @Override
    public void processing() {
        System.out.println("-1 черно-белый кадр");
    }
}
