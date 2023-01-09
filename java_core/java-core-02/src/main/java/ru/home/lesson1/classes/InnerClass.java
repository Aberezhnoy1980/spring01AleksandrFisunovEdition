package ru.home.lesson1.classes;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InnerClass {
    public static void main(String[] args) {
        JButton button = new JButton("1");
        button.addActionListener(new ButtonAction());

        JButton button2 = new JButton("2");
        button2.addActionListener(new ButtonAction2());

        JButton button3 = new JButton("3");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(3);
            }
        });

        // public class Calendar$1 implements ActionListener {
        //      @Override
        //      public void actionPerformed(ActionEvent e) {
        //          System.out.println(3);
        //      }
        // }
        // Calendar$1 anonymousObject = new Calendar$1();
        // button3.addActionListener(anonymousObject);

        JButton jb = new JButton("55");
        jb.addActionListener(actionEvent -> System.out.println(55));

    }
}
