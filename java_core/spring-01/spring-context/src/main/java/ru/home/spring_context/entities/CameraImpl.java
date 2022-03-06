package ru.home.spring_context.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("camera")
public class CameraImpl implements Camera{

    @Autowired
    @Qualifier("cameraRoll")
    private CameraRoll cameraRoll;

    @Value("false")
    private boolean broken;

    @Value("X1")
    private String model;

    public CameraImpl() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public CameraRoll getCameraRoll() {
        return cameraRoll;
    }

    @Autowired
    @Override
    public void setCameraRoll(CameraRoll cameraRoll) {
        this.cameraRoll = cameraRoll;
    }

    @Override
    public boolean isBroken() {
        return broken;
    }

    @Override
    public void breaking(){
        this.broken = true;
    }

    @Override
    public void doPhotograph() {
        if(isBroken()) {
            System.out.println("Фотоаппарат сломан");
            return;
        }
        System.out.println("Сделана фотография");
        cameraRoll.processing();
    }
}
