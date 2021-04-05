package ru.nsu.dyuganov.trongame.View;

import javax.swing.*;
import java.awt.*;

public class GUI implements Runnable {
    // logger

    @Override
    public void run() {
        System.out.println("Running GUI thread");
        JFrame frame = new JFrame("Game test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("src/main/resources/main_game_grid.png"); // grid
        Image scaleImg = icon.getImage().getScaledInstance(1280, 720, Image.SCALE_FAST); // scale grid
        frame.getContentPane().add(new JLabel(new ImageIcon(scaleImg))); // add grid img
        frame.getContentPane().setBackground(new java.awt.Color(11, 20, 28)); // background colour
        frame.setMinimumSize(new Dimension(1280, 720));
        frame.pack();
        frame.setVisible(true);
        System.out.println("GUI thread finished");
    }
}
