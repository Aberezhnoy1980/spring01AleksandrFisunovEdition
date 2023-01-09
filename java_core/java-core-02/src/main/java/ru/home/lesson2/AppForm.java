package ru.home.lesson2;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AppForm extends JFrame {

    public AppForm() throws HeadlessException {
        setBounds(200,200,500,500);
        JButton jbutton = new JButton ("1");
        jbutton.addActionListener((e) -> {
            ReportMaker reportMaker = new ReportMaker();
            try {
                reportMaker.createReport("java-core-02/src/main/java/ru/home/lesson2/12345678910.txt", "some data");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "ERROR!!!!!!!!");
            }
        });
        setTitle("Application");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(jbutton);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AppForm();
    }

}
