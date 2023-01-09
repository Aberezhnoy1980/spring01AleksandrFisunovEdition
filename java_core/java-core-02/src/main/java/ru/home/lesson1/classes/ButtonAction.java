package ru.home.lesson1.classes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonAction implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(1);
    }
}
