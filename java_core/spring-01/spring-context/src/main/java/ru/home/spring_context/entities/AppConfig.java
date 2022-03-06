package ru.home.spring_context.entities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.home.spring_context.entities.Camera;
import ru.home.spring_context.entities.CameraImpl;
import ru.home.spring_context.entities.CameraRoll;
import ru.home.spring_context.entities.ColorCameraRoll;

@Configuration
@ComponentScan("ru.home.spring_context")
public class AppConfig {

//    @Bean(name = "cameraRoll")
    public CameraRoll cameraRoll() {
        return new ColorCameraRoll();
    }

//    @Bean(name = "camera")
    public Camera camera(CameraRoll cameraRoll) {
        Camera camera = new CameraImpl();
        camera.setCameraRoll(cameraRoll);
        return camera;
    }
}
