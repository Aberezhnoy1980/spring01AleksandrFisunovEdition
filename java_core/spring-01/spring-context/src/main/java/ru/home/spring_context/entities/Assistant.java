package ru.home.spring_context.entities;

public class Assistant {

    CameraImpl cameraImpl = new CameraImpl();
    CameraRoll colorCameraRoll = new ColorCameraRoll();
    CameraRoll blackAndWhiteCameraRoll = new BlackAndWhiteCameraRoll();

    public CameraImpl getCamera() {
        cameraImpl.setCameraRoll(blackAndWhiteCameraRoll);
        return cameraImpl;
    }

//    public Assistant (Camera camera, ColorCameraRoll colorCameraRoll) {
//        this.camera = camera;
//        this.colorCameraRoll = colorCameraRoll;
//    }

//    public void setCamera(Camera camera) {
//        this.camera = camera;
//    }


}

